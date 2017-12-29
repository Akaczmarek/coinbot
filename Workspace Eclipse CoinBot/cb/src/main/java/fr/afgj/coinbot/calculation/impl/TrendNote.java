package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import fr.afgj.coinbot.calculation.ILineEquationLastTrend;
import fr.afgj.coinbot.rule.impl.TrendRule;

public abstract class TrendNote implements Runnable {

	private double note;
	private volatile List<TrendPointXY> pointsXY;
	private volatile List<LineEquation> lineEquations;
	private volatile List<ILineEquationLastTrend> lineEquationsLT;
	private volatile TrendPointXY lastPoint;
	private TrendRule trendRule;
	private OperationsOnCurrencyTrend ooct;

	{
		this.setLineEquations(new ArrayList<>());
		this.setLineEquationsLT(new ArrayList<>());
	}

	public TrendNote() {

	}

	public TrendNote(List<TrendPointXY> pointsXY, TrendRule trendRule, OperationsOnCurrencyTrend ooct) {
		super();
		this.pointsXY = pointsXY;
		this.trendRule = trendRule;
		this.ooct = ooct;
	}

	public TrendPointXY getLastPoint() {
		return lastPoint;
	}

	public void setLastPoint(TrendPointXY lastPoint) {
		this.lastPoint = lastPoint;
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

	public synchronized void setPointsXY(List<TrendPointXY> pointsXY) {
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

	public synchronized List<ILineEquationLastTrend> getLineEquationsLT() {
		return lineEquationsLT;
	}

	public synchronized void setLineEquationsLT(List<ILineEquationLastTrend> lineEquationsLT) {
		this.lineEquationsLT = lineEquationsLT;
	}

	public synchronized List<LineEquation> getLineEquations() {
		return lineEquations;
	}

	public synchronized void setLineEquations(List<LineEquation> lineEquations) {
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

	public TrendPointXY lastPointOfTrend() {
		TrendPointXY pt1 = new TrendPointXY();

		if (this.getPointsXY() != null) {
			pt1.setX(this.getPointsXY().get(0).getX());
			pt1.setY(this.getPointsXY().get(0).getY());
		}

		return pt1;
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

	public TrendPointXY calculationLastTrendPt2() {

		TrendPointXY pt = new TrendPointXY();

		return pt;
	}

	public void askCalculationLineEquationLastTrend() {

		List<TrendPointXY> pointsXY = new ArrayList<>(this.getPointsXY());
		LineEquationLastTrend1 lineEquationLT1 = new LineEquationLastTrend1(this, pointsXY);
		Thread t0 = new Thread(lineEquationLT1);
		t0.start();
		LineEquationLastTrend2 lineEquationLT2 = new LineEquationLastTrend2(this, pointsXY);
		Thread t1 = new Thread(lineEquationLT2);
		t1.start();
	}

	/*
	 * wait result calculation
	 * if return true, the data is viable
	 * if return false, the data is not viable
	 */
	public boolean waitResultEquation() {

		int i = 0;
		while (true) {
			System.out.println("poursuite!!!!");
			if (this.getLineEquations().size() == 3 && this.getLineEquationsLT().size() == 2
					&& this.getLastPoint() != null) {

				return true;
			}
			
			if (i > 50) {
				//time is exceeded
				return false;
			}
			i++;
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	public void treatmentNotationBid() {
		// it's worth selling when the bid is at near of the ceiling line

		// stage 0 : variables initialization
		
		//variable note
		double note1 = 0.0; // comparison position last point between ceiling and support
		double note2 = 0.0; // comparison position last point between ceiling and average
		double intermediateNote = 0.0; // intermediateNote result note without last trend
		double globalNote = 0.0; // result note

		
		// variable line equation of curve
		double aAverage=0.0;
		double bAverage=0.0;
		double aCeiling=0.0;
		double bCeiling=0.0;
		double aSupport=0.0;
		double bSupport=0.0;
		
		// connected data line Equation
		Iterator<LineEquation> ite = this.getLineEquations().iterator();
		
		while (ite.hasNext()) {
			LineEquation le = ite.next();
			if ("Average".equals(le.getName())){
				aAverage = le.getLeadingDirect();
				bAverage = le.getOrdOrigin();
			}else if ("Ceiling".equals(le.getName())) {
				aCeiling = le.getLeadingDirect(); 
				bCeiling = le.getOrdOrigin();
			}else if ("Support".equals(le.getName())) {
				aSupport = le.getLeadingDirect();
				bSupport = le.getOrdOrigin();
			}else {
				System.out.println("erreur manque des données pour notation");
			}
			
		}

		// variable line equation of last trend 1 and last trend 2
		//Line Last trend 1 this the line between le last point and the before last point 
		// only the guideline coefficients are taken into consideration
		double aLt1=0.0;
		double aLt2=0.0;

		
		// connected data line Equation LAST TREND
		Iterator<ILineEquationLastTrend> ite1 = this.getLineEquationsLT().iterator();
		
		while (ite1.hasNext()) {
			LineEquation le = (LineEquation) ite1.next();
			if ("Lt1".equals(le.getName())){
				aLt1 = le.getLeadingDirect();
			}else if ("Lt2".equals(le.getName())) {
				aLt2 = le.getLeadingDirect(); 
			}else {
				System.out.println("erreur manque des données pour notation");
			}
			
		}
		
		
		//variable last point
		double yPt = this.getLastPoint().getY();
		long xRef = this.getLastPoint().getX();
		
		int multiplier = this.getTrendRule().getMultiplier();



		// Stage 1 : value of the gap between ceiling and support
		double gapCeilingSupport = (aCeiling * xRef + bCeiling) - (aSupport * xRef + bSupport);

		if (gapCeilingSupport < 0) {
			System.out.println("erreur de calcul");
		}

		// Stage 2 : value of the gap between ceiling and average
		double gapCeilingAverage = (aCeiling * xRef + bCeiling) - (aAverage * xRef + bAverage);

		if (gapCeilingAverage < 0) {
			System.out.println("erreur de calcul");
		}

		// Stage 3 : comparison position last point between ceiling and support
		// gapCeilingPt<0 : last point is above ceiling line, note>1
		// gapCeilingPt>=0 && gapCeilingPt<=gapCeilingSupport : last point is between
		// ceiling and support 0>note>1
		// gapCeilingPt>=0 && gapCeilingPt>gapCeilingSupport : last point is below
		// support note=0

		double gapCeilingPt = (aCeiling * xRef + bCeiling) - yPt;

		if (gapCeilingPt < 0) {
			note1 = 1 + Math.abs(gapCeilingPt) / gapCeilingSupport;
		} else if (gapCeilingPt >= 0 && Math.abs(gapCeilingPt) <= gapCeilingSupport) {
			note1 = 1 - Math.abs(gapCeilingPt) / gapCeilingSupport;
		} else if (gapCeilingPt >= 0 && Math.abs(gapCeilingPt) > gapCeilingSupport) {
			note1 = 0;
		} else {
			System.out.println("calcul de note pas pris en compte bid , support et ceiling");
		}

		// Stage 4 : comparison position last point between ceiling and average
		// gapCeilingPt<0 : last point is above ceiling line, note>1
		// gapCeilingPt>=0 && gapCeilingPt<=gapCeilingaverage : last point is between
		// ceiling and average 0>note>1
		// gapCeilingPt>=0 && gapCeilingPt>gapCeilingaverage : last point is below
		// average note=0

		if (gapCeilingPt < 0) {
			note2 = 1 + Math.abs(gapCeilingPt) / gapCeilingAverage;
		} else if (gapCeilingPt >= 0 && Math.abs(gapCeilingPt) <= gapCeilingAverage) {
			note2 = 1 - Math.abs(gapCeilingPt) / gapCeilingAverage;
		} else if (gapCeilingPt >= 0 && Math.abs(gapCeilingPt) > gapCeilingAverage) {
			note2 = 0;
		} else {
			System.out.println("calcul de note pas pris en compte bid , support et average");
		}

		// stage 6 : calculation intermediate Note
		intermediateNote = (note1 + note2) * multiplier;
		
		//stage 7 : taking into account the latest trend
		
		double multiplierLastTrend =0.0;
		
		if (aLt2>=0) {
			multiplierLastTrend =0.0;
			System.out.println("pente positive tendance achat");
		}else if (aLt2<0) {
			
			// calculation multiplier :the higher the slope, the more the multiplicative is important
			if (aLt1>=aLt2) {
				multiplierLastTrend =(aLt1/aLt2)*2 + 1;
				System.out.println("pente douce favorable à la vente, mais tendance à l'achat");
			}else if (aLt1<aLt2) {
				multiplierLastTrend =(aLt1/aLt2)*2 + (-3 * (aLt2/aLt1) +3);
				System.out.println("pente brute favorable à la vente");
			}
		}
		
		
		globalNote = intermediateNote*multiplierLastTrend;
		
		// stage 8 : calculation the global Note
		this.setNote(globalNote);
		
		
		
		System.out.println("note : " + globalNote );

	}

	public static void main(String[] args) {

		// TrendPointXY pt1 = new TrendPointXY();
		// pt1.setX(1000L);
		// pt1.setY(1.0);
		// TrendPointXY pt2 = new TrendPointXY();
		// pt2.setX(2000L);
		// pt2.setY(2.0);
		// TrendPointXY pt3 = new TrendPointXY();
		// pt3.setX(3000L);
		// pt3.setY(3.0);
		// TrendPointXY pt4 = new TrendPointXY();
		// pt4.setX(4000L);
		// pt4.setY(4.0);
		// TrendPointXY pt5 = new TrendPointXY();
		// pt5.setX(5000L);
		// pt5.setY(5.0);
		//
		// List<TrendPointXY> list = new ArrayList<>();
		// list.add(pt1);
		// list.add(pt2);
		// list.add(pt3);
		// list.add(pt4);
		// list.add(pt5);
		//
		// TrendNote tn = new TrendNoteToBuy();
		// tn.setPointsXY(list);
		//
		// TrendPointXY pt = tn.calculationAveragePt2();
		//
		// System.out.println("temps " + pt.getX() + ", value " + pt.getY());

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

		Collections.sort(list, TrendPointXY.ptComparatorByDate);

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
