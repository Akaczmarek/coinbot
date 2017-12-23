package fr.afgj.coinbot.test.calculation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.repository.CurrencyRepository;

public class InsertMock {

	private static final Logger log = LogManager.getLogger();

	@Bean
	public CommandLineRunner saveMockCurrency(CurrencyRepository repository) {
		return (args) -> {


			
			repository.save(new Currency(1, "mock currency 1", "mck1", false, 10000, 0.01, 0.02, 30.0));

		};
	}

}
