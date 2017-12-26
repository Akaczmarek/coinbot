package fr.afgj.coinbot.calculation.impl;

import fr.afgj.coinbot.calculation.ITrendNote;

public class LineEquationAverage extends LineEquation {
	
	

	public LineEquationAverage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LineEquationAverage(TrendPointXYAverage averagePt1, TrendPointXYAverage averagePt2, ITrendNote trendNote) {
		super(averagePt1, averagePt2, trendNote);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		this.calculationAverageLineEquation();
		
		LineEquationCeiling lec = new LineEquationCeiling();
		
		
		
		
	}
	

}
