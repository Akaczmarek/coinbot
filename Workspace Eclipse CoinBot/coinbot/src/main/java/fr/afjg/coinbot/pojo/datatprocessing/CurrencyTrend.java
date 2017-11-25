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
	private List<TrendCalculation> trendCalculs;
	private List<TrendRule> trendRules;
	private double noteCurrency;
	private Timestamp timeRecord;
	private CurrencyNote note;

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

	public void setTrendCalculs(List<TrendCalculation> trendCalculs) {
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

	// methods------------------------------------------------------------------

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// procedure de calcul des tendances

		// et incrémenter la liste currenciesTrends avec les nouvelles valeurs

		// stage 0 : variables initialization

		List<TrendRule> trList = this.getTrendRules();
		Collections.sort(trList, TrendRule.TRDurationComparator);

		// Stage 1 : boucler pour faire toutes les tendances

		for (TrendRule trendRule : trList) {

			List<CurrencyRate> transmittedListToCalcul = new ArrayList<>(this.getCurrencyRates());

			/*
			 * Predicate<T> transmittedList.removeIf(filter)
			 */	
			Timestamp ts1 = DateTools.dateConvertTimestamp(DateTools.todayDate());		// currently timestamp
			Timestamp ts2 = new Timestamp(trendRule.convertDurationInHours(trendRule));	// duration rule in timestamp
			
			
			Predicate<CurrencyRate> crPredicate = p -> p.getTimeRecord().getTime()<(ts1.getTime()-ts2.getTime()); // if timestamp is too older, remove it
			transmittedListToCalcul.removeIf(crPredicate);

		}

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

	public static void main(String[] args) {



	}

}
