package fr.afgj.coinbot.test.calculation.TrendNote;

import fr.afgj.coinbot.calculation.impl.LineEquationAverage;
import fr.afgj.coinbot.calculation.impl.TrendPointXY;

public class TestLineEquation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TrendPointXY pt0 =  new TrendPointXY(1, 0);
		TrendPointXY pt1 =  new TrendPointXY(0, 3);
		
		LineEquationAverage lea = new LineEquationAverage();
		lea.setAveragePt1(pt0);
		lea.setAveragePt2(pt1);
		lea.calculationAverageLineEquation();
		System.out.println("a = " + lea.getLeadingDirect() + " b = " + lea.getOrdOrigin());
		
	}

}
