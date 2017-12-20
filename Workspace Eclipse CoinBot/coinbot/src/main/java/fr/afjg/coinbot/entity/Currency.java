package fr.afjg.coinbot.entity;

public abstract class Currency {

	private int id;
	private String name;
	private String symbol;
	private int rank;
	private double volumeEUR;
	private double volumeUSD;
	private boolean refCurrency;

	public Currency() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getVolumeEUR() {
		return volumeEUR;
	}

	public void setVolumeEUR(double volumeEUR) {
		this.volumeEUR = volumeEUR;
	}

	public double getVolumeUSD() {
		return volumeUSD;
	}

	public void setVolumeUSD(double volumeUSD) {
		this.volumeUSD = volumeUSD;
	}

	public boolean isRefCurrency() {
		return refCurrency;
	}

	public void setRefCurrency(boolean refCurrency) {
		this.refCurrency = refCurrency;
	}

}