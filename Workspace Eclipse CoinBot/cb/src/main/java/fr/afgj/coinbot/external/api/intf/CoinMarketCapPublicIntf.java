package fr.afgj.coinbot.external.api.intf;

import java.io.IOException;

public interface CoinMarketCapPublicIntf {
	
	public StringBuffer getFirstHundredMarket() throws IOException;
	
}
