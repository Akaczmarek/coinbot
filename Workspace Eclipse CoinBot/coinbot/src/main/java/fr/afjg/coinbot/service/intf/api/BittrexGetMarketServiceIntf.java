package fr.afjg.coinbot.service.intf.api;

import java.io.IOException;

import org.json.JSONException;

import fr.afjg.coinbot.pojo.api.bittrex.Market;

public interface BittrexGetMarketServiceIntf {
	
	public Market getMarket() throws IOException, JSONException;
	
}
