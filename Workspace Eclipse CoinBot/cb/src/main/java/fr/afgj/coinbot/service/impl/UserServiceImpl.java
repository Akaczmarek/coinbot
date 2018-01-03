package fr.afgj.coinbot.service.impl;

import java.util.List;

import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.repository.UserRepository;
import fr.afgj.coinbot.service.UserService;

public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
