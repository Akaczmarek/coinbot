package fr.afgj.coinbot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.User;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
// collectionResourceRel = liens vers la table de la base "user"
// path= chemin dans l'url user
// l'url qui permet d'accéder donc à cette entité "user" sera donc, dans le
// cadre d'un serveur local,
// http://localhost:8080/api/user

public interface UserRepository extends JpaRepository<User, Integer>, Serializable {

	public List<User> findByLastname(@Param("lastname") String lastname);

	@Query("select  u from User u left join u.userconfiguration uc where uc.betvalue>0")
	public List<User> findByPositiveBetValue();

	// @Query("select u from User u JOIN(select oh.user ,
	// max(oh.timestampactivated)" + "from OrderHistoryBot oh "
	// + "group by oh.user)ohs on u.id = ohs.user left join UserConfiguration uc on
	// u.id = uc.id "
	// + "where uc.betvalue>0")
	// public List<User> findByPositiveBetValueAndLastDateOrderToBuy();
	//
	// @Query("select u from User u JOIN(select oh.user ,
	// max(oh.timestampactivated)" + "from OrderHistoryBot oh "
	// + "group by oh.user)ohs on u.id = ohs.user left join UserConfiguration uc on
	// u.id = uc.id "
	// + "where uc.betvalue>0")
	// public List<User> findByLastDateOrderToBuy();

	// select * from public.user u
	// inner join (select id_user , max(timestampactivated) as maxdate
	// from public.orderhistorybot oh
	// group by id_user)ohs
	// on u.id = ohs.id_user
	// left join public.userconfiguration uc
	// on u.id = uc.id
	// where uc.betvalue>0

}
