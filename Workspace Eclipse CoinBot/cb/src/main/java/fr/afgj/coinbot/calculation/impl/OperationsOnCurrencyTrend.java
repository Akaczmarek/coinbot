package fr.afgj.coinbot.calculation.impl;

import java.util.List;

import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.rule.impl.TrendRule;

public class OperationsOnCurrencyTrend implements Runnable{

	private List<CurrencyRate> currencyRates;
	private List<TrendNoteToBuy> TrendNotesToBuy;
	private List<TrendNoteToSell> TrendNotesToSell;
	private TrendRule trendRule;
	private CurrencyTrend currencyTrend;

	public OperationsOnCurrencyTrend(List<CurrencyRate> currencyRates, TrendRule trendRule,
			CurrencyTrend currencyTrend) {
		super();
		this.currencyRates = currencyRates;
		this.trendRule = trendRule;
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

	public TrendRule getTrendRule() {
		return trendRule;
	}

	public void setTrendRule(TrendRule trendRule) {
		this.trendRule = trendRule;
	}
	
	
	public List<TrendNoteToBuy> getTrendNotesToBuy() {
		return TrendNotesToBuy;
	}

	public void setTrendNotesToBuy(List<TrendNoteToBuy> trendNotesToBuy) {
		TrendNotesToBuy = trendNotesToBuy;
	}

	public List<TrendNoteToSell> getTrendNotesToSell() {
		return TrendNotesToSell;
	}

	public void setTrendNotesToSell(List<TrendNoteToSell> trendNotesToSell) {
		TrendNotesToSell = trendNotesToSell;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//
		
		
	}

}
