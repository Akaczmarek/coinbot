package fr.afjg.coinbot.service.intf.api;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;

import fr.afjg.coinbot.pojo.api.coinmarketcap.Market;

public interface CoinMarketCapGetFirstHundredMarketIntf {
	
	public Set<Market> getMarket() throws IOException, JSONException;

}
