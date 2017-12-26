package fr.afgj.coinbot.calculation.impl;

import java.util.List;

import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.CurrencyTrend;

public class OperationsOnCurrencyTrend {
	
	private List<CurrencyRate> currencyRates;
	private CurrencyTrend currencyTrend;
	
	public OperationsOnCurrencyTrend(List<CurrencyRate> currencyRates, CurrencyTrend currencyTrend) {
		super();
		this.currencyRates = currencyRates;
		this.currencyTrend = currencyTrend;
	}
	public List<CurrencyRate> getCurrencyRates() {
		return currencyRates;
	}
	public void setCurrencyRates(List<CurrencyRate> currencyRates) {
		this.currencyRates = currencyRates;
	}
	public CurrencyTrend getCurrencyTrend() {
		return currencyTrend;
	}
	public void setCurrencyTrend(CurrencyTrend currencyTrend) {
		this.currencyTrend = currencyTrend;
	}
	


}
