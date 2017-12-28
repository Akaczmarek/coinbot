package fr.afgj.coinbot.calculation.impl;

import java.util.List;

import fr.afgj.coinbot.calculation.ILineEquationLastTrend;

public class LineEquationLastTrend1 extends LineEquation implements ILineEquationLastTrend {

		
	public LineEquationLastTrend1(TrendNote trendNote, List<TrendPointXY> pointsXY) {
		super(trendNote, pointsXY);
		// TODO Auto-generated constructor stub
		this.setName("Lt1");
	}

	@Override
	public void run() {

		// stage 0: definition the two last point of list
		
		// stage 0.1 : the last point
		this.setAveragePt1(lastPointofLastTrend());
		
		// stage 0.2 : the penultimate point
		this.setAveragePt2(penultimatePointofLastTrend());
		
		// stage 1 : calculation equation
		
		this.calculationAverageLineEquation();
		
		// stage 2 : save line equation
		this.getTrendNote().getLineEquationsLT().add(this);
	}

	
}
