package fr.afgj.coinbot.service;

import java.util.List;

import fr.afgj.coinbot.entity.OrderHistoryBot;

public interface IOrderHistoryBotService {

	public List<OrderHistoryBot> findOHBByIdUser(int id_user);

	public List<OrderHistoryBot> findLastOrderToBuyByUser();

}
