package fr.afgj.coinbot.order;

import java.util.List;

import fr.afgj.coinbot.calculation.impl.CurrenciesTrendsBot;
import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.service.impl.UserServiceImpl;

public class OrderToBuy implements Runnable {

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
			List<User> users = userServiceImpl.findAllUsers();

			// stage

		}

	}

}
