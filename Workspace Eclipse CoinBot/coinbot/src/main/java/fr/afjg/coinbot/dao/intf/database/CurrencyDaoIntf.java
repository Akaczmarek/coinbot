package fr.afjg.coinbot.dao.intf.database;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public interface CurrencyDaoIntf {
	public Set<CurrencyRate> getCurrencyRateByAmount(Integer Amount, Currency currency);
	public Set<CurrencyTrend> getAllLastCurrenciesTrends();

}
