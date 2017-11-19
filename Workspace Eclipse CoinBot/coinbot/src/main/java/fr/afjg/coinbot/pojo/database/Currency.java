package fr.afjg.coinbot.pojo.database;

public abstract class Currency {

	private int idcurrency;
	private String currencyName;
	private String currencyCode;
	private boolean currencyRef;
	
	public Currency() {
		
	}

	public int getIdcurrency() {
		return idcurrency;
	}

	public void setIdcurrency(int idcurrency) {
		this.idcurrency = idcurrency;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public boolean isCurrencyRef() {
		return currencyRef;
	}

	public void setCurrencyRef(boolean currencyRef) {
		this.currencyRef = currencyRef;
	}
	
	
	
	
}
