package fr.afjg.coinbot.api;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;

import fr.afjg.coinbot.external.api.entities.coinmarketcap.Market;
import fr.afjg.coinbot.external.api.miscellaneous.CoinMarketCapGetFirstHundredMarket;
import fr.afjg.coinbot.external.api.miscellaneous.intf.CoinMarketCapGetFirstHundredMarketIntf;

public class CoinMarketCapTest {

	public static void main(String[] args) {
		
		CoinMarketCapGetFirstHundredMarketIntf cmc = new CoinMarketCapGetFirstHundredMarket();
		try {
			Set<Market> listMarket = cmc.getMarket();
			for(Market market : listMarket) {
				System.out.println(market.toString());
			}
		} catch (IOException e) {
			// problème de connexion ou réceptions des informations
			e.printStackTrace();
		} catch (JSONException e) {
			// Problème lors du parse
			e.printStackTrace();
		}
		
	}

}
