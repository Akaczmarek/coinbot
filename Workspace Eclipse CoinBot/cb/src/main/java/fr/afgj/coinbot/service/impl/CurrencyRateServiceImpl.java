package fr.afgj.coinbot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.repository.CurrencyRateRepository;
import fr.afgj.coinbot.service.CurrencyRateService;

@Service
public class CurrencyRateServiceImpl implements CurrencyRateService{

	@Autowired
	private CurrencyRateRepository currencyRateRepository;

	@Override
	public void deleteCurrencyRate(CurrencyRate crr) {
		// TODO Auto-generated method stub
		currencyRateRepository.delete(crr);
	}

	@Override
	public CurrencyRate saveCurrencyRate(CurrencyRate crr) {
		// TODO Auto-generated method stub
		return currencyRateRepository.save(crr);
	}

	@Override
	public List<CurrencyRate> currenciesRates() {
		// TODO Auto-generated method stub
		return currencyRateRepository.findAll();
	}

	@Override
	public List<CurrencyRate> currencyRateByCurrency(Currency cr) {
		// TODO Auto-generated method stub
		return currencyRateRepository.findByCurrency(cr);
	}



	

}
