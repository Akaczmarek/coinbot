package fr.afjg.coinbot.api;

import java.io.IOException;

import org.json.JSONException;

import fr.afjg.coinbot.external.api.entites.bittrex.Market;
import fr.afjg.coinbot.external.api.miscellaneous.BittrexGetMarketServiceImpl;
import fr.afjg.coinbot.external.api.miscellaneous.intf.IBittrexGetMarketService;

public class BittrexTest {

	public static void main(String[] args) {
		
		IBittrexGetMarketService bittrexService = new BittrexGetMarketServiceImpl();
		Market market = bittrexService.getMarket();
		System.out.println(market.toString());

	}

}
