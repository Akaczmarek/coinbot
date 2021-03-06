package fr.afgj.coinbot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.OrderHistoryBot;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "orderHistoryBot", path = "ohb")
public interface OrderHistoryBotRepository extends CrudRepository<OrderHistoryBot, Integer>, Serializable {

	@Query("from OrderHistoryBot ohb where ohb.user.id = :iduser ")
	List<OrderHistoryBot> findOHBByIdUser(@Param("iduser") int iduser);

	@Query("from OrderHistoryBot ohb where (ohb.user.id = :iduser and ohb.timestampcancelled= null and ohb.timestampfinished= null) ")
	List<OrderHistoryBot> findActiveList(@Param("iduser") int iduser);

	@Query("select oh from OrderHistoryBot oh where oh.ordertype.id = 1 and timestampactivated in ("
			+ " select max(oh1.timestampactivated) from OrderHistoryBot oh1 group by oh1.user.id)")
	List<OrderHistoryBot> findLastOrderToBuyByUser();

	// select *
	// from public.orderhistorybot
	// where timestampactivated in (
	// select max(timestampactivated)
	// from public.orderhistorybot
	// group by id_user
	// ) and id_ordertype = 1;

}
