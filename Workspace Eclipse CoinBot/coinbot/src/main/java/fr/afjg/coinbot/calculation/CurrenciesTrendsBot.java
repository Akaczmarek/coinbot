package fr.afjg.coinbot.calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.afjg.coinbot.entity.CurrencyTrend;
import fr.afjg.coinbot.service.impl.datatprocessing.DataProcessingServiceImpl;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

/*
 * liste de tendances de devises accessible de partout
 */
public class CurrenciesTrendsBot implements Runnable{

	private DataProcessingServiceIntf DPService;
	private volatile List<CurrencyTrend> currenciesTrends;
	private volatile List<CurrencyTrend> currenciesTrendsOrderByTimesRecord;
	private volatile List<CurrencyTrend> currenciesTrendsOrderByNoteToBuy;
	private volatile List<CurrencyTrend> currenciesTrendsOrderByNoteToSell;

	/*
	 * private constructor
	 */
	private CurrenciesTrendsBot() {

		DPService = new DataProcessingServiceImpl();
		currenciesTrends = new ArrayList<>();
		currenciesTrendsOrderByTimesRecord = new ArrayList<>();
		currenciesTrendsOrderByNoteToBuy= new ArrayList<>();
		currenciesTrendsOrderByNoteToSell= new ArrayList<>();
	}

	/** Holder */
	private static class SingletonHolder {
		/*
		 * Instance unique non préinitialisée
		 */
		private final static CurrenciesTrendsBot instance = new CurrenciesTrendsBot();
	}

	/*
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static CurrenciesTrendsBot getInstance() {
		return SingletonHolder.instance;
	}

	// getters & Setters----------------------------------------------

	public synchronized List<CurrencyTrend> getCurrenciesTrendsOrderByTimesRecord() {
		return currenciesTrendsOrderByTimesRecord;
	}

	public synchronized void setCurrenciesTrendsOrderByTimesRecord(
			List<CurrencyTrend> currenciesTrendsOrderByTimesRecord) {
		this.currenciesTrendsOrderByTimesRecord = currenciesTrendsOrderByTimesRecord;
	}

	public synchronized List<CurrencyTrend> getCurrenciesTrendsOrderByNoteToBuy() {
		return currenciesTrendsOrderByNoteToBuy;
	}

	public synchronized void setCurrenciesTrendsOrderByNoteToBuy(List<CurrencyTrend> currenciesTrendsOrderByNoteToBuy) {
		this.currenciesTrendsOrderByNoteToBuy = currenciesTrendsOrderByNoteToBuy;
	}

	public List<CurrencyTrend> getCurrenciesTrends() {
		return currenciesTrends;
	}

	public void setCurrenciesTrends(List<CurrencyTrend> currenciesTrends) {
		this.currenciesTrends = currenciesTrends;
	}

	public synchronized List<CurrencyTrend> getCurrenciesTrendsOrderByNoteToSell() {
		return currenciesTrendsOrderByNoteToSell;
	}

	public synchronized void setCurrenciesTrendsOrderByNoteToSell(
			List<CurrencyTrend> currenciesTrendsOrderByNoteToSell) {
		this.currenciesTrendsOrderByNoteToSell = currenciesTrendsOrderByNoteToSell;
	}

	// methods ----------------------------------------------------------

	private void updateCurrenciesTrendsOrderByNoteToBuy() {
		List<CurrencyTrend> cts = new ArrayList<>(this.getCurrenciesTrends());
		Collections.sort(cts, CurrencyTrend.CTNoteToBuyComparator);
		this.setCurrenciesTrendsOrderByNoteToBuy(cts);
	}
	
	private void updateCurrenciesTrendsOrderByNoteToSell() {
		List<CurrencyTrend> cts = new ArrayList<>(this.getCurrenciesTrends());
		Collections.sort(cts, CurrencyTrend.CTNoteToSellComparator);
		this.setCurrenciesTrendsOrderByNoteToSell(cts);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		/*
		 * ordre d'éxécution
		 * 1) on charge une liste de currency trend
		 * 2) on regarde quelle currency doit être mise à jour
		 * 3) on lance les mises à jour les unes derrière les autres
		 * 4) on met à jour les listes ordonnées
		 * 
		 */
		
		while(true) {
			
			
			
			
			
			
			
			
			//mise à jour des listes ordonnées
			this.updateCurrenciesTrendsOrderByNoteToBuy();
			this.updateCurrenciesTrendsOrderByNoteToSell();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
