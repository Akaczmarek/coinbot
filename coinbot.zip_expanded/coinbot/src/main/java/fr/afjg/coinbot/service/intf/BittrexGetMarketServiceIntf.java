package fr.afjg.coinbot.service.intf;

import java.io.IOException;

import org.json.JSONException;

import fr.afjg.coinbot.pojo.Market;

public interface BittrexGetMarketServiceIntf {
	
	public Market getMarket() throws IOException, JSONException;
	
}
