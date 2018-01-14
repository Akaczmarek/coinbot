package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.rule.impl.TrendRule;
import fr.afgj.coinbot.rule.impl.TrendRulesBot;

/*
 * liste de tendances de devises accessible de partout
 */
public class CurrenciesTrendsBot implements Runnable {
	private Logger log = Logger.getLogger(this.getClass());

	private volatile List<CurrencyTrend> currenciesTrends;
	private volatile List<CurrencyTrend> currenciesTrendsOrderByTimesRecord;
	private volatile List<CurrencyTrend> currenciesTrendsOrderByNoteToBuy;
	private volatile List<CurrencyTrend> currenciesTrendsOrderByNoteToSell;
	private TrendRule trendRule;

	{
		this.setTrendRule(new TrendRulesBot());
		((TrendRulesBot) this.getTrendRule()).loadTrendRulesBotEnum(); // loading trend rules
		log.info("règles tendances chargées");
	}

	/*
	 * private constructor
	 */
	private CurrenciesTrendsBot() {

		// DPService = new DataProcessingServiceImpl();
		currenciesTrends = new ArrayList<>();
		currenciesTrendsOrderByTimesRecord = new ArrayList<>();
		currenciesTrendsOrderByNoteToBuy = new ArrayList<>();
		currenciesTrendsOrderByNoteToSell = new ArrayList<>();
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

	public synchronized List<CurrencyTrend> getCurrenciesTrends() {
		return currenciesTrends;
	}

	public synchronized void setCurrenciesTrends(List<CurrencyTrend> currenciesTrends) {
		this.currenciesTrends = currenciesTrends;
	}

	public synchronized List<CurrencyTrend> getCurrenciesTrendsOrderByNoteToSell() {
		return currenciesTrendsOrderByNoteToSell;
	}

	public synchronized void setCurrenciesTrendsOrderByNoteToSell(
			List<CurrencyTrend> currenciesTrendsOrderByNoteToSell) {
		this.currenciesTrendsOrderByNoteToSell = currenciesTrendsOrderByNoteToSell;
	}

	public TrendRule getTrendRule() {
		return trendRule;
	}

	public void setTrendRule(TrendRule trendRule) {
		this.trendRule = trendRule;
	}

	// methods ----------------------------------------------------------

	public void updateCurrenciesTrendsOrderByNoteToBuy() {
		List<CurrencyTrend> cts = new ArrayList<>(this.getCurrenciesTrends());

		if (cts.size() >= 2) {
			Collections.sort(cts, CurrencyTrend.CTNoteToBuyComparator);
		}

		this.setCurrenciesTrendsOrderByNoteToBuy(cts);
		log.info("résultat des ordres d'achat ordonné------------------------- ");
		for (int i =0; i< 2; i++) {
			log.info("tri cr : " + (i+1) + " --- "+ cts.get(i).getCurrency().getName() + " --- note to buy" + cts.get(i).getNotetobuy() );
		}
	}

	private void updateCurrenciesTrendsOrderByNoteToSell() {
		List<CurrencyTrend> cts = new ArrayList<>(this.getCurrenciesTrends());

		if (cts.size() > 2) {
			Collections.sort(cts, CurrencyTrend.CTNoteToSellComparator);
		}

		this.setCurrenciesTrendsOrderByNoteToSell(cts);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info("Service currencies TrendsBots démarré");
		/*
		 * ordre d'éxécution 1) on charge une liste de currency trend // se charge avec
		 * josé 2) on regarde quelle currency doit être mise à jour 3) on lance les
		 * mises à jour les unes derrière les autres 4) on met à jour les listes
		 * ordonnées
		 * 
		 */
		// boucle principale, boucle sur toutes les actions ci dessus
		int j = 0;
		while (true) {

			// parcourt de la liste de tendances et mise à jour
			int i = 0;
			for (CurrencyTrend ct : this.getCurrenciesTrends()) {

				// Stage 0 : Launch update
				ct.setUpdateFinish(false);
				ct.update(this.getTrendRule());

				// Stage 1 : wait result UPDATE

				boolean checkFinish = this.waitResultUpdateCurrencyTrend(ct);

				// stage 2 : treatment if update finished
				if (checkFinish) {
					System.out.println("calcul de 1 tendance fini : " + j + "-" + i);
				} else {
					log.warn("currency trend : " + ct.getCurrency().getName() + " n'a pas été mise à jour");
				}
				i++;
			}
			
			// updating ordered lists
			this.updateCurrenciesTrendsOrderByNoteToBuy();
			this.updateCurrenciesTrendsOrderByNoteToSell();

			// System.out.println("**************************************");
			// for (CurrencyTrend ct : this.getCurrenciesTrendsOrderByNoteToBuy()) {
			// System.out.println(ct.getCurrency().getName() + ", note" +
			// ct.getNotetobuy());
			// }

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			j++;
		}
	}

	private boolean waitResultUpdateCurrencyTrend(CurrencyTrend ct) {
		// TODO Auto-generated method stub

		int i = 0;

		while (true) {
			if (ct.isUpdateFinish()) {
				return true;
			}

			if (i > 50) {
				// time is exceeded
				return false;
			}

			i++;

			try {
				Thread.sleep(22);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}