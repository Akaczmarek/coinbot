package fr.afjg.coinbot.trend2;

import fr.afjg.coinbot.calculation.CurrenciesTrendsBot;
import fr.afjg.coinbot.entity.CurrencyTrend;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CurrenciesTrendsBot ctb = CurrenciesTrendsBot.getInstance();
		
		CurrencyTrend ct1 = new CurrencyTrend();
		ct1.setId(1);
		ct1.setName("alt1");
		ct1.setNoteToBuy(12.0);
		ct1.setNoteToSell(2.0);
		
		CurrencyTrend ct2 = new CurrencyTrend();
		ct2.setId(2);
		ct2.setName("alt2");
		ct2.setNoteToBuy(10.0);
		ct2.setNoteToSell(1.0);
		
		CurrencyTrend ct3 = new CurrencyTrend();
		ct3.setId(3);
		ct3.setName("alt3");
		ct3.setNoteToBuy(8.0);
		ct3.setNoteToSell(3.0);
		
		
		CurrencyTrend ct4 = new CurrencyTrend();
		ct4.setId(3);
		ct4.setName("alt4");
		ct4.setNoteToBuy(11.0);
		ct4.setNoteToSell(3.0);
		
		ctb.getCurrenciesTrends().add(ct3);
		ctb.getCurrenciesTrends().add(ct1);
		ctb.getCurrenciesTrends().add(ct2);

		
		Thread t0 = new Thread(ctb);
		t0.start();
		
		for (CurrencyTrend ct : ctb.getCurrenciesTrends()) {
			System.out.println("nom : " + ct.getName() + " note to buy :" + ct.getNoteToBuy());
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Affichage1 af1 = new Affichage1("thread1");
		Thread t1 = new Thread(af1);
		t1.start();
		
		Affichage1 af2 = new Affichage1("thread2");
		Thread t2 = new Thread(af2);
		t2.start();
		
		
		Affichage1 af3 = new Affichage1("thread3");
		Thread t3 = new Thread(af3);
		t3.start();
		
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ctb.getCurrenciesTrends().add(ct4);
		
		
	}

}
