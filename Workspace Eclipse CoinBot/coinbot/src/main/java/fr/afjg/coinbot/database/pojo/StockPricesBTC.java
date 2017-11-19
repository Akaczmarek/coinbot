package fr.afjg.coinbot.database.pojo;

import java.sql.Timestamp;

import fr.afjg.coinbot.database.exceptions.CryptoVolumeException;

public class StockPricesBTC {

	private int idCrypto;
	private String cryptoName;
	private String cryptoCode;
	private Timestamp infoTimeStamp;
	private double bidBTC;
	private double askBTC;
	private double cryptoVolume;
	
	public StockPricesBTC() {
		
	}

	public int getIdCrypto() {
		return idCrypto;
	}

	public void setIdCrypto(int idCrypto) {
		this.idCrypto = idCrypto;
	}

	public String getCryptoName() {
		return cryptoName;
	}

	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}

	public String getCryptoCode() {
		return cryptoCode;
	}

	public void setCryptoCode(String cryptoCode) {
		this.cryptoCode = cryptoCode;
	}

	public Timestamp getInfoTimeStamp() {
		return infoTimeStamp;
	}

	public void setInfoTimeStamp(Timestamp infoTimeStamp) {
		this.infoTimeStamp = infoTimeStamp;
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

	public double getCryptoVolume() {
		return cryptoVolume;
	}

	public void setCryptoVolume(double cryptoVolume) {
		if (cryptoVolume<0) throw new CryptoVolumeException("une crypto ne peut pas avoir un volume inf�rieur � 0");
		this.cryptoVolume = cryptoVolume;
	}
	
	
	
}
