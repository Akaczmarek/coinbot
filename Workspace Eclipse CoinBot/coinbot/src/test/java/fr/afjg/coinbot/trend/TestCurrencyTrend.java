package fr.afjg.coinbot.trend;

import java.util.List;

import fr.afjg.coinbot.entity.datatprocessing.CurrenciesTrendsBot;
import fr.afjg.coinbot.entity.datatprocessing.CurrencyTrend;

public class TestCurrencyTrend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// instance de currencies trend bot reprend toutes les dernières tendances des cryptos
		CurrenciesTrendsBot cTB = CurrenciesTrendsBot.getInstance();
		
		Thread t = new Thread(cTB);
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0 ; i<10; i++) {
			
			List<CurrencyTrend> list = cTB.getAllCurrenciesTrendsInOrderToBuy();
			
			System.out.println("-----------------------------------------------------");
			for (CurrencyTrend cr : list) {
				System.out.println(cr.getName() + " note d'achat " +  cr.getNoteCurrencyToBuy());
				System.out.println(cr.getName() + " note de vente " +  cr.getNoteCurrencyToSell());
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		// test d'appel du service précédent de manière simultané
		
		
//		TestAppel1Service ta1 = new TestAppel1Service();
//		TestAppel2Service ta2 = new TestAppel2Service();
//		
//		Thread t1 = new Thread(ta1);
//		t1.start();
//		
//		Thread t2 = new Thread(ta2);
//		t2.start();
//		
	}

}
