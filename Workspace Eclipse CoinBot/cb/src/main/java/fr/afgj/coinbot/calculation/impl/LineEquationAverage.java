package fr.afgj.coinbot.calculation.impl;

import java.util.List;

public class LineEquationAverage extends LineEquation {

	public LineEquationAverage() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LineEquationAverage(TrendPointXY averagePt1, TrendPointXY averagePt2, TrendNote trendNote,
			List<TrendPointXY> pointsXY) {
		super(averagePt1, averagePt2, trendNote, pointsXY);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub

		// Stage 0 : 
		this.calculationAverageLineEquation();
		
		// Stage 1 : send information to Line Equation ceiling
		
		LineEquationCeiling lec = new LineEquationCeiling();
		lec.setLeadingDirect(this.getLeadingDirect());
		lec.setOrdOrigin(this.getOrdOrigin());
		lec.setPointsXY(this.getPointsXY());
		
		// Stage 2 : send information to Line Equation Support
		
		LineEquationSupport les = new LineEquationSupport();
		les.setLeadingDirect(this.getLeadingDirect());
		les.setOrdOrigin(this.getOrdOrigin());
		les.setPointsXY(this.getPointsXY());

	}

}
