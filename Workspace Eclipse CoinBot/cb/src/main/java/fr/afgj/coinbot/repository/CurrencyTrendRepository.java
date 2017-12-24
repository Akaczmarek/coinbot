package fr.afgj.coinbot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.CurrencyTrend;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "currencyTrend", path = "ct")
public interface  CurrencyTrendRepository extends JpaRepository<CurrencyTrend, Integer>, Serializable{

	
	List<CurrencyTrend> findByCurrency(@Param("currency") Currency currency);
}
