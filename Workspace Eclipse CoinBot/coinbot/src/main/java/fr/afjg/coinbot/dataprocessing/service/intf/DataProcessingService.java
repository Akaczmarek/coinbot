package fr.afjg.coinbot.dataprocessing.service.intf;

import java.util.Set;

import fr.afjg.coinbot.database.pojo.StockPricesBTC;

public interface DataProcessingService {

	public Set<StockPricesBTC> getDataByAmount(Integer Amount);
	
}

