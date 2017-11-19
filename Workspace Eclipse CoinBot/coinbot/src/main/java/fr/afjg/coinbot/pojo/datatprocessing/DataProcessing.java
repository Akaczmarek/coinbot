package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.afjg.coinbot.pojo.database.CurrencyRateBTC;

/**
 * methods list for currency framing
 * 
 * @author GHISLAIN
 *
 */
public class DataProcessing {
	
	
	public static List<CurrencyRateBTC> parseSetInList()

	/**
	 * parseSPBidPt
	 * 
	 * @param listStockPrices
	 * @return
	 * 
	 * 
	 * 		{@code DataProcessing.parseSPBidPt(list)}
	 */
	public static List<PointXY> parseSPBidPt(List<CurrencyRateBTC> listStockPrices) {
		List<PointXY> PointsXY = new ArrayList<>();
		Iterator<CurrencyRateBTC> ite = listStockPrices.iterator();

		while (ite.hasNext()) {
			CurrencyRateBTC price = ite.next();
			PointsXY.add(new PointXY(price.getInfoTimeStamp(), price.getBidBTC()));

		}

		return PointsXY;
	}

	/**
	 * parsePtsOneInTwo
	 * 
	 * @param pointsXY
	 * @return <br>
	 *         Separate the list pointXY in two <br>
	 *         <br>
	 *         {@code DataProcessing.parsePtsOneInTwo(list)}
	 */

	public static PointXY[][] parsePtsOneInTwo(List<PointXY> pointsXY) {

		PointXY[][] splitList = new PointXY[2][(pointsXY.size() / 2) + 1];

		int k = 0;
		for (int i = 0; i < pointsXY.size(); i++) {

			if (i <= (pointsXY.size() / 2)) {
				splitList[0][i] = pointsXY.get(i);
			} else {
				splitList[1][k] = pointsXY.get(i);
				k++;
			}

		}

		return splitList;

	}

}
