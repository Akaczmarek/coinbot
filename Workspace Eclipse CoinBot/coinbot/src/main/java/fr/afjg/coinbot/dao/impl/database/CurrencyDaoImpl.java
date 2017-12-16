package fr.afjg.coinbot.dao.impl.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.afjg.coinbot.dao.intf.database.CurrencyDaoIntf;
import fr.afjg.coinbot.entity.datatprocessing.CurrencyTrend;
import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.trend.OuvertureFichierTest;

public class CurrencyDaoImpl implements CurrencyDaoIntf{

	@Override
	public List<CurrencyRate> getCurrencyRateByDurationAndCurrency(Timestamp tst0,Timestamp tst1, Currency currency){
		// TODO Auto-generated method stub
		
		
		// test sur courbe***************************************************************
		List<CurrencyRate> list = new ArrayList<>();
		BufferedReader buff = new OuvertureFichierTest().contenuFichiercsvTest();
		String ligne;
		String[] coordonnees;
		CurrencyRate cr;
		int i = 0;
		
		try {
			while ((ligne=buff.readLine())!=null){
				
				System.out.println("chargement : " + ++i);
				cr = new CurrencyRate();

				coordonnees = ligne.split(";");
				
				
				cr.setTimeRecord(new Timestamp((long)(Long.parseLong(coordonnees[0]))));
				cr.setBidBTC((double)(Integer.parseInt(coordonnees[1])));
				cr.setAskBTC((double)(Integer.parseInt(coordonnees[2])));
				
				list.add(cr);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// test sur courbe***************************************************************
		
		
		
		
		
		
		
		
		
		
		
		
		
		// for start test avec beaucoup de nombre***************************************************
//		List<CurrencyRate> list = new ArrayList<>();
//
//		long currentlyTime = System.currentTimeMillis();
//		long fixedTime = 1508112017000L; // date : 16/10/2017
//		
//		long durationbetweenTimes = currentlyTime - fixedTime;
//		
//		long nbPoints = durationbetweenTimes/60000L;
//		
//		for (int i=0; i<(int)nbPoints; i++) {
//			CurrencyRate cr =  new CurrencyRate();
//			cr.setTimeRecord(new Timestamp(1508112017000L + (i*60000L)));
//			cr.setBidBTC(i);
//			cr.setAskBTC(i+30);
//			list.add(cr);
//			if (i%1000==0) {
//			System.out.println(i + "...  " + cr.getTimeRecord());
//			}
//		}
//		System.out.println("currency rate envoyé -------------------------------------------");
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
