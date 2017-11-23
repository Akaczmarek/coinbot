package fr.afjg.coinbot.service.impl.datatprocessing;

import java.sql.Timestamp;
import java.util.List;

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
	public List<CurrencyRate> getCurrencyRateByDurationAndCurrency(Timestamp timestamp, Currency currency) {
		// TODO Auto-generated method stub
		return DataProcessing.getCurrencyRateByDurationAndCurrency(timestamp, currency);
	}

	@Override
	public List<CurrencyTrend> getAllLastCurrenciesTrends() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
