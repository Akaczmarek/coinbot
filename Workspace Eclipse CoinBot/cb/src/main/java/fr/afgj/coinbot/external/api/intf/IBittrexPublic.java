package fr.afgj.coinbot.external.api.intf;

public interface IBittrexPublic {
	
	public StringBuffer getMarkets();
	
	public StringBuffer getMarketSummary(String market);
	
	public StringBuffer setOrderToBuy(String apiKey, String market, double quantity, double rate);
	
}
