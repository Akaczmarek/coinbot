package fr.afgj.coinbot.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "currencyRate", path = "cr")
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Integer>, Serializable {

	public List<CurrencyRate> findByCurrency(@Param("currency") Currency currency);

	@Query("select cr from CurrencyRate cr where cr.timerecord between :date0 and :date1 and cr.currency.id=:idcr")
	public List<CurrencyRate> findByDatesAndCurrency(@Param("date0") Date startDate, @Param("date1") Date endDate,
			@Param("idcr") int idcr);

	@Query("select cr from CurrencyRate cr where cr.timerecord between :date0 and :date1 ")
	public List<CurrencyRate> findByDates(@Param("date0") Date startDate, @Param("date1") Date endDate);

}
