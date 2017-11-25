package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrendRulesBot extends TrendRule {

	public TrendRulesBot () {
	}
	
	
	
	public void loadTrendRulesBotEnum () {
		
		List<TrendRulesBotEnum> trendRulesEnum = TrendRulesBotEnum.list();
		List<TrendRule> trendRules = new ArrayList<>();
		
		Iterator<TrendRulesBotEnum> ite = trendRulesEnum.iterator();
		while (ite.hasNext()) {
			TrendRulesBot trendRulesBot = new TrendRulesBot();

			TrendRulesBotEnum trbe = ite.next();
			System.out.println(trbe + " " + trbe.getNumberDays()+ " " + trbe.getNumberHours()+ " " + trbe.getMultiplier());
			
			trendRulesBot .setNumberDays(trbe.getNumberDays());
			trendRulesBot .setNumberHours(trbe.getNumberHours());
			trendRulesBot .setMultiplier(trbe.getMultiplier());
			
			trendRules.add(trendRulesBot);
		}
		
		this.setTrendRules(trendRules);
		
		System.out.println("règles de calcul de tendance chargées-----------------------------------------");
		
	}
	
	
	public static void main(String[] args) {
		
		TrendRulesBot tr = new TrendRulesBot();
		
		tr.loadTrendRulesBotEnum();
		
		for (TrendRule trs : tr.getTrendRules()) {
			System.out.println(trs.getNumberDays()+" "+trs.getNumberHours() +" "+trs.getMultiplier());
			System.out.println("----------------------------------------------------------");
		}
		

		
	}
		
	
	

}



