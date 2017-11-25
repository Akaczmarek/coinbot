package fr.afjg.coinbot.pojo.datatprocessing;

import java.sql.Timestamp;

/**
 * for point in graphic function of time
 * @author GHISLAIN
 * <br><br>
 *
 *	X=time<br>
 *	y=Value
 */
public class PointXY {

	private long x;
	private double y;

	public PointXY() {

	}
	public PointXY(long x, double y) {
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
