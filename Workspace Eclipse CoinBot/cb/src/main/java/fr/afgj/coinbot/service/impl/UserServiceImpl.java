package fr.afgj.coinbot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.repository.UserRepository;
import fr.afgj.coinbot.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
