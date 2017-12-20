package fr.afjg.coinbot.external.api.intf;

import java.io.IOException;

public interface CoinMarketCapDaoIntf {
	
	public StringBuffer getFirstHundredMarket() throws IOException;
	
}
