package fr.afgj.coinbot.service;

import java.util.List;

import fr.afgj.coinbot.entity.Currency;

public interface CurrencyService {
	
	public void deleteCurrency(Currency cr);
	public Currency saveCurrency(Currency cr);
	public List<Currency> currencies();
	public Boolean existByName(String name);
	public void updateByName(Currency currency);

}
