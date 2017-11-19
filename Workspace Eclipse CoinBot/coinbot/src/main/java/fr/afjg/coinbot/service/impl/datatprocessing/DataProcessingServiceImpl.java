package fr.afjg.coinbot.service.impl.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.dao.impl.datatprocessing.DataProcessingDaoImpl;
import fr.afjg.coinbot.dao.intf.datatprocessing.DataProcessingDao;
import fr.afjg.coinbot.pojo.database.CurrencyRateBTC;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingService;

public class DataProcessingServiceImpl implements DataProcessingService{
	
	DataProcessingDao DataProcessing;
	
	public DataProcessingServiceImpl () {
		DataProcessing = new DataProcessingDaoImpl();
	}

	@Override
	public Set<CurrencyRateBTC> getDataByAmount(Integer Amount) {
		// TODO Auto-generated method stub
		return DataProcessing.getDataByAmount(Amount);
	}

	
	
	
	
}
