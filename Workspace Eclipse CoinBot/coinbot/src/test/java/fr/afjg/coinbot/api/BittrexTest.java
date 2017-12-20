package fr.afjg.coinbot.api;

import java.io.IOException;

import org.json.JSONException;

import fr.afjg.coinbot.external.api.entites.bittrex.Market;
import fr.afjg.coinbot.external.api.miscellaneous.BittrexGetMarketServiceImpl;
import fr.afjg.coinbot.external.api.miscellaneous.intf.BittrexGetMarketServiceIntf;

public class BittrexTest {

	public static void main(String[] args) {
		
		BittrexGetMarketServiceIntf bittrexService = new BittrexGetMarketServiceImpl();
		try {
			Market market = bittrexService.getMarket();
			System.out.println(market.toString());
		} catch (IOException e) {
			// problème de connexion ou réceptions des informations
			e.printStackTrace();
		} catch (JSONException e) {
			// Problème lors du parse
			e.printStackTrace();
		}

	}

}
