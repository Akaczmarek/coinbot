package fr.afgj.coinbot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.repository.CurrencyRepository;
import fr.afgj.coinbot.service.ICurrencyService;

@Service
public class CurrencyServiceImpl implements ICurrencyService {
	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public Currency saveCurrency(Currency cr) {
		// TODO Auto-generated method stub
		return currencyRepository.save(cr);
	}

	@Override
	public List<Currency> currencies() {
		// TODO Auto-generated method stub
		return currencyRepository.findAll();
	}

	@Override
	public void deleteCurrency(Currency cr) {
		// TODO Auto-generated method stub
		currencyRepository.delete(cr);
	}

	@Override
	public Boolean existsByName(String name) {
		// TODO Auto-generated method stub
		return currencyRepository.existsByName(name);
	}

	@Override
	public Currency findByName(String name) {
		// TODO Auto-generated method stub
		return currencyRepository.findByName(name);
	}

	@Override
	@Transactional
	public void updateById(Currency currency) {
		// TODO Auto-generated method stub
		currencyRepository.updateById(currency);
	}

}
