package fr.afjg.coinbot.pojo.datatprocessing;

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

	
	
}
