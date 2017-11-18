package fr.afjg.coinbot.intf;

import java.io.IOException;

public interface BittrexIntf {
	
	public StringBuffer getMarket() throws IOException;
	
}
