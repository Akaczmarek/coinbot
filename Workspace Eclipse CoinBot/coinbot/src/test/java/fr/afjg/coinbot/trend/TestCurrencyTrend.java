package fr.afjg.coinbot.trend;

import fr.afjg.coinbot.entity.datatprocessing.CurrenciesTrendsBot;

public class TestCurrencyTrend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instance de currencies trend bot reprend toutes les dernières tendances des cryptos
		CurrenciesTrendsBot cTB = CurrenciesTrendsBot.getInstance();
		
		Thread t = new Thread(cTB);
		t.start();
		
		// test d'appel du service précédent de manière simultané
		
		
		TestAppel1Service ta1 = new TestAppel1Service();
		TestAppel2Service ta2 = new TestAppel2Service();
		
		Thread t1 = new Thread(ta1);
		t1.start();
		
		Thread t2 = new Thread(ta2);
		t2.start();
		
	}

}
