package fr.afjg.coinbot.dao.intf.database;

import java.sql.Timestamp;
import java.util.List;

import fr.afjg.coinbot.entity.Currency;
import fr.afjg.coinbot.entity.CurrencyRate;
import fr.afjg.coinbot.entity.datatprocessing.CurrencyTrend;

public interface CurrencyDaoIntf {
	public List<CurrencyRate> getCurrencyRateByDurationAndCurrency(Timestamp tst0,Timestamp tst1, Currency currency);
	public List<CurrencyTrend> getAllLastCurrenciesTrends();

}
