package fr.afjg.coinbot.intf.api;

import java.io.IOException;

public interface BittrexIntf {
	
	public StringBuffer getMarket() throws IOException;
	
}
