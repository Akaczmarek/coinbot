package fr.afjg.coinbot.external.api.intf;

public interface BittrexPublicIntf {
	
	public StringBuffer getMarket();
	
	public StringBuffer getMarketSummary(String market);
	
}
