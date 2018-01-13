package fr.afgj.coinbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afgj.coinbot.entity.UserConfiguration;
import fr.afgj.coinbot.repository.UserConfigurationRepository;
import fr.afgj.coinbot.service.IUserConfigurationService;

@Service
public class UserConfigurationServiceImpl implements IUserConfigurationService {
	
	@Autowired
	private UserConfigurationRepository userConfigurationRepository;

	@Override
	public UserConfiguration findById(int idUser) {
		// TODO Auto-generated method stub
		return userConfigurationRepository.findById(idUser);
	}
	
	
	
	
}
