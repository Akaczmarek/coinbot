package fr.afjg.coinbot.service.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public interface DataProcessingServiceIntf {

	public Set<CurrencyRate> getCurrencyRateByAmount(Integer Amount, Currency currency);
	public Set<CurrencyTrend> getAllLastCurrenciesTrends();
	
}

