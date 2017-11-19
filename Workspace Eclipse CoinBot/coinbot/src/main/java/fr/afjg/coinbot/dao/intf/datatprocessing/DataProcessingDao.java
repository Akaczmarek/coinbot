package fr.afjg.coinbot.dao.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.CurrencyRateBTC;

public interface DataProcessingDao {
	public Set<CurrencyRateBTC> getDataByAmount(Integer Amount);
}
