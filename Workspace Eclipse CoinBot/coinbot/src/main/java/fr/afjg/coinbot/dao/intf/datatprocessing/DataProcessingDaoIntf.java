package fr.afjg.coinbot.dao.intf.datatprocessing;

import java.sql.Timestamp;
import java.util.List;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public interface DataProcessingDaoIntf {
	public List<CurrencyRate> getCurrencyRateByDurationAndCurrency(Timestamp timestamp, Currency currency);
	public List<CurrencyTrend> getAllLastCurrenciesTrends();
}
