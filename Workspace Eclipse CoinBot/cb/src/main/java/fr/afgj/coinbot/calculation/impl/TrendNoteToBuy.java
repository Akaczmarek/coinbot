package fr.afgj.coinbot.calculation.impl;

import java.util.List;

import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.rule.impl.TrendRule;

public class TrendNoteToBuy extends TrendNote {

	public TrendNoteToBuy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrendNoteToBuy(List<CurrencyRate> currencyRates, TrendRule trendRule, OperationsOnCurrencyTrend ooct) {
		super(currencyRates, trendRule, ooct);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		//Stage 0 : definition
		
		
		
		// Stage 1 : transmit information to line equation average

		// preparation calculation equation :

		TrendPointXYAverage pt1 = this.calculationAveragePt1("ask");
		TrendPointXYAverage pt2 = this.calculationAveragePt2("ask");
		LineEquationAverage lineEquationAverage = new LineEquationAverage(pt1, pt2, this);
		

	}

}
