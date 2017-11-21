package fr.afjg.coinbot.dao.impl.database;

import java.util.Set;

import fr.afjg.coinbot.dao.intf.database.CurrencyDaoIntf;
import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public class CurrencyDaoImpl implements CurrencyDaoIntf{

	@Override
	public Set<CurrencyRate> getCurrencyRateByAmount(Integer Amount, Currency currency){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CurrencyTrend> getAllCurrenciesTrends() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
