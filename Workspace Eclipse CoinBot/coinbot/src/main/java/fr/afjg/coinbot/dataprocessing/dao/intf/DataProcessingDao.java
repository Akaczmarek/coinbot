package fr.afjg.coinbot.dataprocessing.dao.intf;

import java.util.Set;

import fr.afjg.coinbot.database.pojo.StockPrices;

public interface DataProcessingDao {
	public Set<StockPrices> getDataByAmount(Integer Amount);
}
