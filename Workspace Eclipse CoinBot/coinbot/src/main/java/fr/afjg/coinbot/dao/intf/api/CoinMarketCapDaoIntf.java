package fr.afjg.coinbot.dao.intf.api;

import java.io.IOException;

public interface CoinMarketCapDaoIntf {
	
	public StringBuffer getFirstHundredMarket() throws IOException;
	
}
