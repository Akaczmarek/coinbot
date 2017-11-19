package fr.afjg.coinbot.dao.intf.database;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.StockPricesBTC;

public interface StockPricesDao {
	public Set<StockPricesBTC> getDataByAmount(Integer Amount);

}
