// MIS EN COMM ALAIN 29/12
//package fr.afgj.coinbot.test.calculation.ooct;
//
//import java.util.Date;
//
//import fr.afgj.coinbot.calculation.impl.TrendPointXY;
//import fr.afgj.coinbot.entity.Currency;
//import fr.afgj.coinbot.entity.CurrencyRate;
//import fr.afgj.coinbot.entity.CurrencyTrend;
//import fr.afgj.coinbot.rule.impl.TrendRule;
//import fr.afgj.coinbot.rule.impl.TrendRulesBot;
//
///*
// * Test sur systeme d'update vérifié
// */
//
//
//public class updateTest {
//	
//	public static void main(String[] args) {
//		
//		TrendRulesBot tr = new TrendRulesBot();
//		tr.loadTrendRulesBotEnum();
//		
//		Currency c = new Currency();
//		c.setName("test1");
//		
//		
//		CurrencyRate cr1 = new CurrencyRate();
//		cr1.setTimerecord(new Date(1000L));
//		cr1.setBidbtc(1.0);
//		cr1.setAskbtc(1.1);
//		CurrencyRate cr2 = new CurrencyRate();
//		cr2.setTimerecord(new Date(2000L));
//		cr2.setBidbtc(2.0);
//		cr2.setAskbtc(2.1);
//		CurrencyRate cr3 = new CurrencyRate();
//		cr3.setTimerecord(new Date(3000L));
//		cr3.setBidbtc(3.0);
//		cr3.setAskbtc(3.1);
//		CurrencyRate cr4 = new CurrencyRate();
//		cr4.setTimerecord(new Date(4000L));
//		cr4.setBidbtc(4.0);
//		cr4.setAskbtc(4.1);
//		CurrencyRate cr5 = new CurrencyRate();
//		cr5.setTimerecord(new Date(5000L));
//		cr5.setBidbtc(5.0);
//		cr5.setAskbtc(5.1);
//		CurrencyRate cr6 = new CurrencyRate();
//		cr6.setTimerecord(new Date(6000L));
//		cr6.setBidbtc(6.0);
//		cr6.setAskbtc(6.1);
//		CurrencyRate cr7 = new CurrencyRate();
//		cr7.setTimerecord(new Date(7000L));
//		cr7.setBidbtc(7.0);
//		cr7.setAskbtc(7.1);
//
//		c.getCurrencyratesStudy().add(cr1);
//		c.getCurrencyratesStudy().add(cr2);
//		
//		CurrencyTrend ct =  new CurrencyTrend();
//		ct.setCurrency(c);
//		
//		
//		
//		// update 1 : avec une liste de base; VERIFIE OK
//		ct.update(tr);
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("*******************************************************************");
//		System.out.println("étape 1 :");
//		System.out.println("liste de comparaison :" + ct.getOoct().getComparisonCurrencyRates() + ", taille :" +ct.getOoct().getComparisonCurrencyRates().size());
//		System.out.println("anncienne liste :" + ct.getOoct().getOldCurrencyRates() + ", taille :" +ct.getOoct().getOldCurrencyRates().size());
//		System.out.println("nouvelle liste :" + ct.getOoct().getNewCurrencyRates() + ", taille :" +ct.getOoct().getNewCurrencyRates().size());
//		System.out.println("--------------------------------------------------------------------");
//		System.out.println("liste de point bid:" + ct.getOoct().getPointsXYOfBid() + ", taille :" +ct.getOoct().getPointsXYOfBid().size());
//		System.out.println("liste de point ask:" + ct.getOoct().getPointsXYOfAsk() + ", taille :" +ct.getOoct().getPointsXYOfAsk().size());
//		System.out.println("--------------------------------------------------------------------");
//		for (TrendPointXY pt : ct.getOoct().getPointsXYOfAsk()) {
//			System.out.println("x : " + pt.getX() + "; y : " + pt.getY());
//		}
//		
//		// update 2 : sans rien changer au précédent cas; VERIFIE OK
//		ct.update(tr);
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("*******************************************************************");
//		System.out.println("étape 2 :");
//		System.out.println("liste de comparaison :" + ct.getOoct().getComparisonCurrencyRates() + ", taille :" +ct.getOoct().getComparisonCurrencyRates().size());
//		System.out.println("anncienne liste :" + ct.getOoct().getOldCurrencyRates() + ", taille :" +ct.getOoct().getOldCurrencyRates().size());
//		System.out.println("nouvelle liste :" + ct.getOoct().getNewCurrencyRates() + ", taille :" +ct.getOoct().getNewCurrencyRates().size());
//		System.out.println("--------------------------------------------------------------------");
//		System.out.println("liste de point bid:" + ct.getOoct().getPointsXYOfBid() + ", taille :" +ct.getOoct().getPointsXYOfBid().size());
//		System.out.println("liste de point ask:" + ct.getOoct().getPointsXYOfAsk() + ", taille :" +ct.getOoct().getPointsXYOfAsk().size());
//		System.out.println("--------------------------------------------------------------------");
//		for (TrendPointXY pt : ct.getOoct().getPointsXYOfAsk()) {
//			System.out.println("x : " + pt.getX() + "; y : " + pt.getY());
//		}
//		
//		
//		// update3 : ajout d'une donnée identique, le système n'accepte pas les doublons; VERIFIE OK
//		c.getCurrencyratesStudy().add(cr1);
//		ct.update(tr);
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("*******************************************************************");
//		System.out.println("étape 3 :");
//		System.out.println("liste de comparaison :" + ct.getOoct().getComparisonCurrencyRates() + ", taille :" +ct.getOoct().getComparisonCurrencyRates().size());
//		System.out.println("anncienne liste :" + ct.getOoct().getOldCurrencyRates() + ", taille :" +ct.getOoct().getOldCurrencyRates().size());
//		System.out.println("nouvelle liste :" + ct.getOoct().getNewCurrencyRates() + ", taille :" +ct.getOoct().getNewCurrencyRates().size());
//		System.out.println("--------------------------------------------------------------------");
//		System.out.println("liste de point bid:" + ct.getOoct().getPointsXYOfBid() + ", taille :" +ct.getOoct().getPointsXYOfBid().size());
//		System.out.println("liste de point ask:" + ct.getOoct().getPointsXYOfAsk() + ", taille :" +ct.getOoct().getPointsXYOfAsk().size());
//		System.out.println("--------------------------------------------------------------------");
//		for (TrendPointXY pt : ct.getOoct().getPointsXYOfAsk()) {
//			System.out.println("x : " + pt.getX() + "; y : " + pt.getY());
//		}
//		
//		
//		// update4 : ajout d'une autre donnée; VERIFIE OK
//		c.getCurrencyratesStudy().add(cr3);
//		ct.update(tr);
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("*******************************************************************");
//		System.out.println("étape 4 :");
//		System.out.println("liste de comparaison :" + ct.getOoct().getComparisonCurrencyRates() + ", taille :" +ct.getOoct().getComparisonCurrencyRates().size());
//		System.out.println("anncienne liste :" + ct.getOoct().getOldCurrencyRates() + ", taille :" +ct.getOoct().getOldCurrencyRates().size());
//		System.out.println("nouvelle liste :" + ct.getOoct().getNewCurrencyRates() + ", taille :" +ct.getOoct().getNewCurrencyRates().size());
//		System.out.println("--------------------------------------------------------------------");
//		System.out.println("liste de point bid:" + ct.getOoct().getPointsXYOfBid() + ", taille :" +ct.getOoct().getPointsXYOfBid().size());
//		System.out.println("liste de point ask:" + ct.getOoct().getPointsXYOfAsk() + ", taille :" +ct.getOoct().getPointsXYOfAsk().size());
//		System.out.println("--------------------------------------------------------------------");
//		for (TrendPointXY pt : ct.getOoct().getPointsXYOfAsk()) {
//			System.out.println("x : " + pt.getX() + "; y : " + pt.getY());
//		}
//		
//		// update5 : ajout de 3 autres données; VERIFIE OK
//		c.getCurrencyratesStudy().add(cr4);
//		c.getCurrencyratesStudy().add(cr5);
//		c.getCurrencyratesStudy().add(cr6);
//		ct.update(tr);
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("*******************************************************************");
//		System.out.println("étape 4 :");
//		System.out.println("liste de comparaison :" + ct.getOoct().getComparisonCurrencyRates() + ", taille :" +ct.getOoct().getComparisonCurrencyRates().size());
//		System.out.println("anncienne liste :" + ct.getOoct().getOldCurrencyRates() + ", taille :" +ct.getOoct().getOldCurrencyRates().size());
//		System.out.println("nouvelle liste :" + ct.getOoct().getNewCurrencyRates() + ", taille :" +ct.getOoct().getNewCurrencyRates().size());
//		System.out.println("--------------------------------------------------------------------");
//		System.out.println("liste de point bid:" + ct.getOoct().getPointsXYOfBid() + ", taille :" +ct.getOoct().getPointsXYOfBid().size());
//		System.out.println("liste de point ask:" + ct.getOoct().getPointsXYOfAsk() + ", taille :" +ct.getOoct().getPointsXYOfAsk().size());
//		System.out.println("--------------------------------------------------------------------");
//		for (TrendPointXY pt : ct.getOoct().getPointsXYOfAsk()) {
//			System.out.println("x : " + pt.getX() + "; y : " + pt.getY());
//		}
//		
//		
//	}
//
//}
