package fr.afgj.coinbot.calculation.impl;

import fr.afgj.coinbot.calculation.ITrendNote;

public abstract class LineEquation implements Runnable{
	
	private TrendPointXYAverage averagePt1;
	private TrendPointXYAverage averagePt2;
	private double leadingDirect;
	private double ordOrigin;
	private ITrendNote trendNote;
	
	public LineEquation() {
		
	}
	
	
	public LineEquation(TrendPointXYAverage averagePt1, TrendPointXYAverage averagePt2, ITrendNote trendNote) {
		super();
		this.averagePt1 = averagePt1;
		this.averagePt2 = averagePt2;
		this.trendNote = trendNote;
	}



	public LineEquation(double leadingDirect, double ordOrigin, ITrendNote trendNote) {
		super();
		this.leadingDirect = leadingDirect;
		this.ordOrigin = ordOrigin;
		this.trendNote = trendNote;
	}
	
	


	public TrendPointXY getAveragePt1() {
		return averagePt1;
	}

	public void setAveragePt1(TrendPointXYAverage averagePt1) {
		this.averagePt1 = averagePt1;
	}

	public TrendPointXY getAveragePt2() {
		return averagePt2;
	}

	public void setAveragePt2(TrendPointXYAverage averagePt2) {
		this.averagePt2 = averagePt2;
	}

	public double getLeadingDirect() {
		return leadingDirect;
	}

	public void setLeadingDirect(double leadingDirect) {
		this.leadingDirect = leadingDirect;
	}

	public double getOrdOrigin() {
		return ordOrigin;
	}

	public void setOrdOrigin(double ordOrigin) {
		this.ordOrigin = ordOrigin;
	}
	
	public void calculationAverageLineEquation() {
		
		double pt1X = this.getAveragePt1().getX();
		double pt1Y = this.getAveragePt1().getY();
		double pt2X = this.getAveragePt2().getX();
		double pt2Y = this.getAveragePt2().getY();
		
		//Stage 1 : calculation average equation line
		this.setOrdOrigin((pt1X * pt2Y - pt1Y * pt2X) / (pt1X - pt2X));
		
		double b = this.getOrdOrigin();
		
		this.setLeadingDirect((pt1Y - b) / pt1X);
		
	}
	
	


}
