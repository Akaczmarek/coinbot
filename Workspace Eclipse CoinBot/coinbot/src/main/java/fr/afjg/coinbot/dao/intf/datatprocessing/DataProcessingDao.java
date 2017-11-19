package fr.afjg.coinbot.dao.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.CurrencyRate;

public interface DataProcessingDao {
	public Set<CurrencyRate> getDataByAmount(Integer Amount);
}
