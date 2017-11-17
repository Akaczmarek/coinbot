package fr.afjg.coinbot.test.second;

import java.io.IOException;

import org.json.JSONException;

import fr.afjg.coinbot.pojo.Market;
import fr.afjg.coinbot.service.impl.BittrexGetMarketServiceImpl;
import fr.afjg.coinbot.service.intf.BittrexGetMarketServiceIntf;

public class test2 {

	public static void main(String[] args) {
		
		BittrexGetMarketServiceIntf bittrexService = new BittrexGetMarketServiceImpl();
		try {
			Market market = bittrexService.getMarket();
			System.out.println(market.toString());
			System.out.println("des bisous test alain commit");
		} catch (IOException e) {
			// problème de connexion ou réceptions des informations
			e.printStackTrace();
		} catch (JSONException e) {
			// Problème lors du parse
			e.printStackTrace();
		}
		
	}
	
	

	

}
