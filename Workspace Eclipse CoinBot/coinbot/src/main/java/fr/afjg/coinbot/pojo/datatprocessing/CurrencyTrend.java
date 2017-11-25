package fr.afjg.coinbot.pojo.datatprocessing;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.util.DateTools;

public class CurrencyTrend extends Currency implements Runnable {

	private List<CurrencyRate> currencyRates;
	private volatile List<TrendCalculation> trendCalculs;
	private List<TrendRule> trendRules;
	private double noteCurrency;
	private Timestamp timeRecord;
	private CurrencyNote note;
	private volatile int countFinishedActions;

	public CurrencyTrend() {

	}

	public CurrencyTrend(List<CurrencyRate> currencyRates, List<TrendRule> trendRules) {
		this.setCurrencyRates(currencyRates);
		this.setTrendRules(trendRules);
		System.out.println("traitement lancé-----------------------------------");
	}

	// getters &
	// Setters------------------------------------------------------------------

	public List<CurrencyRate> getCurrencyRates() {
		return currencyRates;
	}

	public void setCurrencyRates(List<CurrencyRate> currencyRates) {
		this.currencyRates = currencyRates;
	}

	public List<TrendCalculation> getTrendCalculs() {
		return trendCalculs;
	}

	public synchronized void setTrendCalculs(List<TrendCalculation> trendCalculs) {
		this.trendCalculs = trendCalculs;
	}

	public List<TrendRule> getTrendRules() {
		return trendRules;
	}

	public void setTrendRules(List<TrendRule> trendRules) {
		this.trendRules = trendRules;
	}

	public Timestamp getTimeRecord() {
		return timeRecord;
	}

	public void setTimeRecord(Timestamp timeRecord) {
		this.timeRecord = timeRecord;
	}

	public CurrencyNote getNote() {
		return note;
	}

	public void setNote(CurrencyNote note) {
		this.note = note;
	}

	public double getNoteCurrency() {
		return noteCurrency;
	}

	public void setNoteCurrency(double noteCurrency) {
		this.noteCurrency = noteCurrency;
	}

	public int getCountFinishedActions() {
		return countFinishedActions;
	}

	public void setCountFinishedActions(int countFinishedActions) {
		this.countFinishedActions = countFinishedActions;
	}

	// methods------------------------------------------------------------------

	public synchronized void finishActionsChecked() {
		this.setCountFinishedActions(getCountFinishedActions() + 1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("calcul lancé  --------------------------------------------");
		// stage 0 : variables initialization

		List<TrendRule> trList = this.getTrendRules(); // we get the trend rules in list
		Collections.sort(trList, TrendRule.TRDurationComparator); // we sort the list, according to the duration of the
																	// trend

		// test*****************************************************************************
		System.out.println("taille tableau currencuyrate : " + this.getCurrencyRates().size()
				+ "-----------------------------------");

		int i = 0;

		// test*****************************************************************************

		// Stage 1 : buckle to make all the trends
		for (TrendRule trendRule : trList) {

			// stage 2 : definition of size the table
			List<CurrencyRate> transmittedListToCalcul = new ArrayList<>(this.getCurrencyRates());

			/*
			 * Predicate<T> transmittedList.removeIf(filter)
			 */
			Timestamp ts1 = DateTools.dateConvertTimestamp(DateTools.todayDate()); // currently timestamp
			Timestamp ts2 = new Timestamp(trendRule.convertDurationInHours(trendRule) * 3600000); // duration trend rule
																									// in timestamp

			// If timestamp is too older, remove the lastest data
			Predicate<CurrencyRate> crPredicate = p -> p.getTimeRecord().getTime() < (ts1.getTime() - ts2.getTime());

			transmittedListToCalcul.removeIf(crPredicate);
			// test*****************************************************************************
			i++;
			System.out.println("tendance " + i + " taille tableau : " + transmittedListToCalcul.size()
					+ "--------------------------------------------");
			// test*****************************************************************************

			// stage 3 : transmit the list for calculation
			TrendCalculation tC = new TrendCalculation(transmittedListToCalcul, this, trendRule);
		}

		// Stage 4 : control as every operation is finished and save currencyTrend in
		// list of currenciesTrends
		int numberOperation = trList.size();
		
		CurrenciesTrendsBot cTB = CurrenciesTrendsBot.getInstance();

		while (true) {
			if (this.getCountFinishedActions() == numberOperation) {
				cTB.getCurrenciesTrends().add(this);
				
			}
		}

		// Final stage : prevent end thread
		
		cTB.setNbActifThreadsTrend(cTB.getNbActifThreadsTrend() - 1);
		cTB.setNbActifThreadsTrend(cTB.getNbActifThreadsTrend()-1);
		
		System.out.println("fin traitement *******************************************************");
	}

	public final static Comparator<CurrencyTrend> CTNoteComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {
			// TODO Auto-generated method stub
			int noteCT1 = (int) (CT1.getNoteCurrency() * 1000);
			int noteCT2 = (int) (CT2.getNoteCurrency() * 1000);
			return noteCT1 - noteCT2;
		}
	};

	public final static Comparator<CurrencyTrend> CTTimestampComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {
			// TODO Auto-generated method stub
			long CTTimestamp1 = CT1.getTimeRecord().getTime() / 1000;
			long CTTimestamp2 = CT2.getTimeRecord().getTime() / 1000;

			int result = ((int) (CTTimestamp1 - CTTimestamp2));
			return result;
		}
	};

}
