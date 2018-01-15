package fr.afgj.coinbot.service;

import fr.afgj.coinbot.entity.ApiKey;
import fr.afgj.coinbot.entity.User;

public interface IApiKeyService {
	
	public ApiKey findByUser(User user);
}