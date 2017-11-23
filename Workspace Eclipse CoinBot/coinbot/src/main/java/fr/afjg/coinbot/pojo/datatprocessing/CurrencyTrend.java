package fr.afjg.coinbot.pojo.datatprocessing;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.afjg.coinbot.pojo.database.Currency;
import fr.afjg.coinbot.pojo.database.CurrencyRate;

public class CurrencyTrend extends Currency implements Runnable {

	private List<CurrencyRate> currencyRates;
	private double leadingDirect4hAverageBid;
	private double ordOrigin4hAverageBid;
	private double leadingDirect4hCeilingBid;
	private double ordOrigin4hCeilingBid;
	private double leadingDirect4hSuppBid;
	private double ordOrigin4hSuppBid;
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

	public double getLeadingDirect4hAverageBid() {
		return leadingDirect4hAverageBid;
	}

	public void setLeadingDirect4hAverageBid(double leadingDirect4hAverageBid) {
		this.leadingDirect4hAverageBid = leadingDirect4hAverageBid;
	}

	public double getOrdOrigin4hAverageBid() {
		return ordOrigin4hAverageBid;
	}

	public void setOrdOrigin4hAverageBid(double ordOrigin4hAverageBid) {
		this.ordOrigin4hAverageBid = ordOrigin4hAverageBid;
	}

	public double getLeadingDirect4hCeilingBid() {
		return leadingDirect4hCeilingBid;
	}

	public void setLeadingDirect4hCeilingBid(double leadingDirect4hCeilingBid) {
		this.leadingDirect4hCeilingBid = leadingDirect4hCeilingBid;
	}

	public double getOrdOrigin4hCeilingBid() {
		return ordOrigin4hCeilingBid;
	}

	public void setOrdOrigin4hCeilingBid(double ordOrigin4hCeilingBid) {
		this.ordOrigin4hCeilingBid = ordOrigin4hCeilingBid;
	}

	public double getLeadingDirect4hSuppBid() {
		return leadingDirect4hSuppBid;
	}

	public void setLeadingDirect4hSuppBid(double leadingDirect4hSuppBid) {
		this.leadingDirect4hSuppBid = leadingDirect4hSuppBid;
	}

	public double getOrdOrigin4hSuppBid() {
		return ordOrigin4hSuppBid;
	}

	public void setOrdOrigin4hSuppBid(double ordOrigin4hSuppBid) {
		this.ordOrigin4hSuppBid = ordOrigin4hSuppBid;
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
		
		List<TrendRules> trList = TrendRules.list();
		Collections.sort(trList, TrendRules.TRDurationComparator);
		
		
		
		//Stage 1 : boucler pour faire toutes les tendances

		while (trList.size()!= 0 ) {
			
			
			
			
			trList.remove(0);
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
		


		List<TrendRules> trList = TrendRules.list();
		Collections.sort(trList, TrendRules.TRDurationComparator);
		
		
		
		//Stage 1 : boucler pour faire toutes les tendances

		while (trList.size()!= 0 ) {
			
			System.out.println(trList.get(0));
			trList.remove(0);
		}
		
		
	}


}
