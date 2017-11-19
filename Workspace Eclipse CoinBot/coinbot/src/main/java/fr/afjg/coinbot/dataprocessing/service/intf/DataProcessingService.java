package fr.afjg.coinbot.dataprocessing.service.intf;

import java.util.Set;

import fr.afjg.coinbot.database.pojo.StockPrices;

public interface DataProcessingService {

	public Set<StockPrices> getDataByAmount(Integer Amount);
	
}

