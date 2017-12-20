package fr.afjg.coinbot.calculation;

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
		
		
		ctb.getCurrenciesTrends().add(ct3);
		ctb.getCurrenciesTrends().add(ct1);
		ctb.getCurrenciesTrends().add(ct2);

		
		Thread t0 = new Thread(ctb);
		t0.start();
		
		for (CurrencyTrend ct : ctb.getCurrenciesTrends()) {
			System.out.println("nom : " + ct.getName() + " note to buy :" + ct.getNoteToBuy());
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Affichage1 af = new Affichage1();
		Thread t = new Thread(af);
		t.start();
		
		
	}

}
