package fr.afgj.coinbot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserConfiguration implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5987441232497069410L;
	@Id
	private int idUser;
	@Column
	private double betValue;
	@Column
	private double secureValue;
	@Column
	private int riskLevel;
	@Column
	private boolean stopBotAfter;
	@Column
	private boolean stopBot;
	@Column
	private int daysOrdersBloqued;
	@Column
	private int daysOneOrderBloqued;

	public UserConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public double getBetValue() {
		return betValue;
	}
	public void setBetValue(double betValue) {
		this.betValue = betValue;
	}
	public double getSecureValue() {
		return secureValue;
	}
	public void setSecureValue(double secureValue) {
		this.secureValue = secureValue;
	}
	public int getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}
	public boolean isStopBotAfter() {
		return stopBotAfter;
	}
	public void setStopBotAfter(boolean stopBotAfter) {
		this.stopBotAfter = stopBotAfter;
	}
	public boolean isStopBot() {
		return stopBot;
	}
	public void setStopBot(boolean stopBot) {
		this.stopBot = stopBot;
	}
	public int getDaysOrdersBloqued() {
		return daysOrdersBloqued;
	}
	public void setDaysOrdersBloqued(int daysOrdersBloqued) {
		this.daysOrdersBloqued = daysOrdersBloqued;
	}
	public int getDaysOneOrderBloqued() {
		return daysOneOrderBloqued;
	}
	public void setDaysOneOrderBloqued(int daysOneOrderBloqued) {
		this.daysOneOrderBloqued = daysOneOrderBloqued;
	}
	
	
	
	
}
