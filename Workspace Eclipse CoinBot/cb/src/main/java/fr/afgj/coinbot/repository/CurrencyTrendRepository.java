package fr.afgj.coinbot.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.CurrencyTrend;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "currencyTrend", path = "ct")
public interface  CurrencyTrendRepository extends CrudRepository<CurrencyTrend, Integer>, Serializable{

}
