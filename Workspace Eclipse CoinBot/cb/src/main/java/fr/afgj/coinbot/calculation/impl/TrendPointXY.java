package fr.afgj.coinbot.calculation.impl;

public abstract class TrendPointXY {
	

	private long x;
	private double y;


	public TrendPointXY() {

	}

	public TrendPointXY(long x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
