package fr.afjg.coinbot.service.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.CurrencyRate;

public interface DataProcessingService {

	public Set<CurrencyRate> getDataByAmount(Integer Amount);
	
}

