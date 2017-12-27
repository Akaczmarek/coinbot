package fr.afgj.coinbot.calculation.impl;

import java.util.List;

import fr.afgj.coinbot.rule.impl.TrendRule;

public class TrendNoteToBuy extends TrendNote {

	public TrendNoteToBuy() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TrendNoteToBuy(List<TrendPointXY> pointsXY, TrendRule trendRule, OperationsOnCurrencyTrend ooct) {
		super(pointsXY, trendRule, ooct);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void run() {


		// Stage 1 : transmit information to line equation average

		// Stage 1.1 : preparation calculation equations :

		TrendPointXY pt1 = this.calculationAveragePt1();
		TrendPointXY pt2 = this.calculationAveragePt2();
		
		// Stage 1.2 : ask calculation
		
		askCalculationLinesEquations(pt1, pt2);
		
		
		// Stage 2 : transmit information to last TrendEquation
		
		// Stage 2.1 : preparation calculation equation :

		TrendPointXY pt1 = this.calculationLastTrendPt1();
		TrendPointXY pt2 = this.calculationLastTrendPt2();
		
		askCalculationLineEquationLastTrend(pt1, pt2);
		

		
		

	}





}
