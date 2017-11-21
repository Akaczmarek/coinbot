package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.Set;

import fr.afjg.coinbot.service.impl.datatprocessing.DataProcessingServiceImpl;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

public class CurrenciesTrends implements Runnable {

	private DataProcessingServiceIntf DPService;
	private Set<CurrencyTrend> currenciesTrends;
	private final int NBTHREADSTREND;

	
	{
		NBTHREADSTREND=5;
	}
	/*
	 * private constructor
	 */
	private CurrenciesTrends() {

		DPService = new DataProcessingServiceImpl();

	}

	/** Holder */
	private static class SingletonHolder {
		/*
		 * Instance unique non préinitialisée
		 */
		private final static CurrenciesTrends instance = new CurrenciesTrends();
	}

	/*
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static CurrenciesTrends getInstance() {
		return SingletonHolder.instance;
	}

	/*
	 * Getters &
	 * Setters----------------------------------------------------------------------

	 */

	public DataProcessingServiceIntf getDPService() {
		return DPService;
	}

	public void setDPService(DataProcessingServiceIntf dPService) {
		DPService = dPService;
	}

	public Set<CurrencyTrend> getCurrenciesTrends() {
		return currenciesTrends;
	}

	public void setCurrenciesTrends(Set<CurrencyTrend> currenciesTrends) {
		this.currenciesTrends = currenciesTrends;
	}
	
	public int getNBTHREADSTREND() {
		return NBTHREADSTREND;
	}

	/*
	 * Methods----------------------------------------------------------------------
	 * 
	 * 
	 */



	@Override
	public void run() {
		// TODO Auto-generated method stub

		// opération de lancement des threads de calcul des tendances
		// CurrencyTrend

		// exemple d'envoi
		
		
		//stage 1 : recovers data and loading list currencies
		this.setCurrenciesTrends(DPService.getAllCurrenciesTrends());
		
		
		
		
		
		
		int nbThreadsTrend=0;
		while (true) {
			
			
			
			
			CurrencyTrend ct = new CurrencyTrend();
			
			
			
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
		

	}

}
