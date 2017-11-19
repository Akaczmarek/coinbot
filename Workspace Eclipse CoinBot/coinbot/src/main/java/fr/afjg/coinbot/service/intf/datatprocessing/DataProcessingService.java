package fr.afjg.coinbot.service.intf.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.pojo.database.CurrencyRateBTC;

public interface DataProcessingService {

	public Set<CurrencyRateBTC> getDataByAmount(Integer Amount);
	
}

