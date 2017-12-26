package fr.afgj.coinbot.rule.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class TrendRulesBot extends TrendRule{
	private Logger log = Logger.getLogger(this.getClass());
	
	public TrendRulesBot() {
	}

	public void loadTrendRulesBotEnum() {

		List<TrendRulesBotEnum> trendRulesEnum = TrendRulesBotEnum.list();
		List<TrendRule> trendRules = new ArrayList<>();

		Iterator<TrendRulesBotEnum> ite = trendRulesEnum.iterator();
		while (ite.hasNext()) {
			TrendRulesBot trendRulesBot = new TrendRulesBot();

			TrendRulesBotEnum trbe = ite.next();
			log.info(
					trbe + " " + trbe.getNumberDays() + " " + trbe.getNumberHours() + " " + trbe.getMultiplier());

			trendRulesBot.setName(trbe.toString());
			trendRulesBot.setNumberDays(trbe.getNumberDays());
			trendRulesBot.setNumberHours(trbe.getNumberHours());
			trendRulesBot.setMultiplier(trbe.getMultiplier());

			trendRules.add(trendRulesBot);
		}

		this.setTrendRules(trendRules);


	}

}
