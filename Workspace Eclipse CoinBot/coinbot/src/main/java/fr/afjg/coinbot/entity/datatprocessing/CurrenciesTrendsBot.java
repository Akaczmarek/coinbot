package fr.afjg.coinbot.entity.datatprocessing;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.service.impl.datatprocessing.DataProcessingServiceImpl;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;
import fr.afjg.coinbot.util.DateTools;

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

		for (CurrencyTrend currencyTrend : cts) {
			System.out.println("nom : " + currencyTrend.getName());
		}

		while (true) {

			// Stage 2 : transmit trend calculation order at object CurrencyTrend

			while (this.getNbActifThreadsTrend() < this.getNBTHREADSTREND()) {

				// Stage 3 : find the currency with oldest trend (this is the first element of
				// list after sort)
				Collections.sort(cts, CurrencyTrend.CTTimestampComparator);
				CurrencyTrend CurrencyBeTreated = cts.get(0);

				// stage 4 : definition timestamp for request historic rate currency

				Duration duration = Duration.ofHours(this.getDATARANGEINHOURS());
				Timestamp tst1 = new Timestamp(System.currentTimeMillis()); // recently timestamp
				Timestamp tst0 = new Timestamp(System.currentTimeMillis() - (duration.getSeconds() * 1000)); // date we
																												// go
																												// back
				// Stage 5 : transmission information for object currencyTrend and update or
				// create Object

				List<TrendRule> trs = this.getTrendRule().getTrendRules();
				List<CurrencyRate> crs = null;
				CurrencyTrend ct = null;

				if (CurrencyBeTreated.getCurrencyRates() == null) {
					crs = DPService.getCurrencyRateByDurationAndCurrency(tst0, tst1, CurrencyBeTreated);
					Collections.sort(crs, CurrencyRate.CRTimestampComparator);
					
					ct = new CurrencyTrend(crs, trs);

					ct.setId(CurrencyBeTreated.getId());
					ct.setName(CurrencyBeTreated.getName());
					
					
					System.out.println("supression de : " + this.getCurrenciesTrends().get(0).getName()
							+ " avec liste : " + CurrencyBeTreated.getCurrencyRates());
					
					
					
					this.getCurrenciesTrends().remove(0);
					this.getCurrenciesTrends().add(ct);

					System.out.println("ajout de : " + ct.getName() + " avec liste : "
							+ ((ct.getCurrencyRates() != null) ? "plein" : "vide"));
					

				} else {
					long lastTimeRecord = (CurrencyBeTreated.getCurrencyRates().get(CurrencyBeTreated.getCurrencyRates().size()-1).getTimeRecord().getTime()) + 1;
					Timestamp tst = new Timestamp(lastTimeRecord);

					crs = CurrencyBeTreated.getCurrencyRates();
					List<CurrencyRate> listRecover = DPService.getCurrencyRateByDurationAndCurrency(tst, tst1,
							CurrencyBeTreated);

					crs.addAll(listRecover);
					Collections.sort(crs, CurrencyRate.CRTimestampComparator);
					

					ct = CurrencyBeTreated;
					ct.setCurrencyRates(crs);
					ct.setTrendRules(trs);
					System.out.println("-------------------------------------------------------");
					System.out.println("mise à jour " + CurrencyBeTreated.getName());
					System.out.println("times record tendance : " + CurrencyBeTreated.getTimeRecord());
					System.out.println("durée de temps  entre temps 1 " + tst + ", et entre temps 2 : " + tst1);
					System.out.println(listRecover.size());

					System.out.println("-------------------------------------------------------");
				}
				Collections.sort(crs, CurrencyRate.CRTimestampComparator);

				Thread thread = new Thread(ct);
				thread.start();

				// stage 6 : prevent new thread start
				this.setNbActifThreadsTrend(getNbActifThreadsTrend() + 1);

			}

			System.out.println(
					"/////////////////////////////////////////////////////////////////////////////////////////");
			for (CurrencyTrend cr : this.getCurrenciesTrends()) {
				System.out.println("**************************************************************");
				System.out.println("nom : " + cr.getName());
				System.out.println(cr.getCurrencyRates());
				System.out.println("note to buy : " + cr.getNoteCurrencyToBuy());
				System.out.println("note to sell: " + cr.getNoteCurrencyToSell());
				System.out.println("**************************************************************");

			}

			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
