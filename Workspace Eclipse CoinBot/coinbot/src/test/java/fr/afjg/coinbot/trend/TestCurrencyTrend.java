package fr.afjg.coinbot.trend;

import java.sql.Timestamp;

import fr.afjg.coinbot.pojo.datatprocessing.CurrenciesTrendsBot;

public class TestCurrencyTrend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instance de currencies trend bot reprend toutes les dernières tendances des cryptos
		CurrenciesTrendsBot cTB = CurrenciesTrendsBot.getInstance();
		
		/*Timestamp t1 = new Timestamp(System.currentTimeMillis());
		Timestamp t2 = new Timestamp(1511588205229);
		System.out.println(System.currentTimeMillis());
		System.out.println(t1);
		System.out.println(t1.getTime());
		*/
		Thread t = new Thread(cTB);
		t.start();
		
		
	}

}
