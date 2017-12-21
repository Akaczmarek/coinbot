package fr.afgj.coinbot.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class OrderHistoryBot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	
	private int id;
	@Column
	private Timestamp timeStampSend;
	@Column
	private Timestamp timeStampActivated;
	@Column
	private Timestamp timeStampCancelled;
	@Column
	private Timestamp timeStampFinished;
	@Column
	private double currencyValue ;
	@Column
	private double volume;
	@Column
	private double gainBTC;
	private int id_user;
	private int id_currency;
	private int id_OrderType;
	public OrderHistoryBot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getTimeStampSend() {
		return timeStampSend;
	}
	public void setTimeStampSend(Timestamp timeStampSend) {
		this.timeStampSend = timeStampSend;
	}
	public Timestamp getTimeStampActivated() {
		return timeStampActivated;
	}
	public void setTimeStampActivated(Timestamp timeStampActivated) {
		this.timeStampActivated = timeStampActivated;
	}
	public Timestamp getTimeStampCancelled() {
		return timeStampCancelled;
	}
	public void setTimeStampCancelled(Timestamp timeStampCancelled) {
		this.timeStampCancelled = timeStampCancelled;
	}
	public Timestamp getTimeStampFinished() {
		return timeStampFinished;
	}
	public void setTimeStampFinished(Timestamp timeStampFinished) {
		this.timeStampFinished = timeStampFinished;
	}
	public double getCurrencyValue() {
		return currencyValue;
	}
	public void setCurrencyValue(double currencyValue) {
		this.currencyValue = currencyValue;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getGainBTC() {
		return gainBTC;
	}
	public void setGainBTC(double gainBTC) {
		this.gainBTC = gainBTC;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_currency() {
		return id_currency;
	}
	public void setId_currency(int id_currency) {
		this.id_currency = id_currency;
	}
	public int getId_OrderType() {
		return id_OrderType;
	}
	public void setId_OrderType(int id_OrderType) {
		this.id_OrderType = id_OrderType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
