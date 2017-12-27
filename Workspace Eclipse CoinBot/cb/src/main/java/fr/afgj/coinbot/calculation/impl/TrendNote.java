package fr.afgj.coinbot.calculation.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.afgj.coinbot.calculation.ITrendNote;
import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.rule.impl.TrendRule;

public abstract class TrendNote implements Runnable, ITrendNote {

	private double note;
	private List<CurrencyRate> currencyRates;
	private List<TrendPointXY> pointsXY;
	private TrendRule trendRule;
	private OperationsOnCurrencyTrend ooct;

	public TrendNote() {

	}

	public TrendNote(List<CurrencyRate> currencyRates, TrendRule trendRule, OperationsOnCurrencyTrend ooct) {
		super();
		this.currencyRates = currencyRates;
		this.trendRule = trendRule;
		this.ooct = ooct;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public List<CurrencyRate> getCurrencyRates() {
		return currencyRates;
	}

	public void setCurrencyRates(List<CurrencyRate> currencyRates) {
		this.currencyRates = currencyRates;
	}

	public TrendRule getTrendRule() {
		return trendRule;
	}

	public void setTrendRule(TrendRule trendRule) {
		this.trendRule = trendRule;
	}

	public OperationsOnCurrencyTrend getOoct() {
		return ooct;
	}

	public void setOoct(OperationsOnCurrencyTrend ooct) {
		this.ooct = ooct;
	}

	/* (non-Javadoc)
	 * @see fr.afgj.coinbot.calculation.impl.ITrendNote#calculationAveragePt1(java.lang.String)
	 */
	@Override
	public TrendPointXYAverage calculationAveragePt1(String type) {

		List<CurrencyRate> currencyRates = new ArrayList<>(this.getCurrencyRates());
		List<CurrencyRate> partOfCurrencyRate = currencyRates.subList(0, (currencyRates.size() / 2));
		TrendPointXYAverage pt = calculationAveragePt(partOfCurrencyRate, type);

		return pt;
	}

	/* (non-Javadoc)
	 * @see fr.afgj.coinbot.calculation.impl.ITrendNote#calculationAveragePt2(java.lang.String)
	 */
	@Override
	public TrendPointXYAverage calculationAveragePt2(String type) {

		List<CurrencyRate> currencyRates = new ArrayList<>(this.getCurrencyRates());
		List<CurrencyRate> partOfCurrencyRate = currencyRates.subList((currencyRates.size() / 2),
				(currencyRates.size()));
		TrendPointXYAverage pt = calculationAveragePt(partOfCurrencyRate, type);

		return pt;
	}

	/* (non-Javadoc)
	 * @see fr.afgj.coinbot.calculation.impl.ITrendNote#calculationAveragePt(java.util.List, java.lang.String)
	 */
	@Override
	public TrendPointXYAverage calculationAveragePt(List<CurrencyRate> partOfCurrencyRate, String type) {
		TrendPointXYAverage pt = new TrendPointXYAverage();

		List<CurrencyRate> list = partOfCurrencyRate;

		long sumDate = 0L;
		double sumValue = 0.0;
		
		if (!list.isEmpty()) {
			for (CurrencyRate cr : list) {

				sumDate += cr.getTimerecord().getTime();
				
				if ("bid".equals(type)) {
					sumValue += cr.getBidbtc();

				} else if ("ask".equals(type)) {
					sumValue += cr.getAskbtc();
				
				}
			}
			pt.setX( sumDate /list.size());
			pt.setY( sumValue /list.size());
		}

		return pt;
	}

	public static void main(String[] args) {
		
		
		CurrencyRate cr1 =  new CurrencyRate();
		cr1.setTimerecord(new Date(1000L) );
		cr1.setAskbtc(2.0);
		cr1.setBidbtc(4.0);

		CurrencyRate cr2 =  new CurrencyRate();
		cr2.setTimerecord(new Date(2000L) );
		cr2.setAskbtc(4.0);
		cr2.setBidbtc(4.0);
		CurrencyRate cr3 =  new CurrencyRate();
		cr3.setTimerecord(new Date(3000L) );
		cr3.setAskbtc(6.0);
		cr3.setBidbtc(4.0);
		CurrencyRate cr4 =  new CurrencyRate();
		cr4.setTimerecord(new Date(4000L) );
		cr4.setAskbtc(8.0);
		cr4.setBidbtc(4.0);
		CurrencyRate cr5 =  new CurrencyRate();
		cr5.setTimerecord(new Date(5000L) );
		cr5.setAskbtc(10.0);
		cr5.setBidbtc(4.0);

		
		List<CurrencyRate> list = new ArrayList<>();
		list.add(cr1);
		list.add(cr2);
		list.add(cr3);
		list.add(cr4);
		list.add(cr5);
		
		TrendNote tn = new TrendNoteToBuy();
		tn.setCurrencyRates(list);
		
		TrendPointXY pt= tn.calculationAveragePt2("ask");
		
		System.out.println("temps " + pt.getX() + ", value " + pt.getY());
		
		

	}

}
