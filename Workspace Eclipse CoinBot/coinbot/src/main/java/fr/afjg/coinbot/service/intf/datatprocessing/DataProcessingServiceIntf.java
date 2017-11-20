package fr.afjg.coinbot.service.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.CurrencyRate;

public interface DataProcessingServiceIntf {

	public Set<CurrencyRate> getDataByAmount(Integer Amount);
	
}

