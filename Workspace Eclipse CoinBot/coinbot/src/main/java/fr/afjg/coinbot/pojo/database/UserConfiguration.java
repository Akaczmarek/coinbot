package fr.afjg.coinbot.pojo.database;

public class UserConfiguration {
	
	private double betValue;
	private double secureValue;
	private int riskLevel;
	private boolean stopBotAfter;
	private boolean stopBot;
	private int daysOrdersBloqued;
	private int daysOneOrderBloqued;
	private User user;
	
	public UserConfiguration() {
		
	}
	
	// getter & setters-------------------------------------------------------------

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	
	
	
	
	
}
