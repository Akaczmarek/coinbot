package fr.afjg.coinbot.pojo.database;

import java.sql.Timestamp;

public class CurrencyRate extends Currency{

	private Timestamp timeRecord;
	private double bidBTC;
	private double askBTC;
	private double bidUSD;
	private double askUSD;
	private double bidEUR;
	private double askEUR;
	private double currencyVolume;
	private CurrencyREF ref;
	

	public CurrencyRate() {
		ref= CurrencyREF.getInstance();
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

	public void setAskBTC(double askBTC) {
		this.askBTC = askBTC;
	}

	
	public double getCurrencyVolume() {
		return currencyVolume;
	}

	public void setCurrencyVolume(double currencyVolume) {
		this.currencyVolume = currencyVolume;
	}
/*
 * Methods------------------------------------------------------------------	
 */
	


	public void calcbidUSD() {
		double bidBTC = this.getBidBTC();
		double refUSD = ref.getBidUSD();
		this.setBidUSD(refUSD*bidBTC);
	}
	public void calcAskUSD() {
		double askBTC = this.getAskBTC();
		double refUSD = ref.getAskUSD();
		this.setBidUSD(refUSD*askBTC);
	}
	
	public void calcbidEUR() {
		double bidBTC = this.getBidBTC();
		double refEUR = ref.getBidEUR();
		this.setBidEUR(refEUR*bidBTC);
		
	}
	public void calcAskEUR() {
		double askBTC = this.getAskBTC();
		double refEUR = ref.getAskEUR();
		this.setBidEUR(refEUR*askBTC);
	}

}
