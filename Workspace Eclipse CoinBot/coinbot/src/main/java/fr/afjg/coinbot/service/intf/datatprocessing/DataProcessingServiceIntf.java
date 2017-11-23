package fr.afjg.coinbot.service.intf.datatprocessing;

import java.util.List;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public interface DataProcessingServiceIntf {

	public List<CurrencyRate> getCurrencyRateByAmount(Integer Amount, Currency currency);
	public List<CurrencyTrend> getAllLastCurrenciesTrends();
	
}

