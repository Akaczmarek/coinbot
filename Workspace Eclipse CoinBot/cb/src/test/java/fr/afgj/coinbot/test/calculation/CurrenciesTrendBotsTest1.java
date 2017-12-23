package fr.afgj.coinbot.test.calculation;

import fr.afgj.coinbot.calculation.CurrenciesTrendsBot;
import fr.afgj.coinbot.entity.CurrencyTrend;


/*
 * test simple vérifiant que la classe currenciestrendsbots est attaquable de partout et est thread safe
 */
public class CurrenciesTrendBotsTest1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Element1Test el1 = new Element1Test("el1");
		Thread t0 = new Thread(el1);
		t0.start();

		Thread.sleep(100);

		CurrenciesTrendsBot ctb = CurrenciesTrendsBot.getInstance();
		Thread t1 = new Thread(ctb);
		t1.start();

		CurrencyTrend ct1 = new CurrencyTrend();
		ct1.setIdcurrency(1);
		ct1.setName("ct1");
		ct1.setNotetobuy(12.0);
		ct1.setNotetosell(5.0);

		CurrencyTrend ct2 = new CurrencyTrend();
		ct2.setIdcurrency(1);
		ct2.setName("ct2");
		ct2.setNotetobuy(10.0);
		ct2.setNotetosell(6.0);

		CurrencyTrend ct3 = new CurrencyTrend();
		ct3.setIdcurrency(1);
		ct3.setName("ct3");
		ct3.setNotetobuy(15.0);
		ct3.setNotetosell(3.0);

		CurrencyTrend ct4 = new CurrencyTrend();
		ct4.setIdcurrency(1);
		ct4.setName("ct4");
		ct4.setNotetobuy(8.0);
		ct4.setNotetosell(7.0);

		ctb.getCurrenciesTrends().add(ct1);
		ctb.getCurrenciesTrends().add(ct2);

		
		Thread.sleep(100);
		
		Element1Test el2 = new Element1Test("el2");
		Thread t2 = new Thread(el2);
		t2.start();
		
		ctb.getCurrenciesTrends().add(ct3);
		
		Element1Test el3 = new Element1Test("el3");
		Thread t3 = new Thread(el3);
		t3.start();
		
		Thread.sleep(100);
		
		ctb.getCurrenciesTrends().add(ct4);
		
	}

}
