package fr.afjg.coinbot.dao.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.StockPricesBTC;

public interface DataProcessingDao {
	public Set<StockPricesBTC> getDataByAmount(Integer Amount);
}
