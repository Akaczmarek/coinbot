package fr.afjg.coinbot.api.test;

import fr.afjg.coinbot.external.api.entites.bittrex.Markets;
import fr.afjg.coinbot.external.api.miscellaneous.BittrexGetMarketServiceImpl;
import fr.afjg.coinbot.external.api.miscellaneous.intf.IBittrexGetMarketService;

public class Bittrex {

	public static void main(String[] args) {
		
		IBittrexGetMarketService bittrexService = new BittrexGetMarketServiceImpl();
		Markets market = bittrexService.getMarket();
		System.out.println(market.toString());
		
		
		
	}

}
