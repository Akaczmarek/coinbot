package fr.afjg.coinbot.entity.datatprocessing;

import java.util.Iterator;
import java.util.List;

public class CurrencyNote implements Runnable {

	private String typeBidOrAsk; // "bid" or "ask"
	private CurrencyNotes currencyNotes;
	private List<LineEquationTrend> lets;
	private List<LastTrend> lts;
	private PointXY lastPoint;
	private TrendRule trendRule;
	private double note;

	public CurrencyNote(CurrencyNotes currencyNotes, List<LineEquationTrend> lets, List<LastTrend> lts,
			PointXY lastPoint, TrendRule trendRule, String typeBidOrAsk) {
		this.setCurrencyNotes(currencyNotes);
		this.setLets(lets);
		this.setLts(lts);
		this.setLastPoint(lastPoint);
		this.setTypeBidOrAsk(typeBidOrAsk);
		this.setTrendRule(trendRule);
	}

	public String getTypeBidOrAsk() {
		return typeBidOrAsk;
	}

	public void setTypeBidOrAsk(String typeBidOrAsk) {
		this.typeBidOrAsk = typeBidOrAsk;
	}

	public CurrencyNotes getCurrencyNotes() {
		return currencyNotes;
	}

	public void setCurrencyNotes(CurrencyNotes currencyNotes) {
		this.currencyNotes = currencyNotes;
	}

	public List<LineEquationTrend> getLets() {
		return lets;
	}

	public void setLets(List<LineEquationTrend> lets) {
		this.lets = lets;
	}

	public List<LastTrend> getLts() {
		return lts;
	}

	public void setLts(List<LastTrend> lts) {
		this.lts = lts;
	}

	public PointXY getLastPoint() {
		return lastPoint;
	}

	public void setLastPoint(PointXY lastPoint) {
		this.lastPoint = lastPoint;
	}

	public TrendRule getTrendRule() {
		return trendRule;
	}

	public void setTrendRule(TrendRule trendRule) {
		this.trendRule = trendRule;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// stage 0 : variables initialization

		PointXY lastPoint = this.getLastPoint();
		LineEquationTrend averageLE = null;
		LineEquationTrend supportLE = null;
		LineEquationTrend ceilingLE = null;

		// locate the 3 lines type
		Iterator<LineEquationTrend> iteLET = this.getLets().iterator();
		while (iteLET.hasNext()) {

			LineEquationTrend let = iteLET.next();
			// "average" or "support" or "ceiling"

			switch (let.getTypeLine()) {

			case "average":
				averageLE = let;
				break;
			case "support":
				supportLE = let;
				break;
			case "ceiling":
				ceilingLE = let;
				break;
			default:
				System.out.println("problème d'identification équation");

			}
		}

		// stage 1 : treatment notation last point between three lines

		switch (this.getTypeBidOrAsk()) {

		case "bid":
			treatmentNotationBid(averageLE, supportLE, ceilingLE, lastPoint);
			break;
		case "ask":
			treatmentNotationAsk(averageLE, supportLE, ceilingLE, lastPoint);
			break;
		default:
			System.out.println("problème d'identification bid ou ask");

		}

		// final Stage : prevent it's finished

		this.getCurrencyNotes().finishActionsChecked();
	}

