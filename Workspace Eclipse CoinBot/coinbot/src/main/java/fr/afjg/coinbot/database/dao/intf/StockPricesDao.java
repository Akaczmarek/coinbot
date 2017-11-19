package fr.afjg.coinbot.database.dao.intf;

import java.util.Set;

import fr.afjg.coinbot.database.pojo.StockPrices;

public interface StockPricesDao {
	public Set<StockPrices> getDataByAmount(Integer Amount);

}
