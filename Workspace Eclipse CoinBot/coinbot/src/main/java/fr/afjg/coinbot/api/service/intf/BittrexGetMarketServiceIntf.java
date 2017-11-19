package fr.afjg.coinbot.api.service.intf;

import java.io.IOException;

import org.json.JSONException;

import fr.afjg.coinbot.api.pojo.Market;

public interface BittrexGetMarketServiceIntf {
	
	public Market getMarket() throws IOException, JSONException;
	
}
