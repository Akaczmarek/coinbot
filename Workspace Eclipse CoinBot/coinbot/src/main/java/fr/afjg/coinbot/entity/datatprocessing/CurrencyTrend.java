package fr.afjg.coinbot.entity.datatprocessing;

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
	private CurrencyNotes notes;
	private volatile int countFinishedActions;

	public CurrencyTrend() {

	}

	public CurrencyTrend(List<CurrencyRate> currencyRates, List<TrendRule> trendRules) {
		this.setCurrencyRates(currencyRates);
		this.setTrendRules(trendRules);
		this.setTrendCalculs(new ArrayList<>());
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

	public CurrencyNotes getNote() {
		return notes;
	}

	public void setNote(CurrencyNotes note) {
		this.notes = note;
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
		int numberOperation = 0;

		// test*****************************************************************************
		System.out.println("taille tableau currencuyrate : " + this.getCurrencyRates().size()
				+ "-----------------------------------");

		int i = 0;

		// test*****************************************************************************

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
			// test*****************************************************************************
			i++;
			System.out.println("tendance " + i + " taille tableau : " + transmittedListToCalcul.size()
					+ "--------------------------------------------");
			// test*****************************************************************************

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
				break;
			}
		}

		// stage 5 : transmit the list of trend for the notation

	
		// test******************************************************************************************
		System.out.println("********************résulats**************************résultats************** ");
		for (TrendCalculation trendcalc : this.trendCalculs) {

			for (LineEquationTrend lET : trendcalc.getLinesEquationsTrends()) {
				System.out.println("Selon règle : " + trendcalc.getTrendRule().getName() + " et tendance de type : "
						+ lET.getTypeBidOrAsk() + " type de ligne : " + lET.getTypeLine() + " -- a = "
						+ lET.getLeadingDirect() + " , b = " + lET.getOrdOrigin());

			}
			if (trendcalc.getLastTrends() != null) {
				for (LastTrend lt : trendcalc.getLastTrends()) {
					System.out.println(
							"dernière tendance sur courbe " + lt.getTypeBidOrAsk() + " : a = " + lt.getLeadingDirect()
									+ " , b = " + lt.getOrdOrigin() + " , validity :" + lt.isValidityTrend());
				}

			}
		}

		System.out.println("fin résultats*****************************fin résultats***********************");

		// test**************************************************************************************

		// Stage 5: transmit the list of trend for the notation
		
		this.setNote(new CurrencyNotes(this));

		// Final stage : prevent end thread

		CurrenciesTrendsBot cTB = CurrenciesTrendsBot.getInstance();
		cTB.setNbActifThreadsTrend(cTB.getNbActifThreadsTrend() - 1);

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
