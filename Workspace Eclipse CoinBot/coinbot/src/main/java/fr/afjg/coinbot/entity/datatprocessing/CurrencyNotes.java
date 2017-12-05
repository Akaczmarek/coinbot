package fr.afjg.coinbot.entity.datatprocessing;

import java.util.List;

public class CurrencyNotes {
	
	private CurrencyTrend currencyTrend;
	private List<CurrencyNote> currencyNotes;
	
	public CurrencyNotes(CurrencyTrend currencyTrend) {
		this.setCurrencyTrend(currencyTrend);
		listOfOperations();
		
	}

	// getters & setters---------------------------------------------------------------
	
	public CurrencyTrend getCurrencyTrend() {
		return currencyTrend;
	}

	public void setCurrencyTrend(CurrencyTrend currencyTrend) {
		this.currencyTrend = currencyTrend;
	}

	public List<CurrencyNote> getCurrencyNotes() {
		return currencyNotes;
	}

	public void setCurrencyNotes(List<CurrencyNote> currencyNotes) {
		this.currencyNotes = currencyNotes;
	}
	
	//methods------------------------------------------------------------
	
	public void listOfOperations() {
		
		
		
	}
	

}
