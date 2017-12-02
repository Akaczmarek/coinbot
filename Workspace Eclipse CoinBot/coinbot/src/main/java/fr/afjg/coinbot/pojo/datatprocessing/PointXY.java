package fr.afjg.coinbot.pojo.datatprocessing;

import java.sql.Timestamp;
import java.util.Comparator;

import fr.afjg.coinbot.pojo.database.CurrencyRate;

/**
 * for point in graphic function of time
 * 
 * @author GHISLAIN <br>
 * 		<br>
 *
 *         X=time<br>
 *         y=Value
 */
public class PointXY {

	private long x;
	private double y;
	private double compareEquationLine; // difference between point and line

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

	public double getCompareEquationLine() {
		return compareEquationLine;
	}

	public void setCompareEquationLine(double compareEquationLine) {
		this.compareEquationLine = compareEquationLine;
	}

	public final static Comparator<PointXY> ptVsLineEquationComparator = new Comparator<PointXY>() {

		@Override
		public int compare(PointXY pt1, PointXY pt2) {
			// TODO Auto-generated method stub

			double resultPt1 = pt1.getCompareEquationLine();
			double resultPt2 = pt2.getCompareEquationLine();
			int result = (int) ((resultPt1 - resultPt2) * 10000);

			return result;
		}
	};

	public static void main(String[] args) {
		double a = 0.0001;
		double b = 0.000002;
		System.out.println(Integer.MAX_VALUE);
	}

}
