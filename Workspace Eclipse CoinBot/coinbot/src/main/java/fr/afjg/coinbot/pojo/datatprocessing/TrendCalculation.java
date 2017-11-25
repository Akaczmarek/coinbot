package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.util.MathTools;
import fr.afjg.coinbot.util.ParseTools;

public class TrendCalculation implements Runnable {

	private List<CurrencyRate> currencyRates;
	private volatile List<LineEquationTrend> linesEquationsTrends;
	private CurrencyTrend currencyTrend;
	private TrendRule trendRule;
	private volatile int countFinishedActions;

	{
		this.setCountFinishedActions(0);
	}

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

	public synchronized void setLinesEquationsTrends(List<LineEquationTrend> linesEquationsTrends) {
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

	public int getCountFinishedActions() {
		return countFinishedActions;
	}

	public void setCountFinishedActions(int countFinishedActions) {
		this.countFinishedActions = countFinishedActions;
	}
	// methods
	// -----------------------------------------------------------------------

	public synchronized void finishActionsChecked() {
		this.setCountFinishedActions(getCountFinishedActions() + 1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// Stage 0 : Definition of treatment procedure
		String[] typeBidOrAsk = { "ask", "bid" };
		String[] typeLine = { "average", "support", "ceiling" };

		for (int i = 0; i < typeBidOrAsk.length; i++) {

			for (int j = 0; j < typeBidOrAsk.length; j++) {

				// Stage 1 : transform currency list in pointXY list
				List<PointXY> ptList = ParseTools.transformCRListInPtList(getCurrencyRates(), typeBidOrAsk[i]);

				// Stage 2 : split the list into two
				PointXY[][] doubleListPtXY = ParseTools.parselistpointXYen2(ptList);
				List<PointXY> ptList1 = new ArrayList<>(Arrays.asList(doubleListPtXY[0]));
				List<PointXY> ptList2 = new ArrayList<>(Arrays.asList(doubleListPtXY[0]));

				// Stage 3 : Average point1
				PointXY averagePt1 = MathTools.averagePoint(ptList1);

				// Stage 4 : Average point2
				PointXY averagePt2 = MathTools.averagePoint(ptList2);

				// Stage 5 : determination line equation
				LineEquationTrend lET = new LineEquationTrend(this, typeBidOrAsk[i], typeLine[j], averagePt1,
						averagePt2);

			}

		}

		// Stage 6 : control as every operation is finished and save trendcalculation in
		// list of CurrencyTrend
		int numberOperation = typeBidOrAsk.length * typeLine.length;

		while (true) {
			if (this.getCountFinishedActions() == numberOperation) {

				this.getCurrencyTrend().getTrendCalculs().add(this);
				break;
			}
		}

		// final Stage : prevent it's finished

		this.getCurrencyTrend().finishActionsChecked();

	}
}
