package fr.afjg.coinbot.dao.impl.database;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import fr.afjg.coinbot.dao.intf.database.CurrencyDaoIntf;
import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.pojo.datatprocessing.CurrencyTrend;

public class CurrencyDaoImpl implements CurrencyDaoIntf{

	@Override
	public List<CurrencyRate> getCurrencyRateByDurationAndCurrency(Timestamp tst0,Timestamp tst1, Currency currency){
		// TODO Auto-generated method stub
		
		// for start test***************************************************
		List<CurrencyRate> list = new ArrayList<>();

		long currentlyTime = System.currentTimeMillis();
		long fixedTime = 1508112017000L; // date : 16/10/2017
		
		long durationbetweenTimes = currentlyTime - fixedTime;
		
		long nbPoints = durationbetweenTimes/60000L;
		
		for (int i=0; i<(int)nbPoints; i++) {
			CurrencyRate cr =  new CurrencyRate();
			cr.setTimeRecord(new Timestamp(1508112017000L + (i*60000L)));
			cr.setBidBTC(i);
			cr.setAskBTC(i+30);
			list.add(cr);
			if (i%1000==0) {
			System.out.println(i + "...  " + cr.getTimeRecord());
			}
		}
		System.out.println("currency rate envoyé -------------------------------------------");
		// end test***************************************************
		
		return list;
	}

	@Override
	public List<CurrencyTrend> getAllLastCurrenciesTrends() {
		// TODO Auto-generated method stub
		
		// for start test***************************************************
		
		List<CurrencyTrend> list = new ArrayList<>();
		
		CurrencyTrend ct1 = new CurrencyTrend();
		ct1.setIdcurrency(1);
		ct1.setName("test1-bitcoin");
		ct1.setSymbol("btc");
		ct1.setTimeRecord(new Timestamp(1510685217229L));
		System.out.println(ct1.getTimeRecord());
		
		
		CurrencyTrend ct2 = new CurrencyTrend();
		ct2.setIdcurrency(2);
		ct2.setName("test2-litecoin");
		ct2.setSymbol("ltc");
		ct2.setTimeRecord(new Timestamp(1511485217229L));
		System.out.println(ct2.getTimeRecord());
		
		list.add(ct1);
		list.add(ct2);
		
		
		// end test***************************************************
		
		
		
		return list;
	}
	

}
