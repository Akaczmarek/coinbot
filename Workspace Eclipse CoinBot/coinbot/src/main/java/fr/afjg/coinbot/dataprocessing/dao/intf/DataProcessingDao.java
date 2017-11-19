package fr.afjg.coinbot.dataprocessing.dao.intf;

import java.util.Set;

import fr.afjg.coinbot.database.pojo.StockPricesBTC;

public interface DataProcessingDao {
	public Set<StockPricesBTC> getDataByAmount(Integer Amount);
}
