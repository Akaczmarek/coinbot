package fr.afgj.coinbot.service;

import org.springframework.data.repository.query.Param;

import fr.afgj.coinbot.entity.UserConfiguration;

public interface UserConfigurationService {

	public UserConfiguration findById(int idUser);

}
