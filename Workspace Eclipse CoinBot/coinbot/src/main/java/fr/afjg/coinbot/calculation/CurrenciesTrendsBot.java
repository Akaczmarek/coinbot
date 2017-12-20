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
	private List<CurrencyTrend> currenciesTrends;
	private List<CurrencyTrend> currenciesTrendsOrderByTimesRecord;
	private List<CurrencyTrend> currenciesTrendsOrderByNoteToBuy;
	private List<CurrencyTrend> currenciesTrendsOrderByNoteToSell;

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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			this.updateCurrenciesTrendsOrderByNoteToBuy();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
