package fr.afgj.coinbot.external.api.miscellaneous.intf;

import java.util.Set;

import fr.afgj.coinbot.external.api.entities.coinmarketcap.Market;

public interface IGetFirstHundredMarket {
	
	public Set<Market> getMarket();

}
