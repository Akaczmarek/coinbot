package fr.afjg.coinbot.dao.impl.datatprocessing;

import java.util.List;

import fr.afjg.coinbot.dao.intf.database.CurrencyDaoIntf;
import fr.afjg.coinbot.dao.intf.datatprocessing.DataProcessingDaoIntf;
import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public class DataProcessingDaoImpl implements DataProcessingDaoIntf{

	CurrencyDaoIntf currencyData;
	
	@Override
	public List<CurrencyRate> getCurrencyRateByAmount(Integer Amount, Currency currency) {
		// TODO Auto-generated method stub
		return currencyData.getCurrencyRateByAmount(Amount, currency);
	}

	@Override
	public List<CurrencyTrend> getAllLastCurrenciesTrends() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
