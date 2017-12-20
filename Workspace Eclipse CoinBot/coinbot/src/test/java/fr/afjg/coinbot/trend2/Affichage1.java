package fr.afjg.coinbot.trend2;



import fr.afjg.coinbot.calculation.CurrenciesTrendsBot;
import fr.afjg.coinbot.entity.CurrencyTrend;

/*
 * affichage d'info récupérée sur currenciesTrendsBot
 */
public class Affichage1 implements Runnable {

	private CurrenciesTrendsBot ctb = CurrenciesTrendsBot.getInstance();
	private String name;
	
	public Affichage1(String name) {
		this.setName(name);
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
		for (int i = 0; i < 100; i++) {
			System.out.println("*****************************************************");
			for (CurrencyTrend ct : ctb.getCurrenciesTrendsOrderByNoteToSell()) {
				System.out.println("nom du thread : " + this.getName() + ", nom : " + ct.getName() + " note to buy :" + ct.getNoteToSell());
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
