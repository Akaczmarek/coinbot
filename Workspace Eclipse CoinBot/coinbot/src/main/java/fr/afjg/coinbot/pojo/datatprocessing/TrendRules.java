package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * give the rules of trend duration and multiplier
 */
public enum TrendRules {

	H4(0, 4, 5), D1(1, 0, 3), D1H12(1, 12, 2), D10(10, 0, 3), D30(30, 0, 2);

	private int numberDays;
	private int numberHours;
	private int multiplier;

	private TrendRules(int numberDays, int numberHours, int multiplier) {
		// TODO Auto-generated constructor stub
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

	// methods -------------------------------------------------------------------------------
	
	public static List<TrendRules> list () {
		
		List<TrendRules> list = new ArrayList<>(Arrays.asList(TrendRules.values()));
		
		return list;
		
	}
	
	
	public static long MaxTimeInHours() {
		
		List<TrendRules> trs =TrendRules.list();
		
		Collections.sort(trs,TrendRules.TRDurationComparator);

		return TrendRules.convertDurationInHours(trs.get(0));
	}


	public static long convertDurationInHours(TrendRules tr) {
		long result = (tr.getNumberDays() * 24) + tr.getNumberHours();
		return result;
	}

	public static Comparator<TrendRules> TRDurationComparator = new Comparator<TrendRules>() {

		@Override
		public int compare(TrendRules tr1, TrendRules tr2) {
			// TODO Auto-generated method stub

			int TRduration1 = (int) TrendRules.convertDurationInHours(tr1);
			int TRduration2 = (int) TrendRules.convertDurationInHours(tr2);

			return TRduration2 - TRduration1;
		}
	};
}
