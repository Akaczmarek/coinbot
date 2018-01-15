package fr.afgj.coinbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afgj.coinbot.entity.ApiKey;
import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.repository.ApiKeyRepository;
import fr.afgj.coinbot.service.IApiKeyService;

@Service
public class ApiKeyServiceImpl implements IApiKeyService {

	@Autowired
	ApiKeyRepository apiKeyRepository;
	
	public ApiKey findByUser(User user) {
		return apiKeyRepository.findOne(user.getId());
	}
}
