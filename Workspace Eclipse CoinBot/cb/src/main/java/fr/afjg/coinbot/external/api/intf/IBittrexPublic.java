package fr.afjg.coinbot.external.api.intf;

public interface IBittrexPublic {
	
	public StringBuffer getMarkets();
	
	public StringBuffer getMarketSummary(String market);
	
}
