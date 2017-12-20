package fr.afjg.coinbot.entity;

import java.sql.Timestamp;
import java.util.Comparator;



public class CurrencyTrend extends Currency{

	private long idCurrencyTrend;
	private double lastValueBid;
	private double lastValueAsk;
	private Timestamp timeRecord;
	private double noteToBuy;
	private double noteToSell;
	private boolean lastTrendGrowing;
	private double lastTrendWeight;
	
	public CurrencyTrend() {
		super();

	}

	public double getLastValueBid() {
		return lastValueBid;
	}

	public void setLastValueBid(double lastValueBid) {
		this.lastValueBid = lastValueBid;
	}

	public double getLastValueAsk() {
		return lastValueAsk;
	}

	public void setLastValueAsk(double lastValueAsk) {
		this.lastValueAsk = lastValueAsk;
	}

	public Timestamp getTimeRecord() {
		return timeRecord;
	}

	public void setTimeRecord(Timestamp timeRecord) {
		this.timeRecord = timeRecord;
	}

	public double getNoteToBuy() {
		return noteToBuy;
	}

	public void setNoteToBuy(double noteToBuy) {
		this.noteToBuy = noteToBuy;
	}

	public double getNoteToSell() {
		return noteToSell;
	}

	public void setNoteToSell(double noteToSell) {
		this.noteToSell = noteToSell;
	}

	public boolean isLastTrendGrowing() {
		return lastTrendGrowing;
	}

	public void setLastTrendGrowing(boolean lastTrendGrowing) {
		this.lastTrendGrowing = lastTrendGrowing;
	}

	public double getLastTrendWeight() {
		return lastTrendWeight;
	}

	public void setLastTrendWeight(double lastTrendWeight) {
		this.lastTrendWeight = lastTrendWeight;
	}
	
	
	//methods--------------------------------------------------------------------
	
	public volatile static Comparator<CurrencyTrend> CTNoteToBuyComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {
			// TODO Auto-generated method stub

				int noteCT1 = (int) (CT1.getNoteToBuy() * 1000);
				int noteCT2 = (int) (CT2.getNoteToBuy() * 1000);
				return noteCT2 - noteCT1;
		}
	};

	public volatile static Comparator<CurrencyTrend> CTNoteToSellComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {

				int noteCT1 = (int) (CT1.getNoteToSell() * 1000);
				int noteCT2 = (int) (CT2.getNoteToSell() * 1000);
				return noteCT2 - noteCT1;

		}
	};
	
	
	
	
	
	
}
