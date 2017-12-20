package fr.afjg.coinbot.external.api.miscellaneous.intf;

import java.io.IOException;

import org.json.JSONException;

import fr.afjg.coinbot.external.api.entites.bittrex.Market;

public interface BittrexGetMarketServiceIntf {
	
	public Market getMarket() throws IOException, JSONException;
	
}
