package fr.afgj.coinbot.calculation.impl;

import java.util.List;

import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.rule.impl.TrendRule;

public class TrendNoteToSell extends TrendNote {

	public TrendNoteToSell() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrendNoteToSell(List<CurrencyRate> currencyRates, TrendRule trendRule, OperationsOnCurrencyTrend ooct) {
		super(currencyRates, trendRule, ooct);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// Stage 1 : transmit information to line equation average

		// preparation calculation equation :

		this.calculationAveragePt1("bid");
		this.calculationAveragePt2("bid");
		
	}
	
	
	

}
