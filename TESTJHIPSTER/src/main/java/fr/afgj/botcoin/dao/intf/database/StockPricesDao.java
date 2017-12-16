package fr.afjg.coinbot.dao.intf.database;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.CurrencyRate;

public interface StockPricesDao {
	public Set<CurrencyRate> getDataByAmount(Integer Amount);

}
