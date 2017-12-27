package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.afgj.coinbot.rule.impl.TrendRule;

public abstract class TrendNote implements Runnable {

	private double note;
	private volatile List<TrendPointXY> pointsXY;
	private volatile List<LineEquation> lineEquations;
	private TrendRule trendRule;
	private OperationsOnCurrencyTrend ooct;

	{
		lineEquations = new ArrayList<>();
	}

	public TrendNote() {

	}

	public TrendNote(List<TrendPointXY> pointsXY, TrendRule trendRule, OperationsOnCurrencyTrend ooct) {
		super();
		this.pointsXY = pointsXY;
		this.trendRule = trendRule;
		this.ooct = ooct;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public synchronized List<TrendPointXY> getPointsXY() {
		return pointsXY;
	}

	public void setPointsXY(List<TrendPointXY> pointsXY) {
		this.pointsXY = pointsXY;
	}

	public TrendRule getTrendRule() {
		return trendRule;
	}

	public void setTrendRule(TrendRule trendRule) {
		this.trendRule = trendRule;
	}

	public OperationsOnCurrencyTrend getOoct() {
		return ooct;
	}

	public void setOoct(OperationsOnCurrencyTrend ooct) {
		this.ooct = ooct;
	}

	public synchronized List<LineEquation> getLineEquations() {
		return lineEquations;
	}

	public void setLineEquations(List<LineEquation> lineEquations) {
		this.lineEquations = lineEquations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.afgj.coinbot.calculation.impl.ITrendNote#calculationAveragePt1(java.lang.
	 * String)
	 */

	public TrendPointXY calculationAveragePt1() {

		List<TrendPointXY> PointsXY = new ArrayList<>(this.getPointsXY());
		List<TrendPointXY> partOfPointsList = PointsXY.subList(0, (PointsXY.size() / 2));
		TrendPointXY pt = calculationAveragePt(partOfPointsList);

		return pt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.afgj.coinbot.calculation.impl.ITrendNote#calculationAveragePt2(java.lang.
	 * String)
	 */

	public TrendPointXY calculationAveragePt2() {

		List<TrendPointXY> PointsXY = new ArrayList<>(this.getPointsXY());
		List<TrendPointXY> partOfPointsList = PointsXY.subList((PointsXY.size() / 2), (PointsXY.size()));
		TrendPointXY pt = calculationAveragePt(partOfPointsList);

		return pt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.afgj.coinbot.calculation.impl.ITrendNote#calculationAveragePt(java.util.
	 * List, java.lang.String)
	 */

	public TrendPointXY calculationAveragePt(List<TrendPointXY> partOfPointsList) {
		TrendPointXY pt = new TrendPointXY();

		List<TrendPointXY> list = partOfPointsList;

		long sumDate = 0L;
		double sumValue = 0.0;

		if (!list.isEmpty()) {
			for (TrendPointXY ptXY : list) {

				sumDate += ptXY.getX();

				sumValue += ptXY.getY();

			}
			pt.setX(sumDate / list.size());
			pt.setY(sumValue / list.size());
		}

		return pt;
	}

	public void askCalculationLinesEquations(TrendPointXY pt1, TrendPointXY pt2) {
		List<TrendPointXY> pointsXY = new ArrayList<>(this.getPointsXY());
		LineEquationAverage lineEquationAverage = new LineEquationAverage(pt1, pt2, this, pointsXY);
		Thread t0 = new Thread(lineEquationAverage);
		t0.start();
	}
	
	public TrendPointXY calculationLastTrendPt1() {
		// this is the last point recorded
		TrendPointXY pt0 = this.getPointsXY().get(0);
		TrendPointXY pt = new TrendPointXY();
		pt.setX(pt0.getX());
		pt.setY(pt0.getY());
		return pt;
	}
	
	public TrendPointXY  calculationLastTrendPt2() {
		
		
		TrendPointXY pt =  new TrendPointXY() ;
		
		
		return pt;
	}

	public void askCalculationLineEquationLastTrend(TrendPointXY pt1, TrendPointXY pt2){
		
	}

	public static void main(String[] args) {

//		TrendPointXY pt1 = new TrendPointXY();
//		pt1.setX(1000L);
//		pt1.setY(1.0);
//		TrendPointXY pt2 = new TrendPointXY();
//		pt2.setX(2000L);
//		pt2.setY(2.0);
//		TrendPointXY pt3 = new TrendPointXY();
//		pt3.setX(3000L);
//		pt3.setY(3.0);
//		TrendPointXY pt4 = new TrendPointXY();
//		pt4.setX(4000L);
//		pt4.setY(4.0);
//		TrendPointXY pt5 = new TrendPointXY();
//		pt5.setX(5000L);
//		pt5.setY(5.0);
//
//		List<TrendPointXY> list = new ArrayList<>();
//		list.add(pt1);
//		list.add(pt2);
//		list.add(pt3);
//		list.add(pt4);
//		list.add(pt5);
//
//		TrendNote tn = new TrendNoteToBuy();
//		tn.setPointsXY(list);
//
//		TrendPointXY pt = tn.calculationAveragePt2();
//
//		System.out.println("temps " + pt.getX() + ", value " + pt.getY());
		
		
		TrendPointXY pt1 = new TrendPointXY();
		pt1.setX(60L);
		pt1.setY(6.0);
		TrendPointXY pt2 = new TrendPointXY();
		pt2.setX(20L);
		pt2.setY(2.0);
		TrendPointXY pt3 = new TrendPointXY();
		pt3.setX(30L);
		pt3.setY(3.0);
		TrendPointXY pt4 = new TrendPointXY();
		pt4.setX(40L);
		pt4.setY(4.0);
		TrendPointXY pt5 = new TrendPointXY();
		pt5.setX(50L);
		pt5.setY(5.0);
		
		List<TrendPointXY> list = new ArrayList<>();
		list.add(pt1);
		list.add(pt2);
		list.add(pt3);
		list.add(pt4);
		list.add(pt5);
		
		Collections.sort(list, TrendPointXY.ptComparatorByDate );
		
		for (TrendPointXY pt : list) {
			System.out.println("x : " + pt.getX() + "y : " + pt.getY());
		}
		
		TrendNote tn = new TrendNoteToBuy();
		tn.setPointsXY(list);
		
		
		
		System.out.println("--------------------------------------");
		
		TrendPointXY pt6 = tn.calculationLastTrendPt1();
		System.out.println("x : " + pt6.getX() + "y : " + pt6.getY());
		

	}
	


}
