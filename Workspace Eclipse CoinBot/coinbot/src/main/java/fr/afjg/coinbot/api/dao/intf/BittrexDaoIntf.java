package fr.afjg.coinbot.api.dao.intf;

import java.io.IOException;

public interface BittrexDaoIntf {
	
	public StringBuffer getMarket() throws IOException;
	
}