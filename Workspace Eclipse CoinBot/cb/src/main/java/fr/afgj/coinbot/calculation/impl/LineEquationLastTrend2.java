package fr.afgj.coinbot.calculation.impl;

import java.util.Iterator;
import java.util.List;

import fr.afgj.coinbot.calculation.ILineEquationLastTrend;

public class LineEquationLastTrend2 extends LineEquation implements ILineEquationLastTrend {

	public LineEquationLastTrend2() {

	}
	public LineEquationLastTrend2(TrendNote trendNote, List<TrendPointXY> pointsXY) {
		super(trendNote, pointsXY);
		this.setName("Lt2");
	}

	@Override
	public void run() {

		// stage 0: definition the two last point of list

		// stage 0.1 : the last point
		this.setAveragePt1(lastPointofLastTrend());

		// stage 0.2 : the first point defining the latest trend
		this.setAveragePt2(ptBaseOfLastTrend());

		// stage 1 : calculation equation

		this.calculationAverageLineEquation();

		// stage 2 : save line equation
		this.getTrendNote().getLineEquationsLT().add(this);
		
		
	}


	public TrendPointXY ptBaseOfLastTrend() {

		TrendPointXY pt = new TrendPointXY();

		if (this.getPointsXY() != null) {

			TrendPointXY ptn = null; // ptn = the current point pt(n)study
			TrendPointXY ptn1 = null; // ptn1 = the point pt(n+1) of list
			String checkTrend = null; // memorize the trend

			Iterator<TrendPointXY> ite = this.getPointsXY().iterator();

			while (ite.hasNext()) {

				ptn = ite.next();

				if (ptn1 != null) {

					if ((ptn1.getY() - ptn.getY()) > 0 && (checkTrend == null || "up".equals(checkTrend))) {
						checkTrend = "up";

						ptn1 = ptn;
						pt = ptn1;

					} else if ((ptn1.getY() - ptn.getY()) < 0 && (checkTrend == null || "down".equals(checkTrend))) {
						checkTrend = "down";
						ptn1 = ptn;
						pt = ptn1;

					} else if ((ptn1.getY() - ptn.getY()) == 0) {

						// incompatible value, redo a ride
						ptn1 = ptn;
						pt = ptn1;
					} else {

						pt = ptn1;
						break;
					}

				} else {
					ptn1 = ptn;
				}

			}

		}

		return pt;
	}



}
