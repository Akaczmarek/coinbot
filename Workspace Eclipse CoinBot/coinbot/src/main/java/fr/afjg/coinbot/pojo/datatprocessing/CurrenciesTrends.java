package fr.afjg.coinbot.pojo.datatprocessing;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import fr.afjg.coinbot.service.impl.datatprocessing.DataProcessingServiceImpl;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

public class CurrenciesTrends implements Runnable {

	private DataProcessingServiceIntf DPService;
	private Set<CurrencyTrend> currenciesTrends;
	private final int NBTHREADSTREND;
	private int nbActifThreadsTrend;
	private final int DATARANGEINDAY;

	{
		this.NBTHREADSTREND = 5; // parameter for optimization execution
		this.DATARANGEINDAY = 30; // parameter coverage duration for trends
		this.setNbActifThreadsTrend(0);
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
	 * 
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

	public int getNbActifThreadsTrend() {
		return nbActifThreadsTrend;
	}

	public void setNbActifThreadsTrend(int nbActifThreadsTrend) {
		this.nbActifThreadsTrend = nbActifThreadsTrend;
	}

	public int getDATARANGEINDAY() {
		return DATARANGEINDAY;
	}

	/*
	 * Methods----------------------------------------------------------------------
	 */

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// opération de lancement des threads de calcul des tendances
		// CurrencyTrend

		// exemple d'envoi
		
		
		//stage 1 : recovers data and loading list currencies
		this.setCurrenciesTrends(DPService.getAllLastCurrenciesTrends());
		
		
		
		
		while (true) {
			
			//Stage 2 : transmit trend calculation order at object CurrencyTrend
			
			while (this.getNbActifThreadsTrend() < this.getNBTHREADSTREND()) {
				
				
				
				// Stage 3 : find the oldest trend
				Collections.sort
				
				
				// stage 4 : transit information to currencyTrend
				Iterator<CurrencyTrend> ite = this.getCurrenciesTrends().iterator();
				
				Duration duration = Duration.ofDays(this.getDATARANGEINDAY());
				Timestamp tst = new Timestamp(System.currentTimeMillis()- (duration.getSeconds()*1000));
				
				

				
			}
			
			
			CurrencyTrend ct = new CurrencyTrend();
			
			
			
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
		

	}

	public static void main(String[] args) {

		TreeSet<String> t = new TreeSet<String>();
		t.add("test 15");
		t.add("dfd 2");
		t.add("ersfd 20");
		t.add("asdt 10");

		Iterator<String> it = t.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("-----------------------------------------");
		

		Set<String> set = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		
		set.add("test 15");
		set.add("dfd 2");
		set.add("ersfd 20");
		set.add("asdt 10");
		
		Iterator<String> it1 = set.iterator();

		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		

	}

}
