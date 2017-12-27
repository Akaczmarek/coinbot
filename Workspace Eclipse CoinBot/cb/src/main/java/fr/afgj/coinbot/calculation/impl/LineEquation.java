package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class LineEquation implements Runnable {

	private TrendPointXY averagePt1;
	private TrendPointXY averagePt2;
	private double leadingDirect;
	private double ordOrigin;
	private TrendNote trendNote;
	private List<TrendPointXY> pointsXY;

	{

	}

	public LineEquation() {

	}

	public LineEquation(TrendPointXY averagePt1, TrendPointXY averagePt2, TrendNote trendNote,
			List<TrendPointXY> pointsXY) {
		super();
		this.averagePt1 = averagePt1;
		this.averagePt2 = averagePt2;
		this.trendNote = trendNote;
		this.pointsXY = pointsXY;
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

	public TrendNote getTrendNote() {
		return trendNote;
	}

	public void setTrendNote(TrendNote trendNote) {
		this.trendNote = trendNote;
	}

	public List<TrendPointXY> getPointsXY() {
		return pointsXY;
	}

	public void setPointsXY(List<TrendPointXY> pointsXY) {
		this.pointsXY = pointsXY;
	}

	public void calculationAverageLineEquation() {

		double pt1X = this.getAveragePt1().getX();
		double pt1Y = this.getAveragePt1().getY();
		double pt2X = this.getAveragePt2().getX();
		double pt2Y = this.getAveragePt2().getY();

		// Stage 1 : calculation average equation line
		this.setOrdOrigin((pt1X * pt2Y - pt1Y * pt2X) / (pt1X - pt2X));

		double b = this.getOrdOrigin();

		this.setLeadingDirect((pt1Y - b) / pt1X);
		double a = this.getLeadingDirect();
		System.out.println("line equation average : a = " + a + ", b = " + b + " " + this.toString());
	}

	public void calculationCeilingLineEquation() {
		List<TrendPointXY> ptsXY = new ArrayList<>(this.getPointsXY());

		Map<Double, TrendPointXY> comparisonList = new TreeMap<>(); // comparison between line and points
		Iterator<TrendPointXY> ite = ptsXY.iterator();

		double a = this.getLeadingDirect();
		double b = this.getOrdOrigin();

		while (ite.hasNext()) {
			TrendPointXY pt;
			double resultComparison;
			double y;
			long x;

			pt = ite.next();
			x = pt.getX();
			y = pt.getY();

			resultComparison = y - a * x + b;

			comparisonList.put(resultComparison, pt);
		}

		// the highest point
		TrendPointXY highPt = comparisonList.get(((TreeMap<Double, TrendPointXY>) comparisonList).lastKey());

		// correction equation for ceiling and support : change ordOrigin

		double yHighPt = highPt.getY();
		long xHighPt = highPt.getX();

		b = yHighPt - a * xHighPt;
		this.setOrdOrigin(b);

		System.out.println("line equation ceiling : a = " + a + ", b = " + b + " " + this.toString());

	}

	public void calculationSupportLineEquation() {
		List<TrendPointXY> ptsXY = new ArrayList<>(this.getPointsXY());

		Map<Double, TrendPointXY> comparisonList = new TreeMap<>(); // comparison between line and points
		Iterator<TrendPointXY> ite = ptsXY.iterator();

		double a = this.getLeadingDirect();
		double b = this.getOrdOrigin();

		while (ite.hasNext()) {
			TrendPointXY pt;
			double resultComparison;
			double y;
			long x;

			pt = ite.next();
			x = pt.getX();
			y = pt.getY();

			resultComparison = y - a * x + b;

			comparisonList.put(resultComparison, pt);

		}

		// the lower point
		TrendPointXY lowPt = comparisonList.get(((TreeMap<Double, TrendPointXY>) comparisonList).firstKey());

		// correction equation for ceiling and support : change ordOrigin

		double yLowPt = lowPt.getY();
		long xLowPt = lowPt.getX();

		b = yLowPt - a * xLowPt;
		this.setOrdOrigin(b);
		System.out.println("line equation support : a = " + a + ", b = " + b + " " + this.toString());
	}

	public void calculationLastTrendLineEquation() {

		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineEquation [averagePt1=");
		builder.append(averagePt1);
		builder.append(", averagePt2=");
		builder.append(averagePt2);
		builder.append(", leadingDirect=");
		builder.append(leadingDirect);
		builder.append(", ordOrigin=");
		builder.append(ordOrigin);
		builder.append(", trendNote=");
		builder.append(trendNote);
		builder.append(", pointsXY=");
		builder.append(pointsXY);
		builder.append("]");
		return builder.toString();
	}

}
