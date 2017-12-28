package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

public abstract class LineEquation implements Runnable {

	private TrendPointXY averagePt1;
	private TrendPointXY averagePt2;
	private double leadingDirect;
	private double ordOrigin;
	private TrendNote trendNote;
	private List<TrendPointXY> pointsXY;
	private String name;

	{

	}

	public LineEquation() {

	}

	
	public LineEquation(TrendNote trendNote, List<TrendPointXY> pointsXY) {
		super();
		this.trendNote = trendNote;
		this.pointsXY = pointsXY;
	}


	public LineEquation(TrendPointXY averagePt1, TrendPointXY averagePt2, TrendNote trendNote,
			List<TrendPointXY> pointsXY) {
		super();
		this.averagePt1 = averagePt1;
		this.averagePt2 = averagePt2;
		this.trendNote = trendNote;
		this.pointsXY = pointsXY;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
		List<TrendPointXY> ptsXY;
		
		if (this.getPointsXY().size()>10) {
			//exclusion of the last 5 points in calculation.
			//allows to give a stronger weight to the note in case of significant variation at the last moment.
			
			ptsXY = new ArrayList<>(this.getPointsXY().subList(5, this.getPointsXY().size()));
		}else {
			
			ptsXY = new ArrayList<>(this.getPointsXY());
		}

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
		List<TrendPointXY> ptsXY;
		
		if (this.getPointsXY().size()>10) {
			//exclusion of the last 5 points in calculation.
			//allows to give a stronger weight to the note in case of significant variation at the last moment.
			
			ptsXY = new ArrayList<>(this.getPointsXY().subList(5, this.getPointsXY().size()));
		}else {
			
			ptsXY = new ArrayList<>(this.getPointsXY());
		}

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

	public TrendPointXY lastPointofLastTrend() {
		TrendPointXY pt1 = new TrendPointXY();
		
		if (this.getPointsXY()!=null) {
			pt1.setX(this.getPointsXY().get(0).getX());
			pt1.setY(this.getPointsXY().get(0).getY());
		}

		return pt1;
	}
	
	public TrendPointXY penultimatePointofLastTrend() {
		TrendPointXY pt1 = new TrendPointXY();
		
		if (this.getPointsXY()!=null) {
			pt1.setX(this.getPointsXY().get(1).getX());
			pt1.setY(this.getPointsXY().get(1).getY());
		}

		return pt1;
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
	
	public static void main(String[] args) {
		List<Integer> list =  new ArrayList<>();
		
		for (int i = 0; i < 10 ; i++) {
			
			list.add(i);
		}
		
		

		List<Integer> list2 =  new ArrayList<>(list.subList(3, list.size()));
		
		System.out.println("liste diminuée-------------------------------------");
		for (Integer i : list2) {
			System.out.println(i);
		}
		
		System.out.println("liste originale-------------------------------------");
		for (Integer i : list) {
			System.out.println(i);
		}
		
		
	}

}
