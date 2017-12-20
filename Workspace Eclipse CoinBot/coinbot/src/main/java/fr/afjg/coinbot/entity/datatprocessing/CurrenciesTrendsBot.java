package fr.afjg.coinbot.entity.datatprocessing;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import fr.afjg.coinbot.entity.CurrencyRate;
import fr.afjg.coinbot.service.impl.datatprocessing.DataProcessingServiceImpl;
import fr.afjg.coinbot.service.intf.datatprocessing.DataProcessingServiceIntf;

public class CurrenciesTrendsBot implements Runnable {

	private DataProcessingServiceIntf DPService;
	private volatile List<CurrencyTrend> currenciesTrends;
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

	public synchronized List<CurrencyTrend> getAllCurrenciesTrendsInOrderToBuy() {
		if (this.getCurrenciesTrends() != null) {
			List<CurrencyTrend> listInOrderToBuy = new Vector<CurrencyTrend>(this.getCurrenciesTrends());
			Collections.sort(listInOrderToBuy, CurrencyTrend.CTNoteToBuyComparator);
			return listInOrderToBuy;
		} else {
			List<CurrencyTrend> listInOrderToBuy = new Vector<CurrencyTrend>();
			return listInOrderToBuy;
		}

	}

	public synchronized List<CurrencyTrend> getAllCurrenciesTrendsInOrderToSell() {
		List<CurrencyTrend> listInOrderToSell = new Vector<CurrencyTrend>(this.getCurrenciesTrends());
		Collections.sort(listInOrderToSell, CurrencyTrend.CTNoteToSellComparator);
		return listInOrderToSell;
	}

	public synchronized List<CurrencyTrend> getXFirstCurrenciesTrendsInOrderToBuy(int x) {
		List<CurrencyTrend> listInOrderToBuy = new Vector<CurrencyTrend>(this.getCurrenciesTrends());
		Collections.sort(listInOrderToBuy, CurrencyTrend.CTNoteToBuyComparator);
		listInOrderToBuy = listInOrderToBuy.subList(0, (x - 1));
		return listInOrderToBuy;
	}

	public synchronized List<CurrencyTrend> getXFirstCurrenciesTrendsInOrderToSell(int x) {
		List<CurrencyTrend> listInOrderToSell = new Vector<CurrencyTrend>(this.getCurrenciesTrends());
		Collections.sort(listInOrderToSell, CurrencyTrend.CTNoteToSellComparator);
		listInOrderToSell = listInOrderToSell.subList(0, (x - 1));
		return listInOrderToSell;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// Stage 0 : variables initialization
		int i = 0;
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
				cts.get(0).setTimeRecord(new Timestamp(System.currentTimeMillis()));

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
				// create new trend
				if (CurrencyBeTreated.getCurrencyRates() == null) {
					crs = DPService.getCurrencyRateByDurationAndCurrency(tst0, tst1, CurrencyBeTreated);
					Collections.sort(crs, CurrencyRate.CRTimestampComparator);

					ct = new CurrencyTrend(crs, trs);

					ct.setId(CurrencyBeTreated.getId());
					ct.setName(CurrencyBeTreated.getName());

					this.getCurrenciesTrends().remove(0);
					this.getCurrenciesTrends().add(ct);

				}

				// udapte trend
				else {
					long lastTimeRecord = (CurrencyBeTreated.getCurrencyRates()
							.get(CurrencyBeTreated.getCurrencyRates().size() - 1).getTimeRecord().getTime()) + 1;
					Timestamp tst = new Timestamp(lastTimeRecord);

					crs = CurrencyBeTreated.getCurrencyRates();
					List<CurrencyRate> listRecover = DPService.getCurrencyRateByDurationAndCurrency(tst, tst1,
							CurrencyBeTreated);

					crs.addAll(listRecover);
					Collections.sort(crs, CurrencyRate.CRTimestampComparator);

					ct = CurrencyBeTreated;
					ct.setCurrencyRates(crs);
					ct.setTrendRules(trs);

				}
				Collections.sort(crs, CurrencyRate.CRTimestampComparator);

				Thread thread = new Thread(ct);
				thread.start();

				// stage 6 : prevent new thread start
				this.setNbActifThreadsTrend(getNbActifThreadsTrend() + 1);

			}
System.out.println("calcul " + i++);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
