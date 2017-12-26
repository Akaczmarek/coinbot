package fr.afgj.coinbot.test.calculation;

import fr.afgj.coinbot.calculation.impl.CurrenciesTrendsBot;
import fr.afgj.coinbot.entity.Currency;
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
		
		Currency cr1 = new Currency();
		cr1.setName("cr1");
		cr1.setIdcurrency(1);
		ct1.setCurrency(cr1);
		ct1.setNotetobuy(12.0);
		ct1.setNotetosell(5.0);

		CurrencyTrend ct2 = new CurrencyTrend();
		Currency cr2 = new Currency();
		cr2.setName("cr2");
		cr2.setIdcurrency(2);
		ct2.setCurrency(cr2);
		ct2.setNotetobuy(10.0);
		ct2.setNotetosell(6.0);

		CurrencyTrend ct3 = new CurrencyTrend();
		Currency cr3 = new Currency();
		cr3.setName("cr3");
		cr3.setIdcurrency(3);
		ct3.setCurrency(cr3);
		ct3.setNotetobuy(15.0);
		ct3.setNotetosell(3.0);

		CurrencyTrend ct4 = new CurrencyTrend();
		Currency cr4 = new Currency();
		cr4.setName("cr4");
		cr4.setIdcurrency(4);
		ct4.setCurrency(cr4);
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
