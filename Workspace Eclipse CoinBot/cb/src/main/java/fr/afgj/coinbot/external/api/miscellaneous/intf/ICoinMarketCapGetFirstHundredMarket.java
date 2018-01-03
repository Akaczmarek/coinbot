package fr.afgj.coinbot.external.api.miscellaneous.intf;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;

import fr.afgj.coinbot.external.api.entities.coinmarketcap.Market;

public interface ICoinMarketCapGetFirstHundredMarket {
	
	public Set<Market> getMarket() throws IOException, JSONException;

}
