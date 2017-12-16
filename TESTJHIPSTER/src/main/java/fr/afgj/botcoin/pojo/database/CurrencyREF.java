package fr.afjg.coinbot.pojo.database;

import java.sql.Timestamp;

public class CurrencyREF {

	private Timestamp timeRecord;
	private double bidBTC;
	private double askBTC;
	private double bidUSD;
	private double askUSD;
	private double bidEUR;
	private double askEUR;
	private double currencyVolume;

	/*
	 * private constructor
	 */
	private CurrencyREF() {

	}

	/** Holder */
	private static class SingletonHolder {
		/*
		 * Instance unique non préinitialisée
		 */
		private final static CurrencyREF instance = new CurrencyREF();
	}

	/*
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static CurrencyREF getInstance() {
		return SingletonHolder.instance;
	}
	
	/*
	 * getters - Setters -------------------------------------------------------------
	 */

	public Timestamp getTimeRecord() {
		return timeRecord;
	}

	public void setTimeRecord(Timestamp timeRecord) {
		this.timeRecord = timeRecord;
	}

	public double getBidBTC() {
		return bidBTC;
	}

	public void setBidBTC(double bidBTC) {
		this.bidBTC = bidBTC;
	}

	public double getAskBTC() {
		return askBTC;
	}

	public void setAskBTC(double askBTC) {
		this.askBTC = askBTC;
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

	public double getCurrencyVolume() {
		return currencyVolume;
	}

	public void setCurrencyVolume(double currencyVolume) {
		this.currencyVolume = currencyVolume;
	}
	
	
	
	
	

}
