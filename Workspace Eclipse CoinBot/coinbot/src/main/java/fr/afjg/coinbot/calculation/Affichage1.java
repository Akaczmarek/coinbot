package fr.afjg.coinbot.calculation;

import fr.afjg.coinbot.entity.CurrencyTrend;

public class Affichage1 implements Runnable {

	CurrenciesTrendsBot ctb = CurrenciesTrendsBot.getInstance();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("*****************************************************");
			for (CurrencyTrend ct : ctb.getCurrenciesTrendsOrderByNoteToBuy()) {
				System.out.println("nom : " + ct.getName() + " note to buy :" + ct.getNoteToBuy());
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
