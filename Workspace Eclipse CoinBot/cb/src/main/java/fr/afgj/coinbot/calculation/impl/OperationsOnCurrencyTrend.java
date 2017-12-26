package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.rule.impl.TrendRule;
import fr.afgj.coinbot.rule.impl.TrendRulesBot;

public class OperationsOnCurrencyTrend implements Runnable {

	private Logger log = Logger.getLogger(this.getClass());

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

		// check if the calcul is possible

		if (this.getCurrencyRates() != null && this.getCurrencyRates().size() > 100) {

			List<CurrencyRate> crs = new ArrayList<>(this.getCurrencyRates());

			// Sorting the list of currency Rate (the youngest is first)
			Collections.sort(crs, CurrencyRate.CRComparatorByDate);

			// scroll through the rule list and start the note calculation process according
			// to each rule.

			for (TrendRule tr : this.getTrendRule().getTrendRules()) {

				tr.updateDefinitionStartDate();
				
				TrendNoteToBuy tntb = new TrendNoteToBuy(crs, tr, this);
				TrendNoteToSell tnts = new TrendNoteToSell(crs, tr, this);

			}

		} else {
			this.log.error("error " + this.toString());
		}

	}

	@Override
	public String toString() {
		return "OperationsOnCurrencyTrend [currencyTrend=" + currencyTrend + ", getCurrencyRates()="
				+ getCurrencyRates() + ", getCurrencyTrend()=" + getCurrencyTrend() + ", getTrendRule()="
				+ getTrendRule() + ", getTrendNotesToBuy()=" + getTrendNotesToBuy() + ", getTrendNotesToSell()="
				+ getTrendNotesToSell() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public static void main(String[] args) {
		
		TrendRulesBot tr = new TrendRulesBot();
		tr.loadTrendRulesBotEnum(); 
		
		for (TrendRule trb : tr.getTrendRules()) {
			System.out.println(trb.getName() + ", date départ " + trb.updateDefinitionStartDate() + ", date fin" + trb.updateDefinitioneEndDate());
		}

	}

}
