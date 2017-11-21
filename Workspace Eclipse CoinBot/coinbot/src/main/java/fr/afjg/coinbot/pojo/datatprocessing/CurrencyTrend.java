package fr.afjg.coinbot.pojo.datatprocessing;

import java.sql.Timestamp;
import java.util.Set;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;

public class CurrencyTrend extends Currency implements Runnable{
	
	private Set<CurrencyRate> currencyRates;
	private double leadingDirect4hAverageBid;
	private double ordOrigin4hAverageBid;
	private double leadingDirect4hCeilingBid;
	private double ordOrigin4hCeilingBid;
	private double leadingDirect4hSuppBid;
	private double ordOrigin4hSuppBid;
	private Timestamp timeRecord;
	private CurrencyNote note;
	
	
	public CurrencyTrend () {
		
	}
	
	public CurrencyTrend (Set<CurrencyRate> currencyRates) {
		
	}
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// procedure de calcul des tendances
		
		// et incrémenter la liste currenciesTrends avec les nouvelles valeurs
		
	}
	
	

	
	

}
