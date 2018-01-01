package fr.afgj.coinbot.test.calculation;

import java.util.Date;

import fr.afgj.coinbot.calculation.impl.CurrenciesTrendsBot;
import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.CurrencyTrend;

/**
 * 
 * @author GHISLAIN le test final consite à généré des points autmatiquement sur
 *         une base sinusoidale et de déphaser les courbes pour contrôler leur
 *         états (valable à l'achat, vente )les unes par rapport aux autres
 */
public class currenciesTrendBotsTestFinalAvecPetimocks {
	public static void main(String[] args) {

		// création de l'objet currenciesTrendBots
		CurrenciesTrendsBot ctb = CurrenciesTrendsBot.getInstance();
		Thread t1 = new Thread(ctb);
		t1.start();

		// création de 4 currency trend
		CurrencyTrend ct1 = new CurrencyTrend();
		Currency cr1 = new Currency();
		cr1.setName("cr1");
		cr1.setIdcurrency(1);
		ct1.setCurrency(cr1);


		CurrencyTrend ct2 = new CurrencyTrend();
		Currency cr2 = new Currency();
		cr2.setName("cr2");
		cr2.setIdcurrency(2);
		ct2.setCurrency(cr2);


		CurrencyTrend ct3 = new CurrencyTrend();
		Currency cr3 = new Currency();
		cr3.setName("cr3");
		cr3.setIdcurrency(3);
		ct3.setCurrency(cr3);


		CurrencyTrend ct4 = new CurrencyTrend();
		Currency cr4 = new Currency();
		cr4.setName("cr4");
		cr4.setIdcurrency(4);
		ct4.setCurrency(cr4);

		// ajout des currency trend à currencies trend
		
		ctb.getCurrenciesTrends().add(ct1);
		ctb.getCurrenciesTrends().add(ct2);
		ctb.getCurrenciesTrends().add(ct3);
		ctb.getCurrenciesTrends().add(ct4);
		
		
		
		//demande d'affichage de résultat, simule de piochage d'information
		Element1Test el2 = new Element1Test("el2");
		Thread t2 = new Thread(el2);
		t2.start();
		
		
		try {
			Thread.sleep(45);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//demande d'affichage de résultat, simule de piochage d'information
		Element1Test el3 = new Element1Test("el3");
		Thread t3 = new Thread(el3);
		t3.start();

		
		
		
		//ajout des données dans les currency trend (les données sont des objet currency rate)
		// ajout de données à mesure que le temps passe
		
		Date date0 = new Date();
		while (true) {
			
			Date date = new Date();
			long dateLong = date.getTime();
			long date0Long = date0.getTime();
			long a = (date0Long - dateLong)/100;
			
				
				CurrencyRate crr1= new CurrencyRate();
				crr1.setTimerecord(date);
				crr1.setBidbtc(Math.sin(a)*10 +11);
				crr1.setAskbtc(Math.sin(a)*10 +12);
				
				cr1.getCurrencyratesStudy().add(crr1);
				
				CurrencyRate crr2= new CurrencyRate();
				crr2.setTimerecord(date);
				crr2.setBidbtc(Math.sin(a+0.5)*10 +11);
				crr2.setAskbtc(Math.sin(a+0.5)*10 +12);
				
				cr2.getCurrencyratesStudy().add(crr2);
				
				CurrencyRate crr3= new CurrencyRate();
				crr3.setTimerecord(date);
				crr3.setBidbtc(Math.sin(a+1)*10 +11);
				crr3.setAskbtc(Math.sin(a+1)*10 +12);
				
				cr3.getCurrencyratesStudy().add(crr3);
				
				CurrencyRate crr4= new CurrencyRate();
				crr4.setTimerecord(date);
				crr4.setBidbtc(Math.sin(a+1.5)*10 +11);
				crr4.setAskbtc(Math.sin(a+1.5)*10 +12);
				
				cr4.getCurrencyratesStudy().add(crr4);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		



	}

}
