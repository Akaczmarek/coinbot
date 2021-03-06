package fr.afgj.coinbot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.repository.UserRepository;
import fr.afgj.coinbot.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<User> findByPositiveBetValue() {
		// TODO Auto-generated method stub
		return userRepository.findByPositiveBetValue();
	}

}
