package fr.afjg.coinbot.trend;

import fr.afjg.coinbot.entity.datatprocessing.CurrenciesTrendsBot;

public class TestCurrencyTrend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instance de currencies trend bot reprend toutes les dernières tendances des cryptos
		CurrenciesTrendsBot cTB = CurrenciesTrendsBot.getInstance();
		

		Thread t = new Thread(cTB);
		t.start();
		
		
	}

}
