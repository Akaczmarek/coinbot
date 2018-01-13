package fr.afgj.coinbot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.afgj.coinbot.entity.ApiKey;
import fr.afgj.coinbot.entity.User;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "apiKey", path = "ak")
public  interface  ApiKeyRepository extends JpaRepository<ApiKey, Integer>, Serializable{

	public ApiKey findByUser(@Param("user") User user);

	
}
