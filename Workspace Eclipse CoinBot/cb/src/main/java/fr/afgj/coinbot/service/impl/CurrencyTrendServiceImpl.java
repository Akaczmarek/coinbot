package fr.afgj.coinbot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyTrend;
import fr.afgj.coinbot.repository.CurrencyTrendRepository;
import fr.afgj.coinbot.service.CurrencyTrendService;

@Service
public class CurrencyTrendServiceImpl implements CurrencyTrendService {

	@Autowired
	private CurrencyTrendRepository currencyTrendRepository;
	
	@Override
	public void deleteCurrencyTrend(CurrencyTrend crt) {
		// TODO Auto-generated method stub
		currencyTrendRepository.delete(crt);
	}

	@Override
	public CurrencyTrend saveCurrencyTrend(CurrencyTrend crt) {
		// TODO Auto-generated method stub
		return currencyTrendRepository.save(crt);
	}

	@Override
	public List<CurrencyTrend> currenciesTrends() {
		// TODO Auto-generated method stub
		return currencyTrendRepository.findAll();
	}

	@Override
	public List<CurrencyTrend> currencyTrendsByCurrency(Currency cr) {
		// TODO Auto-generated method stub
		return currencyTrendRepository.findByCurrency(cr);
	}

}
