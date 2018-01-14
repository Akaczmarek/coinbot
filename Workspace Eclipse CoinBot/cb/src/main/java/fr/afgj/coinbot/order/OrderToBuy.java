package fr.afgj.coinbot.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afgj.coinbot.calculation.impl.CurrenciesTrendsBot;
import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.entity.OrderHistoryBot;
import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.entity.UserConfiguration;
import fr.afgj.coinbot.external.api.intf.IBittrexPublic;
import fr.afgj.coinbot.rule.impl.BetRule1;
import fr.afgj.coinbot.service.IApiKeyService;
import fr.afgj.coinbot.service.IOrderHistoryBotService;
import fr.afgj.coinbot.service.IUserConfigurationService;
import fr.afgj.coinbot.service.IUserService;

@Component
public class OrderToBuy implements Runnable {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private IUserService userService;
	@Autowired
	private IOrderHistoryBotService orderHistoryBotService;
	@Autowired
	private IUserConfigurationService userConfigurationService;
	@Autowired
	private BetRule1 betRule;
	@Autowired
	private IBittrexPublic bittrexPublic;
	@Autowired
	private IApiKeyService apiKeyService;

	public OrderToBuy() {

		
	}

	@Override
	public void run() {

		CurrenciesTrendsBot currenciesTrendsBot = CurrenciesTrendsBot.getInstance();

		while (true) {
			// Stage 0 : loading currencyiestrendToBuy and the best currency to buy
			List<CurrencyTrend> currencyTrendsToBuy = currenciesTrendsBot.getCurrenciesTrendsOrderByNoteToBuy();
			if (currencyTrendsToBuy.size() > 0) {
				Currency theBestCurrencyTobuy = currencyTrendsToBuy.get(0).getCurrency();

				// Stage 1 : who can buy?
				// user with positive account
				// user with last bet is during
				Date refDateWithoutBet = new Date(System.currentTimeMillis() - betRule.getDurationNoBet().getTime());

				List<User> users = this.updateUserListForOrderToBuy(refDateWithoutBet);

				// stage 2 : make a purchase order

				for (User user : users) {
					this.makeOrderToBuy(theBestCurrencyTobuy, user);
				}
			}

			System.out.println("---------------------------------------");
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void makeOrderToBuy(Currency currency, User user) {
		// Stage 0 : initialization variable
		int idUser = user.getId();
		UserConfiguration uc;
		double betValue;
		double betFraction;
		double accountValue;
		double realBet;
		double askValue;
		
		// variables for order
		String apiKey ="";
		String market =""; 
		double quantity =-1.0;
		double rate =-1.0;
		
		//variables for persistence order
		Date dateSend;
		Date dateActivated;

		// Stage 1 : recover user configuration
		uc = userConfigurationService.findById(idUser);

		// Stage 2 : recover data of user configuration
		betValue = uc.getBetvalue();
		betFraction = uc.getBetfraction();

		
		// Stage 3 : check the value of an account with api bittrex
		
		
		//méthode pour vérifier la valeur d'un compte voir avec josé on injecte la valeurdans la variable suivante
		accountValue = 100.0;
		
		//Stage 4 : comparison data account and user configuration
		if (uc.getBetvalue()<= accountValue && uc.getBetfraction()<=accountValue) {
			// the account is properly stocked -> proceed to order to buy
			quantity = uc.getBetfraction();
			rate = currency.getLastCurrencyRateAskValue();
		}
		
		// Stage 5 : passage of a purchase order
		
		//méthode pour passer un ordre d'achat voir avec josé
		
		
		
		
		System.out.println("Passage d'une commande **********************************************************");
		System.out.println("user config userid : " + uc.getUser().getId() + " : betvalue " + uc.getBetvalue() + ", betFraction : " + uc.getBetfraction());
		System.out.println("currency: " + currency.getName());
		System.out.println("commande volume : " + quantity + ", valeur d'achat  : " + rate);
		System.out.println("fin commande ********************************************************************");
		
		
//		if (!"".equals(apiKey) && !"".equals(market) && quantity!=-1.0 && rate!= -1.0) {
//			
//			// Stage 5.0 : passage of a purchase order on api Bittrex
//			this.bittrexPublic.setOrderToBuy(apiKey, market, quantity, rate);
//			
//			
//			// Stage 5.1 :save order in bdd
//			
//			OrderHistoryBot orderHistoryBot = new OrderHistoryBot();
//			orderHistoryBot.setCurrency(currency);
//			orderHistoryBot.setUser(user);
//			orderHistoryBot.setCurrencyvalue(rate);
//			
//		}
		
		
		// Stage 6 : save order in bdd
		


		

	}

	private List<User> updateUserListForOrderToBuy(Date date) {
		// Stage 0 : create variable, recover the data
		List<User> users0 = this.userService.findByPositiveBetValue();
		List<OrderHistoryBot> orderHistoryBots = this.orderHistoryBotService.findLastOrderToBuyByUser();
		List<User> users1 = new ArrayList<>();

		// stage 1 : retain users whose last order has passed since the date
		for (OrderHistoryBot orderHistoryBot : orderHistoryBots) {
			if (orderHistoryBot.getTimestampsend().getTime() < date.getTime()) {
				users1.add(orderHistoryBot.getUser());
			}
		}

		// Stage 2 : comparison between users0 and user1, we only keep the join on id.
		users0.retainAll(users1);
		System.out.println("liste de user retenu " + users0.size());

		return users0;

	}

	public static void main(String[] args) {
		List<User> nobre1 = new ArrayList<>();
		User u1 = new User(1);
		User u2 = new User(2);
		User u3 = new User(4);
		User u4 = new User(10);
		nobre1.add(u1);
		nobre1.add(u2);
		nobre1.add(u3);
		nobre1.add(u4);

		for (User user : nobre1) {
			System.out.println(user);
		}

		List<User> nobre2 = new ArrayList<>();
		User u21 = new User(1);
		User u22 = new User(3);
		User u23 = new User(5);
		User u24 = new User(10);
		nobre2.add(u21);
		nobre2.add(u22);
		nobre2.add(u23);
		nobre2.add(u24);

		// nobre1.addAll(nobre2);
		// for (Integer integer : nobre1) {
		// System.out.println(integer);
		// }
		nobre1.retainAll(nobre2);
		System.out.println("Tableau : " + nobre1.size() + "-----------------------------------");
		for (User user : nobre1) {

			System.out.println(user);

			System.out.println("date : -----------------------------------");
			BetRule1 betRule = new BetRule1();

			Date refDateWithoutBet = new Date(System.currentTimeMillis() - betRule.getDurationNoBet().getTime());

			System.out.println(refDateWithoutBet);

		}

	}

}
