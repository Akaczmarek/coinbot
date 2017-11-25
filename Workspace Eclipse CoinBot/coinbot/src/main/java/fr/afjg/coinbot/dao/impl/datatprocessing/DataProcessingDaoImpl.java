package fr.afjg.coinbot.dao.impl.datatprocessing;

import java.sql.Timestamp;
import java.util.List;

import fr.afjg.coinbot.dao.impl.database.CurrencyDaoImpl;
import fr.afjg.coinbot.dao.intf.database.CurrencyDaoIntf;
import fr.afjg.coinbot.dao.intf.datatprocessing.DataProcessingDaoIntf;
import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public class DataProcessingDaoImpl implements DataProcessingDaoIntf{

	CurrencyDaoIntf currencyData =  new CurrencyDaoImpl();
	
	@Override
	public List<CurrencyRate> getCurrencyRateByDurationAndCurrency(Timestamp timestamp, Currency currency) {
		// TODO Auto-generated method stub
		return currencyData.getCurrencyRateByDurationAndCurrency(timestamp, currency);
	}

	@Override
	public List<CurrencyTrend> getAllLastCurrenciesTrends() {
		// TODO Auto-generated method stub

		return currencyData.getAllLastCurrenciesTrends();
	}

	

}
