package fr.afgj.coinbot.calculation.impl;

import java.util.List;

import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.rule.impl.TrendRule;

public class TrendNoteToSell extends TrendNote {

	public TrendNoteToSell() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TrendNoteToSell(List<TrendPointXY> pointsXY, TrendRule trendRule, OperationsOnCurrencyTrend ooct) {
		super(pointsXY, trendRule, ooct);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void run() {
		// Stage 1 : transmit information to line equation average

		System.out.println("test je suis dans trens note to sell");
		// preparation calculation equation :

		// Stage 1 : transmit information to line equation average

		// Stage 1.1 : preparation calculation equation :

		TrendPointXY pt1 = this.calculationAveragePt1();
		TrendPointXY pt2 = this.calculationAveragePt2();
		
		// Stage 1.2 : ask calculation
		
		askCalculationLinesEquations(pt1, pt2);
	}
	
	
	

}
