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

	@Override
	public Boolean existByName(String name) {
		// TODO Auto-generated method stub
		if(currencyRepository.existByName(name) >=1) {
			return true;
		}
		return false;
	}

	@Override
	public void updateByName(Currency currency) {
		// TODO Auto-generated method stub
		currencyRepository.updateByName(currency.getSymbol(), currency.getRank(), currency.getVolumeeur(), currency.getVolumeusd());
		
	}

	
	
	







	
	

}
