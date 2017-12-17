package fr.afjg.coinbot.entity.datatprocessing;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.util.DateTools;

public class CurrencyTrend extends Currency implements Runnable {

	private List<CurrencyRate> currencyRates;
	private volatile List<TrendCalculation> trendCalculs;
	private List<TrendRule> trendRules;
	private double noteCurrencyToBuy;
	private double noteCurrencyToSell;
	private Timestamp timeRecord;
	private CurrencyNotes notes;
	private volatile int countFinishedActions;

	public CurrencyTrend() {

	}

	public CurrencyTrend(List<CurrencyRate> currencyRates, List<TrendRule> trendRules) {
		this.setCurrencyRates(currencyRates);
		this.setTrendRules(trendRules);

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

	public CurrencyNotes getNotes() {
		return notes;
	}

	public void setNotes(CurrencyNotes note) {
		this.notes = note;
	}

	public double getNoteCurrencyToBuy() {
		return noteCurrencyToBuy;
	}

	public void setNoteCurrencyToBuy(double noteCurrencyToBuy) {
		this.noteCurrencyToBuy = noteCurrencyToBuy;
	}

	public double getNoteCurrencyToSell() {
		return noteCurrencyToSell;
	}

	public void setNoteCurrencyToSell(double noteCurrencyToSell) {
		this.noteCurrencyToSell = noteCurrencyToSell;
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

		// stage 0 : variables initialization
		
		initialization();
		List<TrendRule> trList = this.getTrendRules(); // we get the trend rules in list
		Collections.sort(trList, TrendRule.TRDurationComparator); // we sort the list, according to the duration of the
																	// trend
		int numberOperation = 0;


		// Stage 1 : buckle to make all the trends
		for (TrendRule trendRule : trList) {

			// stage 2 : definition of size the table
			List<CurrencyRate> transmittedListToCalcul = new ArrayList<>(this.getCurrencyRates());

			Timestamp ts1 = DateTools.dateConvertTimestamp(DateTools.todayDate()); // currently timestamp

			long durationInMillis = trendRule.convertDurationInHours(trendRule) * 3600000;
			Timestamp ts2 = new Timestamp(durationInMillis); // duration trend rule in timestamp

			// If timestamp is too older, remove the lastest data
			Predicate<CurrencyRate> crPredicate = p -> p.getTimeRecord().getTime() < (ts1.getTime() - ts2.getTime());

			transmittedListToCalcul.removeIf(crPredicate);

			// stage 3 : transmit the list for calculation
			if (transmittedListToCalcul.size() > 2) {

				TrendCalculation tC = new TrendCalculation(transmittedListToCalcul, this, trendRule);
				Thread t = new Thread(tC);
				t.start();

				numberOperation++;
			}
		}

		// Stage 4 : control as every operation of trend is finished and begin notations
		// operations

		while (true) {
			if (this.getCountFinishedActions() == numberOperation) {
				this.setCountFinishedActions(0);
				numberOperation = 0;
				break;
			}
		}

		// Stage 5: transmit the list of trend for the notation

		this.setNotes(new CurrencyNotes(this));
		numberOperation = 1;

		while (true) {
			if (this.getCountFinishedActions() == numberOperation) {
				this.setCountFinishedActions(0);
				numberOperation = 0;
				break;
			}
		}

		// stage 6 : complete data

		// stage 6.1 : calculation global Note to buy and sell
		this.setNoteCurrencyToBuy(calculNoteCurrencyToBuy());
		this.setNoteCurrencyToSell(calculNoteCurrencyToSell());

		// Stage 6.2
		this.setTimeRecord(DateTools.dateConvertTimestamp(DateTools.todayDate()));

		// Final stage : prevent end thread
		CurrenciesTrendsBot cTB = CurrenciesTrendsBot.getInstance();
		cTB.setNbActifThreadsTrend(cTB.getNbActifThreadsTrend() - 1);

	}

	public double calculNoteCurrencyToBuy() {
		double note = 0.0;
		List<CurrencyNote> currencyNotesToBuy = this.getNotes().getCurrencyNotesToBuy();
		Iterator<CurrencyNote> ite = currencyNotesToBuy.iterator();

		CurrencyNote cn;
		while (ite.hasNext()) {
			cn = ite.next();
			note = note + cn.getNote();
		}

		return note;
	}

	public double calculNoteCurrencyToSell() {
		double note = 0.0;
		List<CurrencyNote> currencyNotesToSell = this.getNotes().getCurrencyNotesToSell();
		Iterator<CurrencyNote> ite = currencyNotesToSell.iterator();

		CurrencyNote cn;
		while (ite.hasNext()) {
			cn = ite.next();
			note = note + cn.getNote();
		}

		return note;
	}

	public final static Comparator<CurrencyTrend> CTNoteToBuyComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {
			// TODO Auto-generated method stub
			int noteCT1 = (int) (CT1.getNoteCurrencyToBuy() * 1000);
			int noteCT2 = (int) (CT2.getNoteCurrencyToBuy() * 1000);
			return noteCT1 - noteCT2;
		}
	};

	public final static Comparator<CurrencyTrend> CTNoteToSellComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {
			// TODO Auto-generated method stub
			int noteCT1 = (int) (CT1.getNoteCurrencyToSell() * 1000);
			int noteCT2 = (int) (CT2.getNoteCurrencyToSell() * 1000);
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

	@Override
	public int hashCode() {
		final int prime = 617;
		int result = 1;
		result = prime * result + currencyRates.get(0).getId();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyTrend other = (CurrencyTrend) obj;

		if (currencyRates.get(0).getId() != other.currencyRates.get(0).getId()) {
			return false;
		}
		return true;
	}
	
	private void initialization() {
		this.setTrendCalculs(new ArrayList<>());
	}

}
