package fr.afgj.coinbot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyRate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	@Column
	private Timestamp timeRecord;
	@Column
	private double bidBtc;
	@Column
	private double askBtc;
	@Column
	private double bidUSD;
	@Column
	private double askUSD;
	@Column
	private double bidEUR;
	@Column
	private double askEUR;
	private int id_currency;
	public CurrencyRate() {
		super();
		// TODO Auto-generated constructor stub

	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getTimeRecord() {
		return timeRecord;
	}
	public void setTimeRecord(Timestamp timeRecord) {
		this.timeRecord = timeRecord;
	}
	public double getBidBtc() {
		return bidBtc;
	}
	public void setBidBtc(double bidBtc) {
		this.bidBtc = bidBtc;
	}
	public double getAskBtc() {
		return askBtc;
	}
	public void setAskBtc(double askBtc) {
		this.askBtc = askBtc;
	}
	public double getBidUSD() {
		return bidUSD;
	}
	public void setBidUSD(double bidUSD) {
		this.bidUSD = bidUSD;
	}
	public double getAskUSD() {
		return askUSD;
	}
	public void setAskUSD(double askUSD) {
		this.askUSD = askUSD;
	}
	public double getBidEUR() {
		return bidEUR;
	}
	public void setBidEUR(double bidEUR) {
		this.bidEUR = bidEUR;
	}
	public double getAskEUR() {
		return askEUR;
	}
	public void setAskEUR(double askEUR) {
		this.askEUR = askEUR;
	}
	public int getId_currency() {
		return id_currency;
	}
	public void setId_currency(int id_currency) {
		this.id_currency = id_currency;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