	private void treatmentNotationBid(LineEquationTrend averageLE, LineEquationTrend supportLE,
			LineEquationTrend ceilingLE, PointXY lastPoint) {
		// it's worth selling when the bid is at near of the ceiling line

		// stage 0 : variables initialization
		double yPt = lastPoint.getY();
		long xRef = lastPoint.getX();
		double aCeiling = ceilingLE.getLeadingDirect();
		double bCeiling = ceilingLE.getOrdOrigin();
		double aAverage = averageLE.getLeadingDirect();
		double bAverage = averageLE.getOrdOrigin();
		double aSupport = supportLE.getLeadingDirect();
		double bSupport = supportLE.getOrdOrigin();
		
		int multiplier = this.getTrendRule().getMultiplier();

		double note1 = 0; // comparison position last point between ceiling and support
		double note2 = 0; // comparison position last point between ceiling and average
		double globalNote = 0;

		// Stage 1 : value of the gap between ceiling and support
		double gapCeilingSupport = (aCeiling * xRef + bCeiling) - (aSupport * xRef + bSupport);
		if (gapCeilingSupport < 0)
			System.out.println("erreur de calcul");

		// Stage 2 : value of the gap between ceiling and average
		double gapCeilingAverage = (aCeiling * xRef + bCeiling) - (aAverage * xRef + bAverage);
		if (gapCeilingAverage < 0)
			System.out.println("erreur de calcul");

		// Stage 3 : comparison position last point between ceiling and support
		// gapCeilingPt<0 : last point is above ceiling line, note>1
		// gapCeilingPt>=0 && gapCeilingPt<=gapCeilingSupport : last point is between
		// ceiling and support 0>note>1
		// gapCeilingPt>=0 && gapCeilingPt>gapCeilingSupport : last point is below
		// support note=0

		double gapCeilingPt = (aCeiling * xRef + bCeiling) - yPt;
		if (gapCeilingPt < 0) {
			note1 = 1 + gapCeilingPt / gapCeilingSupport;
		} else if (gapCeilingPt >= 0 && gapCeilingPt <= gapCeilingSupport) {
			note1 = 1 - gapCeilingPt / gapCeilingSupport;
		} else if (gapCeilingPt >= 0 && gapCeilingPt > gapCeilingSupport) {
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
			note2 = 1 + gapCeilingPt / gapCeilingAverage;
		} else if (gapCeilingPt >= 0 && gapCeilingPt <= gapCeilingAverage) {
			note2 = 1 - gapCeilingPt / gapCeilingAverage;
		} else if (gapCeilingPt >= 0 && gapCeilingPt > gapCeilingAverage) {
			note2 = 0;
		} else {
			System.out.println("calcul de note pas pris en compte bid , support et average");
		}
		
		
		//stage 6 : calculation global note
		globalNote = (note1 + note2)*multiplier;

	}
	
	private void treatmentNotationAsk(LineEquationTrend averageLE, LineEquationTrend supportLE,
			LineEquationTrend ceilingLE, PointXY lastPoint) {
		// it's worth buying when the ask is at near of the support line

		// stage 0 : variables initialization
		double yPt = lastPoint.getY();
		long xRef = lastPoint.getX();
		double aCeiling = ceilingLE.getLeadingDirect();
		double bCeiling = ceilingLE.getOrdOrigin();
		double aAverage = averageLE.getLeadingDirect();
		double bAverage = averageLE.getOrdOrigin();
		double aSupport = supportLE.getLeadingDirect();
		double bSupport = supportLE.getOrdOrigin();
		
		int multiplier = this.getTrendRule().getMultiplier();

		double note1 = 0; // comparison position last point between ceiling and support
		double note2 = 0; // comparison position last point between ceiling and average
		double globalNote = 0;

		// Stage 1 : value of the gap between ceiling and support
		double gapCeilingSupport = (aCeiling * xRef + bCeiling) - (aSupport * xRef + bSupport);
		if (gapCeilingSupport < 0)
			System.out.println("erreur de calcul");

		// Stage 2 : value of the gap between ceiling and average
		double gapAverageSupport = (aAverage * xRef + bAverage) - (aSupport * xRef + bSupport);
		if (gapAverageSupport < 0)
			System.out.println("erreur de calcul");

		// Stage 3 : comparison position last point between ceiling and support
		// gapSupportPt > 0 : last point is below support line, note>1
		// gapCeilingPt<=0 && gapCeilingPt<=gapCeilingSupport : last point is between
		// ceiling and support 0>note>1
		// gapCeilingPt>=0 && gapCeilingPt>gapCeilingSupport : last point is below
		// support note=0

		double gapSupportPt = (aSupport * xRef + bSupport) - yPt;
		if (gapSupportPt > 0) {
			note1 = 1 + gapSupportPt / gapCeilingSupport;
		} else if (gapSupportPt >= 0 && gapSupportPt <= gapCeilingSupport) {
			note1 = 1 - gapSupportPt / gapCeilingSupport;
		} else if (gapSupportPt >= 0 && gapSupportPt > gapCeilingSupport) {
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

		if (gapSupportPt < 0) {
			note2 = 1 + gapSupportPt / gapAverageSupport;
		} else if (gapSupportPt >= 0 && gapSupportPt <= gapAverageSupport) {
			note2 = 1 - gapSupportPt / gapAverageSupport;
		} else if (gapSupportPt >= 0 && gapSupportPt > gapAverageSupport) {
			note2 = 0;
		} else {
			System.out.println("calcul de note pas pris en compte bid , support et average");
		}
		
		
		//stage 6 : calculation global note
		globalNote = (note1 + note2)*multiplier;

	}

}
