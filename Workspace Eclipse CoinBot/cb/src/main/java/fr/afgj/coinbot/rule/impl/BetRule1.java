package fr.afgj.coinbot.rule.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BetRule1 extends BetRule {
	
	public BetRule1() {
		this.setDurationNoBet(new Date(3600000));
	}

}
