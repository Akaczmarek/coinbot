package fr.afgj.coinbot.calculation.impl;

import java.util.Comparator;

public class TrendPointXY {
	

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
	
	// the youngest point is the first (index 0), the oldest point is the last after sort
	public volatile static Comparator<TrendPointXY> ptComparatorByDate = new Comparator<TrendPointXY>() {

		@Override
		public int compare(TrendPointXY tPt1, TrendPointXY tPt2) {
			// TODO Auto-generated method stub

			Long dateLongTPt1 =  (tPt1.getX()/10);
			Long dateLongTPt2 =  (tPt2.getX()/10);
			
			return (int)(- dateLongTPt1 + dateLongTPt2);
		}
	};

}
