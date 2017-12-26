package fr.afgj.coinbot.rule.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public abstract class TrendRule {



		List<TrendRule> TrendRules;
		private String name;
		private int numberDays;
		private int numberHours;
		private int multiplier;
		private Date startDate; // translation to date - the rule start 
		private Date endDate; // translation to date - the rule end (current date)

		public TrendRule() {

		}

		public TrendRule(int numberDays, int numberHours, int multiplier) {
			super();
			this.setNumberDays(numberDays);
			this.setNumberHours(numberHours);
			this.setMultiplier(multiplier);
		}

		// getters and setters
		// ----------------------------------------------------------------------------

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
		
		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		// Methods
		// -------------------------------------------------------------------------------



		/*
		 * return the max value duration of trend
		 */
		public long MaxTimeInHours() {

			List<TrendRule> tr = this.getTrendRules();

			Collections.sort(tr, TrendRule.TRDurationComparator);

			return this.convertDurationInHours(tr.get(0));
		}

		/*
		 * returns a long type that corresponds to the duration in hours
		 */
		public long convertDurationInHours(TrendRule tr) {
			long result = (tr.getNumberDays() * 24) + tr.getNumberHours();
			return result;
		}
		
		public long convertDurationInMillis(TrendRule tr) {
			long result = (long)((((long)tr.getNumberDays() * 24) + (long)tr.getNumberHours())*(long)3600000);
			System.out.println("durée en miliseconde" +result  + ", nombre heure " + tr.getNumberHours());
			return result;
		}
		

		public final static Comparator<TrendRule> TRDurationComparator = new Comparator<TrendRule>() {

			@Override
			public int compare(TrendRule tr1, TrendRule tr2) {
				// TODO Auto-generated method stub

				int TRduration1 = (int) tr1.convertDurationInHours(tr1);
				int TRduration2 = (int) tr2.convertDurationInHours(tr2);

				return TRduration2 - TRduration1;
			}
		};
		
		public Date updateDefinitionStartDate() {
			Date endDate = updateDefinitioneEndDate();
			Long durationRule = convertDurationInMillis(this);
			
			Date startDate = new Date(endDate.getTime()- durationRule);
			System.out.println("opération " +  (endDate.getTime()- durationRule));
			this.setStartDate(startDate);
			
			return startDate;
		}
		
		public Date updateDefinitioneEndDate() {
			Date endDate = new Date();
			this.setEndDate(endDate);
			return endDate;
		}
}
