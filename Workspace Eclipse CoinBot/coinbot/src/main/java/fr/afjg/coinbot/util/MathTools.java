package fr.afjg.coinbot.util;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import fr.afjg.coinbot.pojo.datatprocessing.PointXY;

/**
 * 
 * @author GHISLAIN Methods math
 */

public class MathTools {

	/**
	 * round double in bigDecimal
	 * 
	 * @param number
	 * @param nbDecimal
	 * @return
	 */
	public final static BigDecimal round(Double number, int nbDecimal) {

		BigDecimal value;

		value = (new BigDecimal(number)).setScale(nbDecimal, BigDecimal.ROUND_HALF_UP);

		return value;
	}

	/**
	 * round double in double
	 * 
	 * @param number
	 * @param nbDecimal
	 * @return
	 * 
	 * 
	 */
	public final static Double dblRoundDbl(Double number, int nbDecimal) {

		BigDecimal value;
		Double correctedValue;

		value = (new BigDecimal(number)).setScale(nbDecimal, BigDecimal.ROUND_HALF_UP);
		correctedValue = Double.parseDouble(value.toString());

		return correctedValue;
	}

	/*
	 * calculation of average point
	 * 
	 */
	public final static PointXY averagePoint(List<PointXY> list) {

		PointXY ptXY = new PointXY();

		long x = 0;
		double y = 0;
		int k = 0;

		Iterator<PointXY> ite = list.iterator();

		while (ite.hasNext()) {
			PointXY pt = ite.next();

			x = x + pt.getX();
			y = y + pt.getY();
			
			k++;
		}
		
		x=x/k;
		y=y/k;
		
		ptXY.setX(x);
		ptXY.setY(y);

		return ptXY;
	}
	


	public static void main(String[] args) {

		// BigDecimal valeur = null;
		// String strValeur = null;
		//
		// double test =12.3336;
		//
		// strValeur = "0.225";
		// valeur = (new BigDecimal(test)).setScale(3, BigDecimal.ROUND_HALF_UP);
		// System.out.println("ROUND_HALF_UP "+strValeur+" : "+valeur.toString());

		System.out.println((dblRoundDbl(152.366698222, 6).toString()));

	}

}
