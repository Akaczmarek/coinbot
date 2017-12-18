package fr.afjg.coinbot.trend;

import fr.afjg.coinbot.entity.datatprocessing.CurrenciesTrendsBot;

public class TestAppel1Service implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		CurrenciesTrendsBot ctb =  CurrenciesTrendsBot.getInstance();

		
		for(int x = 0; x<1000; x++) {
			
			
			
			int val =(int)(Math.random() * (10)) + 5;
			try {
				Thread.sleep(val);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			System.out.println("test1 meilleur vente : " + ctb.getAllCurrenciesTrendsInOrderToSell().get(0).getName() );
		
		
		}
		
		
		
		
		
	}

}
