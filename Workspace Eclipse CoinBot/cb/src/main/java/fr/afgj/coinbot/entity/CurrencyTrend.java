package fr.afgj.coinbot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class CurrencyTrend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	@Column
	private boolean lastTrendGrowing;
	@Column
	private int lastTrendWeight;
	@Column
	private Timestamp timeRecord;
	@Column
	private double noteToBuy;
	@Column
	private double noteToSell;
	@Column
	private double valueBidBTC;
	@Column
	private double valueAskBTC;
	private double id_currency;
	public CurrencyTrend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isLastTrendGrowing() {
		return lastTrendGrowing;
	}
	public void setLastTrendGrowing(boolean lastTrendGrowing) {
		this.lastTrendGrowing = lastTrendGrowing;
	}
	public int getLastTrendWeight() {
		return lastTrendWeight;
	}
	public void setLastTrendWeight(int lastTrendWeight) {
		this.lastTrendWeight = lastTrendWeight;
	}
	public Timestamp getTimeRecord() {
		return timeRecord;
	}
	public void setTimeRecord(Timestamp timeRecord) {
		this.timeRecord = timeRecord;
	}
	public double getNoteToBuy() {
		return noteToBuy;
	}
	public void setNoteToBuy(double noteToBuy) {
		this.noteToBuy = noteToBuy;
	}
	public double getNoteToSell() {
		return noteToSell;
	}
	public void setNoteToSell(double noteToSell) {
		this.noteToSell = noteToSell;
	}
	public double getValueBidBTC() {
		return valueBidBTC;
	}
	public void setValueBidBTC(double valueBidBTC) {
		this.valueBidBTC = valueBidBTC;
	}
	public double getValueAskBTC() {
		return valueAskBTC;
	}
	public void setValueAskBTC(double valueAskBTC) {
		this.valueAskBTC = valueAskBTC;
	}
	public double getId_currency() {
		return id_currency;
	}
	public void setId_currency(double id_currency) {
		this.id_currency = id_currency;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
