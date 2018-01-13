package fr.afgj.coinbot.service;

import java.util.List;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.CurrencyTrend;

public interface ICurrencyTrendService {

	
	public void deleteCurrencyTrend(CurrencyTrend crt);
	public CurrencyTrend saveCurrencyTrend(CurrencyTrend crt);
	public List<CurrencyTrend> currenciesTrends();
	public List<CurrencyTrend> currencyTrendsByCurrency(Currency cr);
}
