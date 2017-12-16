package fr.afjg.coinbot.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 * 
 * @author GHISLAIN
 *
 */
public class DateTools {

	
	
	/*
	 * convert timestamp in date
	 */
	public static Date timestampConvertDate (Timestamp stamp) {
		
		Date date = new Date (stamp.getTime());
		return date;
	}
	
	

	/**
	 * convert date in timestamp
	 * @param date
	 * @return Timestamp
	 * 
	 */
	public static Timestamp dateConvertTimestamp (Date date) {
		
		Timestamp stamp = new Timestamp(date.getTime());
		return stamp;
	}
	
	/*
	 * today date in format java.sql.date
	 */
	public static Date todayDate () {
		
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date (stamp.getTime());
		return date;
	}
	
	
	/**
	 * 
	 * @param formatting
	 * @param date
	 * @return
	 * retourne une date renseignée au format que vous souhaitez<br>
	 * returns a date in the format you want<br>
	 * <br>
	 * <b>Exemple de code</b><br>
	 * Jour de la notice 19.11.2017<br>
	 * The day of the notice 19.11.2017<br>
	 * {@code DateTools.dateFormat("yy",date)  // retourne 17}<br>
	 * {@code DateTools.dateFormat("yyyy",date)  // retourne 2017}<br>
	 * {@code DateTools.dateFormat("dd/MM/yyy",date)  // retourne 19/11/2017}<br>
	 * {@code DateTools.dateFormat("EEEE, d MMM yyyy",date)  // retourne dimanche, 19 nov. 2017}<br>
	 * {@code DateTools.dateFormat("'le' dd/MM/yyyy 'à' HH:mm:ss",date)  // retourne le 19/11/2017 à 08:20:16}<br>
	 * {@code DateTools.dateFormat("HH:mm:ss",date)  // retourne 08:20:51}
	 */
	
	public static String dateFormat(String formatting, Date date) {
		
		SimpleDateFormat formater = new SimpleDateFormat(formatting);
			
		return  formater.format(date.getTime());
	}
	
	
	

	
	

	/*
	 * test methods
	 */
	public static void main(String[] args) {
		

		Date date = DateTools.todayDate();
		
		System.out.println(DateTools.dateFormat("HH:mm:ss",date));


		
	}
}
