package fr.afgj.coinbot.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.UserConfiguration;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "userconfig", path = "userconfig")

public interface UserConfigurationRepository extends CrudRepository<UserConfiguration, Integer>, Serializable{

}
