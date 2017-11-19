package fr.afjg.coinbot.dao.intf.database;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.CurrencyRateBTC;

public interface StockPricesDao {
	public Set<CurrencyRateBTC> getDataByAmount(Integer Amount);

}
