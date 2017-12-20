package fr.afjg.coinbot.external.api.miscellaneous.intf;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;

import fr.afjg.coinbot.external.api.entities.coinmarketcap.Market;

public interface CoinMarketCapGetFirstHundredMarketIntf {
	
	public Set<Market> getMarket() throws IOException, JSONException;

}
