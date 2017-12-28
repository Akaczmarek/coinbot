package fr.afgj.coinbot.test.calculation.TrendNote;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.afgj.coinbot.calculation.impl.LineEquationLastTrend2;
import fr.afgj.coinbot.calculation.impl.TrendPointXY;

public class TestLineEquationLastTrend {
	public static void main(String[] args) {

		LineEquationLastTrend2 lt2 = new LineEquationLastTrend2();

		int y = 0;

		List<TrendPointXY> is = new ArrayList<>();
		for (int i = 0; i < 10; i++) {

			y = (int) (Math.random() * 10);
			TrendPointXY pt = new TrendPointXY(i, y);
			is.add(pt);
		}
		
		lt2.setPointsXY(is);

		int i = 0;
		for (TrendPointXY pt : is) {
			System.out.println(i + ". x = " + pt.getX() + " ; y = " + pt.getY());
			i++;
		}

		System.out.println("next----------------------------");

		Iterator<TrendPointXY> ite = is.iterator();

		while (ite.hasNext()) {
			TrendPointXY pt = ite.next();
			System.out.println(". x = " + pt.getX() + " ; y = " + pt.getY());
		}

		System.out.println("last point----------------------------");
		TrendPointXY pt = lt2.lastPointofLastTrend();
		System.out.println(". x = " + pt.getX() + " ; y = " + pt.getY());

		
		System.out.println("penultimate point----------------------------");
		TrendPointXY pt1 = lt2.penultimatePointofLastTrend();
		System.out.println(". x = " + pt1.getX() + " ; y = " + pt1.getY());
		
		System.out.println("base point----------------------------");
		TrendPointXY pt2 = lt2.ptBaseOfLastTrend();
		System.out.println(". x = " + pt2.getX() + " ; y = " + pt2.getY());

	}
}
