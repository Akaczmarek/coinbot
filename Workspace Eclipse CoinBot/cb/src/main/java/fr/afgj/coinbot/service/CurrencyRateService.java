package fr.afgj.coinbot.service;

import java.util.Date;
import java.util.List;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;

public interface CurrencyRateService {

	public void deleteCurrencyRate(CurrencyRate crr);

	public CurrencyRate saveCurrencyRate(CurrencyRate crr);

	public List<CurrencyRate> currenciesRates();

	public List<CurrencyRate> currencyRatesByCurrency(Currency cr);

	public List<CurrencyRate> findByDatesAndCurrency(Date startDate, Date endDate, int idcr);

	public List<CurrencyRate> findByDates(Date startDate, Date endDate);

}
