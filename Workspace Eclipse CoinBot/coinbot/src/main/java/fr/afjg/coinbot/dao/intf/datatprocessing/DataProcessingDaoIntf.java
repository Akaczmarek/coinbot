package fr.afjg.coinbot.dao.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public interface DataProcessingDaoIntf {
	public Set<CurrencyRate> getCurrencyRateByAmount(Integer Amount, Currency currency);
	public Set<CurrencyTrend> getAllCurrenciesTrends();
}
