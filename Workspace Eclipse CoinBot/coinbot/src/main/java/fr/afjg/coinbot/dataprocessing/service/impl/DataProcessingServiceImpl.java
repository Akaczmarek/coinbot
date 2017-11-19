package fr.afjg.coinbot.dataprocessing.service.impl;

import java.util.Set;

import fr.afjg.coinbot.database.pojo.StockPrices;
import fr.afjg.coinbot.dataprocessing.dao.impl.DataProcessingDaoImpl;
import fr.afjg.coinbot.dataprocessing.dao.intf.DataProcessingDao;
import fr.afjg.coinbot.dataprocessing.service.intf.DataProcessingService;

public class DataProcessingServiceImpl implements DataProcessingService{
	
	DataProcessingDao DataProcessing;
	
	public DataProcessingServiceImpl () {
		DataProcessing = new DataProcessingDaoImpl();
	}

	@Override
	public Set<StockPrices> getDataByAmount(Integer Amount) {
		// TODO Auto-generated method stub
		return DataProcessing.getDataByAmount(Amount);
	}

	
	
	
	
}
