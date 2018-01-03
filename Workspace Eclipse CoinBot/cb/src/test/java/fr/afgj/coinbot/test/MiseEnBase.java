package fr.afgj.coinbot.test;

import java.util.Set;

import fr.afgj.coinbot.repository.CurrencyRepository;
import fr.afgj.coinbot.repository.CurrencyTrendRepository;
import fr.afgj.coinbot.external.api.entities.coinmarketcap.Market;
import fr.afgj.coinbot.external.api.miscellaneous.BittrexGetMarketServiceImpl;
import fr.afgj.coinbot.external.api.miscellaneous.CoinMarketCapGetFirstHundredMarket;
import fr.afgj.coinbot.external.api.miscellaneous.intf.IBittrexGetMarketSummary;
import fr.afgj.coinbot.external.api.miscellaneous.intf.ICoinMarketCapGetFirstHundredMarket;

public class MiseEnBase {

	public static void main(String[] args) {
		
		ICoinMarketCapGetFirstHundredMarket cmc = new CoinMarketCapGetFirstHundredMarket();
		CurrencyRepository cr;
		
		Iterable<Market> fhm = cmc.getMarket();
		
		cr.save(fhm);
		
		
		
		CurrencyTrendRepository ctr;
		IBittrexGetMarketSummary bms = (IBittrexGetMarketSummary) new BittrexGetMarketServiceImpl();
		
		//ctr.save(bms.getMarketSummary(market));
		
	}
	
}
