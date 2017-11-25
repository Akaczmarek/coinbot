package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.util.MathTools;
import fr.afjg.coinbot.util.ParseTools;

public class TrendCalculation implements Runnable {

	private List<CurrencyRate> currencyRates;
	private List<LineEquationTrend> linesEquationsTrends;
	private CurrencyTrend currencyTrend;
	private TrendRule trendRule;

	public TrendCalculation() {

	}

	public TrendCalculation(List<CurrencyRate> currencyRates, CurrencyTrend currencyTrend, TrendRule trendRule) {
		this.setCurrencyRates(currencyRates);
		this.setCurrencyTrend(currencyTrend);
		this.setTrendRule(trendRule);
	}

	// getters and
	// setters-------------------------------------------------------------------

	public List<CurrencyRate> getCurrencyRates() {
		return currencyRates;
	}

	public void setCurrencyRates(List<CurrencyRate> currencyRates) {
		this.currencyRates = currencyRates;
	}

	public List<LineEquationTrend> getLinesEquationsTrends() {
		return linesEquationsTrends;
	}

	public void setLinesEquationsTrends(List<LineEquationTrend> linesEquationsTrends) {
		this.linesEquationsTrends = linesEquationsTrends;
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

	// methods
	// -----------------------------------------------------------------------

	@Override
	public void run() {
		// TODO Auto-generated method stub

		String typeBidOrAsk;
		String typeLine = "";

		// Stage 0 : Treatement on ask
		typeBidOrAsk = "ask";

		// Stage 1 : transform currency list in pointXY list
		List<PointXY> ptList = ParseTools.transformCRListInPtList(getCurrencyRates(), typeBidOrAsk);

		// Stage 2 : split the list into two
		PointXY[][] doubleListPtXY = ParseTools.parselistpointXYen2(ptList);
		List<PointXY> ptList1 = new ArrayList<>(Arrays.asList(doubleListPtXY[0]));
		List<PointXY> ptList2 = new ArrayList<>(Arrays.asList(doubleListPtXY[0]));

		// Stage 3 : Average point1
		PointXY averagePt1 = MathTools.averagePoint(ptList1);

		// Stage 4 : Average point2
		PointXY averagePt2 = MathTools.averagePoint(ptList2);

		// Stage 5 : determination line equation
		LineEquationTrend lET = new LineEquationTrend(this, typeBidOrAsk, typeLine);

		// final Stage : save trendcalculation in list of CurrencyTrend
		this.getCurrencyTrend().getTrendCalculs().add(this);

	}
}
