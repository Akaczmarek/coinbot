package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

				Date startDateRule = tr.updateDefinitionStartDate();
				
				List<CurrencyRate> crsTransmit = new ArrayList<>(crs);
				
				crsTransmit.removeIf(p-> p.getTimerecord().getTime()<startDateRule.getTime());
				
				TrendNoteToBuy tntb = new TrendNoteToBuy(crsTransmit, tr, this);
				TrendNoteToSell tnts = new TrendNoteToSell(crsTransmit, tr, this);

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
		
		
		CurrencyRate cr1 =  new CurrencyRate();
		cr1.setTimerecord(new Date(1514305547000L) );
		CurrencyRate cr2 =  new CurrencyRate();
		cr2.setTimerecord(new Date(1514287547000L) );
		CurrencyRate cr3 =  new CurrencyRate();
		cr3.setTimerecord(new Date(1514114747000L) );
		CurrencyRate cr4 =  new CurrencyRate();
		cr4.setTimerecord(new Date(1513164347000L) );
		
		Date startDateRule = new Date (1514291147000L);
		List<CurrencyRate> crsTransmit = new ArrayList<>();
		
		 crsTransmit.add(cr1);
		 crsTransmit.add(cr2);
		 crsTransmit.add(cr3);
		 crsTransmit.add(cr4);
		 
		 
		crsTransmit.removeIf(p-> p.getTimerecord().getTime()<startDateRule.getTime());
		System.out.println("----------------------");
		for (CurrencyRate currencyRate : crsTransmit) {
			System.out.println(currencyRate.getTimerecord());
		}

	}

}
