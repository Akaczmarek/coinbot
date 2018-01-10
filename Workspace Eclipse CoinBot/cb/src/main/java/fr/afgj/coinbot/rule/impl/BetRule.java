package fr.afgj.coinbot.rule.impl;

import java.util.Date;

public abstract class BetRule {
	
	private Date durationNoBet; //duration while no bet, between two bets

	
	public Date getDurationNoBet() {
		return durationNoBet;
	}

	public void setDurationNoBet(Date durationNoBet) {
		this.durationNoBet = durationNoBet;
	}
	
	

}
