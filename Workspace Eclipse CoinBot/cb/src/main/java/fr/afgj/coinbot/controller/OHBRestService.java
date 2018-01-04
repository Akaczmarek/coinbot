package fr.afgj.coinbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.afgj.coinbot.repository.OrderHistoryBotRepository;

@CrossOrigin
@RestController
public class OHBRestService {

	@Autowired
	private OrderHistoryBotRepository orderHistoryBotRepository;

	@ResponseBody
	@RequestMapping(value = "api/ohbbyuser/{id}", method = RequestMethod.GET)
	public String ohblist(@PathVariable int id) {
		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(orderHistoryBotRepository.findOHBByIdUser(id));
	}

	@ResponseBody
	@RequestMapping(value = "api/ohbbyuser/{id}/activebids", method = RequestMethod.GET)
	public String ohbActiveList(@PathVariable int id) {
		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(orderHistoryBotRepository.findActiveList(id));
	}

	@ResponseBody
	@RequestMapping(value = "api/ohbbyuser/{idOrder}", method = RequestMethod.DELETE)
	public boolean deleteOrder(@PathVariable int idOrder) {
		this.orderHistoryBotRepository.delete(idOrder);
		return true;
	}

}
