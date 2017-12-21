package fr.afgj.coinbot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Currency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6961293161194500599L;
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String symbol;
	@Column
	private boolean refCurrency;
	@Column
	private int rank;
	@Column
	private double volumeEUR;
	@Column
	private double volumeUSD;
	@Column
	private double humanNote;
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
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
	public boolean isRefCurrency() {
		return refCurrency;
	}
	public void setRefCurrency(boolean refCurrency) {
		this.refCurrency = refCurrency;
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
	public double getHumanNote() {
		return humanNote;
	}
	public void setHumanNote(double humanNote) {
		this.humanNote = humanNote;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
