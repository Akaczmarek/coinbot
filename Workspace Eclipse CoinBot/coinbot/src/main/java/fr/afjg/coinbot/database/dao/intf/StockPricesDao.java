package fr.afjg.coinbot.database.dao.intf;

import java.util.Set;

import fr.afjg.coinbot.database.pojo.StockPricesBTC;

public interface StockPricesDao {
	public Set<StockPricesBTC> getDataByAmount(Integer Amount);

}
