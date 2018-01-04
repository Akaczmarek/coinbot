package fr.afgj.coinbot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.Currency;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "currency", path = "currency")
public interface CurrencyRepository extends JpaRepository<Currency, Integer>, Serializable {

	public Currency findByName(String name);

	public boolean existsByName(String name);

	@Modifying
	@Query("UPDATE Currency cr SET cr.rank=:#{#currency.rank}, cr.volumeeur=:#{#currency.volumeeur}, cr.volumeusd=:#{#currency.volumeusd} WHERE cr.idcurrency=:#{#currency.idcurrency}")
	public void updateById(@Param("currency") Currency currency);

}
