package fr.afgj.coinbot.service;

import java.util.List;

import fr.afgj.coinbot.entity.User;

public interface UserService {

	public List<User> findAllUsers();

	public List<User> findByPositiveBetValue();

	public List<User> findByPositiveBetValueAndLastDateOrderToBuy();

}
