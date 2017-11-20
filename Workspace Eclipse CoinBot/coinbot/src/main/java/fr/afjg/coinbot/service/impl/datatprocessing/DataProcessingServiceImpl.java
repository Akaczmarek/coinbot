package fr.afjg.coinbot.service.impl.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.dao.impl.datatprocessing.DataProcessingDaoImpl;
import fr.afjg.coinbot.dao.intf.datatprocessing.DataProcessingDao;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

public class DataProcessingServiceImpl implements DataProcessingServiceIntf{
	
	DataProcessingDao DataProcessing;
	
	public DataProcessingServiceImpl () {
		DataProcessing = new DataProcessingDaoImpl();
	}

	@Override
	public Set<CurrencyRate> getDataByAmount(Integer Amount) {
		// TODO Auto-generated method stub
		return DataProcessing.getDataByAmount(Amount);
	}

	
	
	
	
}
