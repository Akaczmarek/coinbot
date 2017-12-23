package fr.afgj.coinbot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "currencyRate", path = "cr")
public interface CurrencyRateRepository extends CrudRepository<CurrencyRate, Integer>, Serializable{
	
	List<CurrencyRate> findByCurrency(@Param("currency") Currency currency);

}
