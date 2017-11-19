package fr.afjg.coinbot.service.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.StockPricesBTC;

public interface DataProcessingService {

	public Set<StockPricesBTC> getDataByAmount(Integer Amount);
	
}

