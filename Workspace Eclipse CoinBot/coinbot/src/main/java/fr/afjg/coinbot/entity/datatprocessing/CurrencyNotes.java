package fr.afjg.coinbot.entity.datatprocessing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.afjg.coinbot.pojo.database.CurrencyRate;
import fr.afjg.coinbot.util.ParseTools;

public class CurrencyNotes {

	private CurrencyTrend currencyTrend;
	private volatile List<CurrencyNote> currencyNotesToSell;
	private volatile List<CurrencyNote> currencyNotesToBuy;
	private volatile int countFinishedActions;

	public CurrencyNotes(CurrencyTrend currencyTrend) {
		this.setCurrencyTrend(currencyTrend);
		listOfOperations();

	}

	// getters &
	// setters---------------------------------------------------------------

	public CurrencyTrend getCurrencyTrend() {
		return currencyTrend;
	}

	public void setCurrencyTrend(CurrencyTrend currencyTrend) {
		this.currencyTrend = currencyTrend;
	}



	public List<CurrencyNote> getCurrencyNotesToSell() {
		return currencyNotesToSell;
	}

	public void setCurrencyNotesToSell(List<CurrencyNote> currencyNotesToSell) {
		this.currencyNotesToSell = currencyNotesToSell;
	}

	public List<CurrencyNote> getCurrencyNotesToBuy() {
		return currencyNotesToBuy;
	}

	public void setCurrencyNotesToBuy(List<CurrencyNote> currencyNotesToBuy) {
		this.currencyNotesToBuy = currencyNotesToBuy;
	}

	public int getCountFinishedActions() {
		return countFinishedActions;
	}

	public synchronized void setCountFinishedActions(int countFinishedActions) {
		this.countFinishedActions = countFinishedActions;
	}

	// methods------------------------------------------------------------

	public synchronized void finishActionsChecked() {
		this.setCountFinishedActions(getCountFinishedActions() + 1);
	}

	public void listOfOperations() {

		// Stage 0 : variables initialization
		int numberOperation = 0;

		// stage 1 :recovery the list of calculation
		List<TrendCalculation> tcs = new ArrayList<>(this.getCurrencyTrend().getTrendCalculs());

		Iterator<TrendCalculation> ite = tcs.iterator();

		while (ite.hasNext()) {
			TrendCalculation tc = ite.next();

			// preparation and recovery informations behind calculation note

			// stage 3 : treatment line Equation

			// stage 3.1 : recovery the list of equation
			List<LineEquationTrend> lets = tc.getLinesEquationsTrends();

			Iterator<LineEquationTrend> iteLETS = lets.iterator();

			// stage 3.2 :data storage specific to bid or ask into two list line equation
			List<LineEquationTrend> letsBid = new ArrayList<>();
			List<LineEquationTrend> letsAsk = new ArrayList<>();

			while (iteLETS.hasNext()) {
				LineEquationTrend let = iteLETS.next();

				// note for type of trend (bid => value to sell or ask=> value to buy)
				if ("bid".equals(let.getTypeBidOrAsk())) {
					letsBid.add(let);

				} else if ("ask".equals(let.getTypeBidOrAsk())) {
					letsAsk.add(let);
				}

			}

			// stage 4 : treatment last trend

			// stage 3.1 : recovery the list of last trend
			List<LastTrend> lts = tc.getLastTrends();

			Iterator<LastTrend> iteLTS = lts.iterator();

			// Stage 4.2 :data storage specific to bid or ask into two last Trend
			LastTrend ltBid;
			LastTrend ltAsk;

			while (iteLTS.hasNext()) {
				LastTrend lt = iteLTS.next();

				// note for type of trend (bid => value to sell or ask=> value to buy)
				if ("bid".equals(lt.getTypeBidOrAsk())) {
					ltBid= lt;

				} else if ("ask".equals(lt.getTypeBidOrAsk())) {
					ltAsk=lt;
				}

			}

			// stage 5 : treatment on last point (the youngest point)
			List<CurrencyRate> listCR = getCurrencyTrend().getCurrencyRates();
			CurrencyRate lastCR = listCR.get(listCR.size() - 1);
			PointXY lastPointBid = ParseTools.parseOneCurrencyRateInPointXY(lastCR, "bid");
			PointXY lastPointAsk = ParseTools.parseOneCurrencyRateInPointXY(lastCR, "ask");

			// stage 6 : information of associate trendrule
			TrendRule trendRule = tc.getTrendRule();
			


			// send data to currencyNote
			CurrencyNote crBid = new CurrencyNote(this, letsBid, ltsBid, lastPointBid, trendRule, "bid");
			Thread t = new Thread(crBid);
			t.start();

			CurrencyNote crAsk = new CurrencyNote(this, letsAsk, ltsAsk, lastPointAsk, trendRule, "ask");
			Thread t1 = new Thread(crAsk);
			t1.start();

			numberOperation += 2;

		}

		// Stage 7 : control as every operation of notation is finished and begin

		while (true) {
			if (this.getCountFinishedActions() == numberOperation) {
				this.setCountFinishedActions(0);
				break;
			}
		}


	}

}
