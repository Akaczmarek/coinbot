package fr.afgj.coinbot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.repository.CurrencyRepository;
import fr.afgj.coinbot.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {
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

	
	
	







	
	

}
