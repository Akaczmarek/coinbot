package fr.afjg.coinbot.dao.intf.api;

import java.io.IOException;

public interface BittrexDaoIntf {
	
	public StringBuffer getMarket() throws IOException;
	
	public StringBuffer getMarketSummary(String market) throws IOException;
	
}