package fr.afjg.coinbot.util;


import java.math.BigDecimal;

/**
 * 
 * @author GHISLAIN
 * Methods math
 */

public class MathTools {
	
	/**
	 * round double in bigDecimal
	 * @param number
	 * @param nbDecimal
	 * @return
	 */
	public static BigDecimal round(Double number, int nbDecimal) {
		
		BigDecimal value;
		
		value = (new BigDecimal(number)).setScale(nbDecimal, BigDecimal.ROUND_HALF_UP);
	
		return value;
	}
	
	/**
	 * round double in double
	 * @param number
	 * @param nbDecimal
	 * @return
	 * 
	 * 
	 */
	public static Double dblRoundDbl(Double number, int nbDecimal) {
		
		BigDecimal value;
		Double correctedValue;
		
		value = (new BigDecimal(number)).setScale(nbDecimal, BigDecimal.ROUND_HALF_UP);
		correctedValue=Double.parseDouble(value.toString());
	
		return correctedValue;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
//		BigDecimal valeur = null;
//		String strValeur = null;
//		
//		double test =12.3336;
//		
//		strValeur = "0.225";
//		valeur = (new BigDecimal(test)).setScale(3, BigDecimal.ROUND_HALF_UP);
//		System.out.println("ROUND_HALF_UP    "+strValeur+" :  "+valeur.toString()); 
		
		System.out.println((dblRoundDbl(152.366698222,6).toString()));
		
	}
	//Test alain
	
}
