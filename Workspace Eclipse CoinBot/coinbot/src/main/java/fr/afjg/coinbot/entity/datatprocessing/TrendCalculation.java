package fr.afjg.coinbot.entity.datatprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.util.MathTools;
import fr.afjg.coinbot.util.ParseTools;

public class TrendCalculation implements Runnable {

	private List<CurrencyRate> currencyRates;
	private volatile List<LineEquationTrend> linesEquationsTrends;
	private volatile List<LastTrend> lastTrends;
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
		this.setLinesEquationsTrends(new ArrayList<>());
		this.setLastTrends(new ArrayList<>());

	}

	// getters and
	// setters-------------------------------------------------------------------

	public List<CurrencyRate> getCurrencyRates() {
		return currencyRates;
	}

	public void setCurrencyRates(List<CurrencyRate> currencyRates) {
		this.currencyRates = currencyRates;
	}

	public synchronized List<LineEquationTrend> getLinesEquationsTrends() {
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

	public synchronized List<LastTrend> getLastTrends() {
		return lastTrends;
	}

	public synchronized void setLastTrends(List<LastTrend> lastTrend) {
		this.lastTrends = lastTrend;
	}


	// methods
	// -----------------------------------------------------------------------



	public synchronized void finishActionsChecked() {
		this.setCountFinishedActions(getCountFinishedActions() + 1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("trend calculation lancé-----------------------------------------");

		// Stage 0 : Definition of treatment procedure

		String[] typeBidOrAsk = { "ask", "bid" };
		String[] typeLine = { "average", "support", "ceiling" };
		List<PointXY> ptList = null;

		for (int i = 0; i < typeBidOrAsk.length; i++) {

			// Stage 1 : transform currency list in pointXY list
			ptList = ParseTools.transformCRListInPtList(getCurrencyRates(), typeBidOrAsk[i]);

			// Stage 2 : split the list into two
			PointXY[][] doubleListPtXY = ParseTools.parselistpointXYen2(ptList);
			List<PointXY> ptList1 = new ArrayList<>(Arrays.asList(doubleListPtXY[0]));
			List<PointXY> ptList2 = new ArrayList<>(Arrays.asList(doubleListPtXY[1]));

			// Stage 3 : Average point1
			PointXY averagePt1 = MathTools.averagePoint(ptList1);

			// Stage 4 : Average point2
			PointXY averagePt2 = MathTools.averagePoint(ptList2);

			for (int j = 0; j < typeLine.length; j++) {

				// Stage 5 : determination line equation
				LineEquationTrend lET = new LineEquationTrend(this, typeBidOrAsk[i], typeLine[j], averagePt1,
						averagePt2, ptList);
				Thread t = new Thread(lET);
				t.start();

			}

			// Stage 6 : determination the last trend for bid and ask ( uptrend or
			// downTrend)

			if (ptList != null) {
				ListIterator<PointXY> iterator = ptList.listIterator(ptList.size());

				PointXY ptn0 = null; // ptn0 = the last point of list
				PointXY ptn = null; // ptn = the current point pt(n)study
				PointXY ptn1 = null; // ptn1 = the point pt(n+1) of list
				String checkTrend = null; // memorize the trend

				while (iterator.hasPrevious()) {
					ptn = iterator.previous();

					if (ptn0 == null) {
						ptn0 = ptn;
					}

					if (ptn1 != null) {
						
						System.out.println("ptnY : " + ptn.getY() + " , ptn1Y : " + ptn1.getY() + " , soustract : "
								+ (ptn1.getY() - ptn.getY()));

						if ((ptn1.getY() - ptn.getY()) > 0 && (checkTrend == null || "up".equals(checkTrend))) {
							checkTrend = "up";

							System.out.println("test1");
							ptn1 = ptn;

						} else if ((ptn1.getY() - ptn.getY()) < 0
								&& (checkTrend == null || "down".equals(checkTrend))) {
							checkTrend = "down";
							System.out.println("test2");
							ptn1 = ptn;

						} else if ((ptn1.getY() - ptn.getY()) == 0) {

							// incompatible value, redo a ride
							System.out.println("test3");
							ptn1 = ptn;
						} else {

							System.out.println("test4");
							LastTrend lt = new LastTrend(this, ptn0, ptn1, checkTrend,typeBidOrAsk[i]);
							// leave the loop
							break;
						}


					} else {
						ptn1 = ptn;
					}

				}
			}
		}

		
		
		// Stage 7 : control as every operation is finished and save trendcalculation in
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
		System.out.println("TREND CALCULATION terminé ///////////////////////////////////////////");

	}
}
