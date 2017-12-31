// MIS EN COMM ALAIN 29/12
package fr.afgj.coinbot.test.calculation.TrendNote;

import java.util.Date;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.rule.impl.TrendRulesBot;

public class TestLineEquationandNote {

	public static void main(String[] args) {
		
		
		TrendRulesBot tr = new TrendRulesBot();
		tr.loadTrendRulesBotEnum();
		
		
		
		Currency c = new Currency();
		c.setName("test1");
		
		
		CurrencyRate cr1 = new CurrencyRate();
		cr1.setTimerecord(new Date(1514386161000L));
		cr1.setBidbtc(1.0);
		cr1.setAskbtc(1.0);
		CurrencyRate cr2 = new CurrencyRate();
		cr2.setTimerecord(new Date(1514386162000L));
		cr2.setBidbtc(2.0);
		cr2.setAskbtc(2.0);
		CurrencyRate cr3 = new CurrencyRate();
		cr3.setTimerecord(new Date(1514386163000L));
		cr3.setBidbtc(5.0);
		cr3.setAskbtc(5.0);
		CurrencyRate cr4 = new CurrencyRate();
		cr4.setTimerecord(new Date(1514386164000L));
		cr4.setBidbtc(30.0);
		cr4.setAskbtc(30.0);
		CurrencyRate cr5 = new CurrencyRate();
		cr5.setTimerecord(new Date(1514386165000L));
		cr5.setBidbtc(27.0);
		cr5.setAskbtc(27.0);
		CurrencyRate cr6 = new CurrencyRate();
		cr6.setTimerecord(new Date(1514386166000L));
		cr6.setBidbtc(15.0);
		cr6.setAskbtc(15.0);
		CurrencyRate cr7 = new CurrencyRate();
		cr7.setTimerecord(new Date(1514386167000L));
		cr7.setBidbtc(25.0);
		cr7.setAskbtc(25.0);
		CurrencyRate cr8 = new CurrencyRate();
		cr8.setTimerecord(new Date(1514386168000L));
		cr8.setBidbtc(5.0);
		cr8.setAskbtc(15.0);
		CurrencyRate cr9 = new CurrencyRate();
		cr9.setTimerecord(new Date(1514386169000L));
		cr9.setBidbtc(0.0);
		cr9.setAskbtc(12.0);
		CurrencyRate cr10 = new CurrencyRate();
		cr10.setTimerecord(new Date(1514386170000L));
		cr10.setBidbtc(3.0);
		cr10.setAskbtc(3.0);
		CurrencyRate cr11 = new CurrencyRate();
		cr11.setTimerecord(new Date(1514386171000L));
		cr11.setBidbtc(5.0);
		cr11.setAskbtc(5.0);
		CurrencyRate cr12 = new CurrencyRate();
		cr12.setTimerecord(new Date(1514386172000L));
		cr12.setBidbtc(37.0);
		cr12.setAskbtc(10.0);

		c.getCurrencyratesStudy().add(cr1);
		c.getCurrencyratesStudy().add(cr2);
		
		CurrencyTrend ct =  new CurrencyTrend();
		ct.setCurrency(c);
		ct.getOoct().setTrendRule(tr);
		
		
		
		
		// update 1 : avec une liste de base; VERIFIE OK
		ct.update(tr);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("---------------------------------------------------------***");
		// update 2 
		
		c.getCurrencyratesStudy().add(cr3);
		c.getCurrencyratesStudy().add(cr4);
		c.getCurrencyratesStudy().add(cr5);
		c.getCurrencyratesStudy().add(cr6);
		c.getCurrencyratesStudy().add(cr7);
		c.getCurrencyratesStudy().add(cr8);
		c.getCurrencyratesStudy().add(cr9);
		c.getCurrencyratesStudy().add(cr10);
		c.getCurrencyratesStudy().add(cr11);
		c.getCurrencyratesStudy().add(cr12);
		

		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
