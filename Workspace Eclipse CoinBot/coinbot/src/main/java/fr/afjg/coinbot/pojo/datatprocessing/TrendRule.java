package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * rules differents of rules bot
 * 
 * @author ghislain
 *
 */
public abstract class TrendRule {

	List<TrendRule> TrendRules;
	private int numberDays;
	private int numberHours;
	private int multiplier;

	public TrendRule() {

	}

	public TrendRule(int numberDays, int numberHours, int multiplier) {
		super();
		this.setNumberDays(numberDays);
		this.setNumberHours(numberHours);
		this.setMultiplier(multiplier);
	}

	
	// getters and setters ----------------------------------------------------------------------------
	
	public int getNumberDays() {
		return numberDays;
	}

	public void setNumberDays(int numberDays) {
		this.numberDays = numberDays;
	}

	public int getNumberHours() {
		return numberHours;
	}

	public void setNumberHours(int numberHours) {
		this.numberHours = numberHours;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	public List<TrendRule> getTrendRules() {
		return TrendRules;
	}

	public void setTrendRules(List<TrendRule> trendRules) {
		TrendRules = trendRules;
	}
	
	
	// Methods -------------------------------------------------------------------------------
	
	/*
	 * return the max value duration of trend
	 */
	public long MaxTimeInHours() {
		
		List<TrendRule> tr = this.getTrendRules();
		
		Collections.sort(tr, this.TRDurationComparator);

		return this.convertDurationInHours(tr.get(0));
	}

	/*
	 * returns a long type that corresponds to the duration in hours
	 */
	public long convertDurationInHours(TrendRule tr) {
		long result = (tr.getNumberDays() * 24) + tr.getNumberHours();
		return result;
	}

	public Comparator<TrendRule> TRDurationComparator = new Comparator<TrendRule>() {

		@Override
		public int compare(TrendRule tr1, TrendRule tr2) {
			// TODO Auto-generated method stub

			int TRduration1 = (int) tr1.convertDurationInHours(tr1);
			int TRduration2 = (int) tr2.convertDurationInHours(tr2);

			return TRduration2 - TRduration1;
		}
	};

	
	
}