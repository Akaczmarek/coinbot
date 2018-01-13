package fr.afgj.coinbot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afgj.coinbot.entity.OrderHistoryBot;
import fr.afgj.coinbot.repository.OrderHistoryBotRepository;
import fr.afgj.coinbot.service.IOrderHistoryBotService;

@Service
public class OrderHistoryBotServiceImpl implements IOrderHistoryBotService {

	@Autowired
	private OrderHistoryBotRepository orderHistoryBotRepository;

	@Override
	public List<OrderHistoryBot> findOHBByIdUser(int id_user) {
		return orderHistoryBotRepository.findOHBByIdUser(id_user);
	}

	@Override
	public List<OrderHistoryBot> findLastOrderToBuyByUser() {
		// TODO Auto-generated method stub
		return orderHistoryBotRepository.findLastOrderToBuyByUser();
	}

}
