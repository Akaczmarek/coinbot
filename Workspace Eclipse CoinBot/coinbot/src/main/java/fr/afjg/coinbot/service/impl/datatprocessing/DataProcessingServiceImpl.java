package fr.afjg.coinbot.service.impl.datatprocessing;

import java.sql.Timestamp;
import java.util.List;

import fr.afjg.coinbot.dao.impl.database.CurrencyDaoImpl;
import fr.afjg.coinbot.dao.intf.database.CurrencyDaoIntf;
import fr.afjg.coinbot.entity.Currency;
import fr.afjg.coinbot.entity.CurrencyRate;
import fr.afjg.coinbot.entity.CurrencyTrend;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

public class DataProcessingServiceImpl implements DataProcessingServiceIntf{
	
	CurrencyDaoIntf DataProcessing;
	
	public DataProcessingServiceImpl () {
		DataProcessing = new CurrencyDaoImpl();
	}

	@Override
	public List<CurrencyRate> getCurrencyRateByDurationAndCurrency(Timestamp tst0,Timestamp tst1, Currency currency) {
		// TODO Auto-generated method stub
		return DataProcessing.getCurrencyRateByDurationAndCurrency(tst0, tst1 , currency);
	}

	@Override
	public List<CurrencyTrend> getAllLastCurrenciesTrends() {
		// TODO Auto-generated method stub

		return DataProcessing.getAllLastCurrenciesTrends();
	}

	@Override
	public List<CurrencyTrend> getAllCurrencies() {
		// TODO Auto-generated method stub
		return DataProcessing.getAllLastCurrenciesTrends();// a modifier pour récupérer toutes les currencies 
	}
	
	
	

	
	
	
	
}
