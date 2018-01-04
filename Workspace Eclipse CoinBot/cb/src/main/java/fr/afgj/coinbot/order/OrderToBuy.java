package fr.afgj.coinbot.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afgj.coinbot.calculation.impl.CurrenciesTrendsBot;
import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.service.impl.UserServiceImpl;

@Component
public class OrderToBuy implements Runnable {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			// Stage 0 : loading currenciesTrendsBot
			CurrenciesTrendsBot currenciesTrendsBot = CurrenciesTrendsBot.getInstance();
			List<CurrencyTrend> currencyTrends = currenciesTrendsBot.getCurrenciesTrendsOrderByNoteToBuy();

			// Stage 1 : who can buy?
			// user qui existe, avec un bet value positif -> dans ce cas il peut miser
			// on se fabrique une liste de qui peut miser
			List<User> users = userServiceImpl.findByPositiveBetValue();
			for (User user : users) {
				System.out.println(
						"user id :" + user.getId() + " name : " + user.getFirstname() + " userconfiguration betvalue");
			}

			// user qui existe, avec un bet value positif et qui est autorisé à miser par
			// rapport au dernier délai de mise

			// stage 2 :

			System.out.println("---------------------------------------");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
