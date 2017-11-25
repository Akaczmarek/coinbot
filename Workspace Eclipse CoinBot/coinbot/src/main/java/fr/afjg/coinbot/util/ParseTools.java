package fr.afjg.coinbot.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.PointXY;

public class ParseTools {

	// transform CurrentyRate list in pointXY list
	public static List<PointXY> parseListObjet(List<CurrencyRate> cRList, String typeBidOrAsk) {
		List<PointXY> pointXYList = new ArrayList<>();
		Iterator<CurrencyRate> ite = cRList.iterator();

		if ("ask".equals(typeBidOrAsk)) {
			
			while (ite.hasNext()) {
				CurrencyRate cr = ite.next();

				pointXYList.add(new PointXY(cr.getTimeRecord().getTime(), cr.getAskBTC()));
			}
			
			
		}else if ("bid".equals(typeBidOrAsk)) {
			
			while (ite.hasNext()) {
				CurrencyRate cr = ite.next();

				pointXYList.add(new PointXY(cr.getTimeRecord().getTime(), cr.getBidBTC()));
			}
			
		}

		return pointXYList;
	}

}
