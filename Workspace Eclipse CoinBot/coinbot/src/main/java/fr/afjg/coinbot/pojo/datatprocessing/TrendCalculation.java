package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.List;

import fr.afjg.coinbot.pojo.database.CurrencyRate;

public class TrendCalculation {
	
	private List<CurrencyRate> currencyRates;
	private double leadingDirectAverage;
	private double ordOriginAverage;
	private double leadingDirectCeiling;
	private double ordOriginCeiling;
	private double leadingDirectSupp;
	private double ordOriginSupp;

	
	public TrendCalculation () {
		
	}
	
	public TrendCalculation (List<CurrencyRate> currencyRates) {
		
	}

	//getters and setters-------------------------------------------------------------------
	
	public List<CurrencyRate> getCurrencyRates() {
		return currencyRates;
	}

	public void setCurrencyRates(List<CurrencyRate> currencyRates) {
		this.currencyRates = currencyRates;
	}

	public double getLeadingDirectAverage() {
		return leadingDirectAverage;
	}

	public void setLeadingDirectAverage(double leadingDirectAverage) {
		this.leadingDirectAverage = leadingDirectAverage;
	}

	public double getOrdOriginAverage() {
		return ordOriginAverage;
	}

	public void setOrdOriginAverage(double ordOriginAverage) {
		this.ordOriginAverage = ordOriginAverage;
	}

	public double getLeadingDirectCeiling() {
		return leadingDirectCeiling;
	}

	public void setLeadingDirectCeiling(double leadingDirectCeiling) {
		this.leadingDirectCeiling = leadingDirectCeiling;
	}

	public double getOrdOriginCeiling() {
		return ordOriginCeiling;
	}

	public void setOrdOriginCeiling(double ordOriginCeiling) {
		this.ordOriginCeiling = ordOriginCeiling;
	}

	public double getLeadingDirectSupp() {
		return leadingDirectSupp;
	}

	public void setLeadingDirectSupp(double leadingDirectSupp) {
		this.leadingDirectSupp = leadingDirectSupp;
	}

	public double getOrdOriginSupp() {
		return ordOriginSupp;
	}

	public void setOrdOriginSupp(double ordOriginSupp) {
		this.ordOriginSupp = ordOriginSupp;
	}
	
	// methods -----------------------------------------------------------------------
	
	
	
}
