package fr.afjg.coinbot.api.intf;

import java.io.IOException;

public interface BittrexIntf {
	
	public StringBuffer getMarket() throws IOException;
	
}
