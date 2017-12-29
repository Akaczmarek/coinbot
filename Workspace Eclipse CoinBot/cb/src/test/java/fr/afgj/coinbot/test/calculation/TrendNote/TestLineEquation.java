// MIS EN COMM ALAIN 29/12
//package fr.afgj.coinbot.test.calculation.TrendNote;
//
//import java.util.Date;
//
//import fr.afgj.coinbot.calculation.impl.TrendPointXY;
//import fr.afgj.coinbot.entity.Currency;
//import fr.afgj.coinbot.entity.CurrencyRate;
//import fr.afgj.coinbot.entity.CurrencyTrend;
//import fr.afgj.coinbot.rule.impl.TrendRulesBot;
//
//public class TestLineEquation {
//
//	public static void main(String[] args) {
//		
//		
//		TrendRulesBot tr = new TrendRulesBot();
//		tr.loadTrendRulesBotEnum();
//		
//		
//		
//		Currency c = new Currency();
//		c.setName("test1");
//		
//		
//		CurrencyRate cr1 = new CurrencyRate();
//		cr1.setTimerecord(new Date(1514386162000L));
//		cr1.setBidbtc(1.0);
//		cr1.setAskbtc(1.1);
//		CurrencyRate cr2 = new CurrencyRate();
//		cr2.setTimerecord(new Date(1514386163000L));
//		cr2.setBidbtc(2.0);
//		cr2.setAskbtc(2.1);
//		CurrencyRate cr3 = new CurrencyRate();
//		cr3.setTimerecord(new Date(1514386164000L));
//		cr3.setBidbtc(10.0);
//		cr3.setAskbtc(3.1);
//		CurrencyRate cr4 = new CurrencyRate();
//		cr4.setTimerecord(new Date(1514386165000L));
//		cr4.setBidbtc(20.0);
//		cr4.setAskbtc(4.1);
//		CurrencyRate cr5 = new CurrencyRate();
//		cr5.setTimerecord(new Date(1514386166000L));
//		cr5.setBidbtc(5.0);
//		cr5.setAskbtc(5.1);
//		CurrencyRate cr6 = new CurrencyRate();
//		cr6.setTimerecord(new Date(1514386167000L));
//		cr6.setBidbtc(6.0);
//		cr6.setAskbtc(6.1);
//		CurrencyRate cr7 = new CurrencyRate();
//		cr7.setTimerecord(new Date(1514386168000L));
//		cr7.setBidbtc(7.0);
//		cr7.setAskbtc(7.1);
//
//		c.getCurrencyratesStudy().add(cr1);
//		c.getCurrencyratesStudy().add(cr2);
//		
//		CurrencyTrend ct =  new CurrencyTrend();
//		ct.setCurrency(c);
//		ct.getOoct().setTrendRule(tr);
//		
//		
//		
//		
//		// update 1 : avec une liste de base; VERIFIE OK
//		ct.update(tr);
//		
//		try {
//			Thread.sleep(20);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println("---------------------------------------------------------***");
//		// update 2 
//		
//		c.getCurrencyratesStudy().add(cr3);
//		c.getCurrencyratesStudy().add(cr4);
//		
//		System.out.println(ct.update(tr));
//		
//		try {
//			Thread.sleep(20);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//
//}
