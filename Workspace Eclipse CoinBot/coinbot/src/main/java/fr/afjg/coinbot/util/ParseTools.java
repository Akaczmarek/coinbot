package fr.afjg.coinbot.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.PointXY;

public class ParseTools {

	/*
	 * transform CurrentyRate list in pointXY list
	 */

	public static List<PointXY> transformCRListInPtList(List<CurrencyRate> cRList, String typeBidOrAsk) {
		List<PointXY> pointXYList = new ArrayList<>();
		Iterator<CurrencyRate> ite = cRList.iterator();

		if ("ask".equals(typeBidOrAsk)) {

			while (ite.hasNext()) {
				CurrencyRate cr = ite.next();

				pointXYList.add(new PointXY(cr.getTimeRecord().getTime(), cr.getAskBTC()));
			}

		} else if ("bid".equals(typeBidOrAsk)) {

			while (ite.hasNext()) {
				CurrencyRate cr = ite.next();

				pointXYList.add(new PointXY(cr.getTimeRecord().getTime(), cr.getBidBTC()));
			}

		}

		return pointXYList;
	}
	
	/*
	 * split a pointXY list into two
	 */
	
	public static PointXY[][] parselistpointXYen2 (List<PointXY> liste){
		
		PointXY[][] doubleList = new PointXY[2][(liste.size()/2)+1];
		
		int k = 0;
		for (int i= 0; i<liste.size();i++) {
			
			if (i<=(liste.size()/2)) {
				doubleList[0][i] = liste.get(i);
			}else {
				doubleList[1][k] = liste.get(i);
				k++;
			}
			
		}

		return doubleList;
		
	}

}
