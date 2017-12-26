package fr.afgj.coinbot.calculation.impl;

public abstract class LineEquation {
	
	private TrendPointXY averagePt1;
	private TrendPointXY averagePt2;
	private double leadingDirect;
	private double ordOrigin;
	
	public LineEquation() {
		
	}
	
	

	public TrendPointXY getAveragePt1() {
		return averagePt1;
	}

	public void setAveragePt1(TrendPointXY averagePt1) {
		this.averagePt1 = averagePt1;
	}

	public TrendPointXY getAveragePt2() {
		return averagePt2;
	}

	public void setAveragePt2(TrendPointXY averagePt2) {
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
	
	
	

}
