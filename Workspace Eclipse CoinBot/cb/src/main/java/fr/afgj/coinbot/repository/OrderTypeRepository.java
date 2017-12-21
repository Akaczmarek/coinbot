package fr.afgj.coinbot.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.OrderType;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "OrderType", path = "ot")

public interface OrderTypeRepository extends CrudRepository<OrderType, Integer>, Serializable{

}
