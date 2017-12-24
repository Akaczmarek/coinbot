package fr.afgj.coinbot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.Currency;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "currency", path = "currency")
public interface CurrencyRepository extends JpaRepository<Currency, Integer>, Serializable {

}
