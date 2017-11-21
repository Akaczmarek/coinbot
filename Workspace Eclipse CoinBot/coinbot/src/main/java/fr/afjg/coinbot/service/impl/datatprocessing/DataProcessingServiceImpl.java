package fr.afjg.coinbot.service.impl.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.dao.impl.datatprocessing.DataProcessingDaoImpl;
import fr.afjg.coinbot.dao.intf.datatprocessing.DataProcessingDaoIntf;
import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

public class DataProcessingServiceImpl implements DataProcessingServiceIntf{
	
	DataProcessingDaoIntf DataProcessing;
	
	public DataProcessingServiceImpl () {
		DataProcessing = new DataProcessingDaoImpl();
	}

	@Override
	public Set<CurrencyRate> getCurrencyRateByAmount(Integer Amount, Currency currency) {
		// TODO Auto-generated method stub
		return DataProcessing.getCurrencyRateByAmount(Amount, currency);
	}

	@Override
	public Set<CurrencyTrend> getAllCurrenciesTrends() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
