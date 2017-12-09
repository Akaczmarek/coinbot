package fr.afjg.coinbot.entity.datatprocessing;

import java.util.List;

public class CurrencyNote {

	private String typeBidOrAsk; // "bid" or "ask"
	private CurrencyNotes currencyNotes;
	private List<LineEquationTrend> lets;
	private List<LastTrend> lts;
	private PointXY lastPoint;

	public CurrencyNote(CurrencyNotes currencyNotes, List<LineEquationTrend> lets, List<LastTrend> lts,
			PointXY lastPoint) {
		this.setCurrencyNotes(currencyNotes);
		this.setLets(lets);
		this.setLts(lts);
		this.setLastPoint(lastPoint);
		this.setTypeBidOrAsk(typeBidOrAsk);
	}

	public String getTypeBidOrAsk() {
		return typeBidOrAsk;
	}

	public void setTypeBidOrAsk(String typeBidOrAsk) {
		this.typeBidOrAsk = typeBidOrAsk;
	}

	public CurrencyNotes getCurrencyNotes() {
		return currencyNotes;
	}

	public void setCurrencyNotes(CurrencyNotes currencyNotes) {
		this.currencyNotes = currencyNotes;
	}

	public List<LineEquationTrend> getLets() {
		return lets;
	}

	public void setLets(List<LineEquationTrend> lets) {
		this.lets = lets;
	}

	public List<LastTrend> getLts() {
		return lts;
	}

	public void setLts(List<LastTrend> lts) {
		this.lts = lts;
	}

	public PointXY getLastPoint() {
		return lastPoint;
	}

	public void setLastPoint(PointXY lastPoint) {
		this.lastPoint = lastPoint;
	}

}
