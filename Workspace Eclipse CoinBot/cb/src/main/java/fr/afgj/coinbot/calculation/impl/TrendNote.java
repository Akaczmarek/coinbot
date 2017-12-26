package fr.afgj.coinbot.calculation.impl;

import java.util.List;

import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.rule.impl.TrendRule;

public abstract class TrendNote implements Runnable {
	
	
	private double note;
	private List<CurrencyRate> currencyRates;
	private TrendRule trendRule;
	private OperationsOnCurrencyTrend ooct;
	
	
	public TrendNote() {
		
	}


	public TrendNote(List<CurrencyRate> currencyRates, TrendRule trendRule, OperationsOnCurrencyTrend ooct) {
		super();
		this.currencyRates = currencyRates;
		this.trendRule = trendRule;
		this.ooct = ooct;
	}



	
	

}
