package fr.afgj.coinbot.service;

import java.util.List;

import fr.afgj.coinbot.entity.Currency;

public interface ICurrencyService {

	public void deleteCurrency(Currency cr);

	public Currency saveCurrency(Currency cr);

	public List<Currency> currencies();

	public Boolean existsByName(String name);

	public Currency findByName(String name);

	public void updateById(Currency currency);

}
