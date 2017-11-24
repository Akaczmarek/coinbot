package fr.afjg.coinbot.pojo.datatprocessing;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;

public class CurrencyTrend extends Currency implements Runnable {

	private List<CurrencyRate> currencyRates;
	private List<TrendCalculation> trendCalculs;
	private double noteCurrency;
	private Timestamp timeRecord;
	private CurrencyNote note;

	public CurrencyTrend() {

	}

	public CurrencyTrend(List<CurrencyRate> currencyRates) {

	}

	// getters &
	// Setters------------------------------------------------------------------

	public List<CurrencyRate> getCurrencyRates() {
		return currencyRates;
	}

	public void setCurrencyRates(List<CurrencyRate> currencyRates) {
		this.currencyRates = currencyRates;
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

	public static Comparator<CurrencyTrend> getCTTimestampComparator() {
		return CTTimestampComparator;
	}

	public static void setCTTimestampComparator(Comparator<CurrencyTrend> cTTimestampComparator) {
		CTTimestampComparator = cTTimestampComparator;
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
		
		List<TrendRulesBotEnum> trList = TrendRulesBotEnum.list();
		Collections.sort(trList, TrendRulesBotEnum.TRDurationComparator);
		
		
		
		//Stage 1 : boucler pour faire toutes les tendances

		for (TrendRulesBotEnum trendRules : trList) {
			
			List <CurrencyRate> transmittedList = new ArrayList<>(this.getCurrencyRates());
			
			/*
			Predicate<T>
			transmittedList.removeIf(filter)
			*/
			
			
			
		}
		
		
		
		
		

	}

	
	

	
	public static Comparator<CurrencyTrend> CTNoteComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {
			// TODO Auto-generated method stub
			int noteCT1 = (int)(CT1.getNoteCurrency()*1000);
			int noteCT2 = (int)(CT2.getNoteCurrency()*1000);
			return noteCT1 - noteCT2 ;
		}
	};
	
	
	public static Comparator<CurrencyTrend> CTTimestampComparator = new Comparator<CurrencyTrend>() {

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
		


		List<TrendRulesBotEnum> trList = TrendRulesBotEnum.list();
		Collections.sort(trList, TrendRulesBotEnum.TRDurationComparator);
		
		
		
		//Stage 1 : boucler pour faire toutes les tendances

		while (trList.size()!= 0 ) {
			
			System.out.println(trList.get(0));
			trList.remove(0);
		}
		
		
	}


}
