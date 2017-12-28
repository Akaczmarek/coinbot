package fr.afgj.coinbot.calculation.impl;

import java.util.List;

public class LineEquationAverage extends LineEquation {


	public LineEquationAverage(TrendPointXY averagePt1, TrendPointXY averagePt2, TrendNote trendNote,
			List<TrendPointXY> pointsXY) {
		super(averagePt1, averagePt2, trendNote, pointsXY);
		// TODO Auto-generated constructor stub
		this.setName("Average");
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("test je suis dans line equation");
		// Stage 0 : calculation of equation 
		this.calculationAverageLineEquation();

		// Stage 1 : send information to Line Equation ceiling
		
		LineEquationCeiling lec = new LineEquationCeiling();
		lec.setLeadingDirect(this.getLeadingDirect());
		lec.setOrdOrigin(this.getOrdOrigin());
		lec.setPointsXY(this.getPointsXY());
		lec.setTrendNote(this.getTrendNote());
		
		Thread t0 = new Thread(lec);
		t0.start();
		
		// Stage 2 : send information to Line Equation Support
		
		LineEquationSupport les = new LineEquationSupport();
		les.setLeadingDirect(this.getLeadingDirect());
		les.setOrdOrigin(this.getOrdOrigin());
		les.setPointsXY(this.getPointsXY());
		les.setTrendNote(this.getTrendNote());
		
		Thread t1= new Thread(les);
		t1.start();

		// stage 3 : save line equation
		this.getTrendNote().getLineEquations().add(this);
	}

}
