package fr.afjg.coinbot.entity.datatprocessing;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.service.impl.datatprocessing.DataProcessingServiceImpl;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

public class CurrenciesTrendsBot implements Runnable {

	private DataProcessingServiceIntf DPService;
	private List<CurrencyTrend> currenciesTrends;
	private TrendRule trendRule;
	private final int NBTHREADSTREND;
	private volatile int nbActifThreadsTrend;
	private final long DATARANGEINHOURS;

	{
		this.NBTHREADSTREND = 1; // parameter for optimization execution (allocation number threads)

		this.setTrendRule(new TrendRulesBot());
		((TrendRulesBot) this.getTrendRule()).loadTrendRulesBotEnum(); // loading trend rules

		this.DATARANGEINHOURS = this.getTrendRule().MaxTimeInHours(); // parameter coverage duration for trends in Hours

		this.setNbActifThreadsTrend(0);
	}

	/*
	 * private constructor
	 */
	private CurrenciesTrendsBot() {

		DPService = new DataProcessingServiceImpl();

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

	public List<CurrencyTrend> getCurrenciesTrends() {
		return currenciesTrends;
	}

	public void setCurrenciesTrends(List<CurrencyTrend> currenciesTrends) {
		this.currenciesTrends = currenciesTrends;
	}

	public TrendRule getTrendRule() {
		return trendRule;
	}

	public void setTrendRule(TrendRule trendRule) {
		this.trendRule = trendRule;
	}

	public int getNBTHREADSTREND() {
		return NBTHREADSTREND;
	}

	public int getNbActifThreadsTrend() {
		return nbActifThreadsTrend;
	}

	public synchronized void setNbActifThreadsTrend(int nbActifThreadsTrend) {
		this.nbActifThreadsTrend = nbActifThreadsTrend;
	}

	public long getDATARANGEINHOURS() {
		return DATARANGEINHOURS;
	}

	/*
	 * Methods----------------------------------------------------------------------
	 */

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// Stage 0 : variables initialization

		// stage 1 : recovers data and loading list currencies
		this.setCurrenciesTrends(DPService.getAllLastCurrenciesTrends()); // loading list of all currencies

		List<CurrencyTrend> cts = this.getCurrenciesTrends();


		while (true) {

			// Stage 2 : transmit trend calculation order at object CurrencyTrend

			while (this.getNbActifThreadsTrend() < this.getNBTHREADSTREND()) {

				// Stage 3 : find the currency with oldest trend (this is the first element of
				// list after sort)
				Collections.sort(cts, CurrencyTrend.CTTimestampComparator);
				Currency CurrencyBeTreated = cts.get(0);

				// stage 4 : definition timestamp for request historic rate currency

				Duration duration = Duration.ofHours(this.getDATARANGEINHOURS());
				Timestamp tst1 = new Timestamp(System.currentTimeMillis()); // recently timestamp
				Timestamp tst0 = new Timestamp(System.currentTimeMillis() - (duration.getSeconds() * 1000)); // date we
																												// go
																												// back
				// Stage 5 : transmission information for object currencyTrend and create Object
				List<CurrencyRate> crs = DPService.getCurrencyRateByDurationAndCurrency(tst0, tst1, CurrencyBeTreated);
				Collections.sort(crs, CurrencyRate.CRTimestampComparator);



				List<TrendRule> trs = this.getTrendRule().getTrendRules();

				CurrencyTrend ct = new CurrencyTrend(crs, trs);

				Thread thread = new Thread(ct);
				thread.start();

				// stage 6 : prevent new thread start
				this.setNbActifThreadsTrend(getNbActifThreadsTrend() + 1);

			}

			for (CurrencyTrend cr : this.getCurrenciesTrends()) {
				System.out.println("**************************************************************");
				System.out.println("nom : " + cr.getName());
				System.out.println("note to buy : " + cr.getNoteCurrencyToBuy());
				System.out.println("note to sell: " + cr.getNoteCurrencyToSell());
				System.out.println("**************************************************************");

			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
