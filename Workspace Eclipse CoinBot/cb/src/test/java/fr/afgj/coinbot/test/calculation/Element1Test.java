package fr.afgj.coinbot.test.calculation;

import fr.afgj.coinbot.calculation.impl.CurrenciesTrendsBot;
import fr.afgj.coinbot.entity.CurrencyTrend;

public class Element1Test implements Runnable {

	private CurrenciesTrendsBot ctb = CurrenciesTrendsBot.getInstance();
	private String name;

	public Element1Test(String name) {
		super();
		this.name = name;
	}

	public CurrenciesTrendsBot getCtb() {
		return ctb;
	}

	public void setCtb(CurrenciesTrendsBot ctb) {
		this.ctb = ctb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		
		for (int i = 0; i < 150; i++) {
			System.out.println("------------------------------------");
			int x = 1;
			for (CurrencyTrend ct : getCtb().getCurrenciesTrendsOrderByNoteToBuy()) {
				if (ct.getCurrency() != null) {
					System.out.println(x + ". nom test : " + this.getName() + " , nom élément liste : "
							+ ct.getCurrency().getName() + " , note : " + ct.getNotetobuy());
					x++;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
