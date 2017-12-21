package fr.afgj.coinbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/list")
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
}
