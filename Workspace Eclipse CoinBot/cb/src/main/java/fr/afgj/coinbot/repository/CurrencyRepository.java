package fr.afgj.coinbot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.User;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "currency", path = "currency")
public interface CurrencyRepository extends JpaRepository<Currency, Integer>, Serializable {

	@Query("SELECT COUNT(*) FROM Currency cr WHERE cr.name = :name")
	public Integer existByName(@Param("name") String name);
	
	@Query("UPDATE Currency cr SET cr.symbol=:symbol, cr.rank=:rank, cr.volumeeur=:volumeeur, cr.volumeusd=:volumeusd")
	public Boolean updateByName(@Param("symbol") String symbol, @Param("rank") int rank, @Param("volumeeur") Double volumeeur, @ Param("volumeusd") Double volumeusd);
	
}
