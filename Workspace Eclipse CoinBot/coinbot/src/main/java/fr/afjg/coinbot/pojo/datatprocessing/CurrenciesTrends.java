package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.List;

import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

public class CurrenciesTrends implements Runnable{
	
	private DataProcessingServiceIntf DPService;
	private List<CurrencyTrend> currenciesTrends;
	
	/*
	 * private constructor
	 */
	private CurrenciesTrends() {

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
	 * Getters & Setters-------------------------------------------------------------------------------
	 */

	public DataProcessingServiceIntf getDPService() {
		return DPService;
	}

	public void setDPService(DataProcessingServiceIntf dPService) {
		DPService = dPService;
	}

	public List<CurrencyTrend> getCurrenciesTrends() {
		return currenciesTrends;
	}

	public void setCurrenciesTrends(List<CurrencyTrend> currenciesTrends) {
		this.currenciesTrends = currenciesTrends;
	}
	
	
	/*
	 * Methods-------------------------------------------------------------------------------
	 * 
	 */
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//opération de lancement des threads de calcul des tendances
		//CurrencyTrend
		
		// exemple d'envoi
		CurrencyTrend ct = new CurrencyTrend();
		
		
		
	}

	
	
	
}
