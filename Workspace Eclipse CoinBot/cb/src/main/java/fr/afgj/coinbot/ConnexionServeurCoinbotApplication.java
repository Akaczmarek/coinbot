package fr.afgj.coinbot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.repository.UserRepository;

@SpringBootApplication
public class ConnexionServeurCoinbotApplication {
	
	private static final Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		SpringApplication.run(ConnexionServeurCoinbotApplication.class, args);
		

	}
	
	

	
	
	
//	@Bean
//	public CommandLineRunner saveMockCurrency(CurrencyRepository repository) {
//		return (args) -> {
//
//
//			
//			repository.save(new Currency(2, "mock currency 2", "mck2", false, 10001, 0.02, 0.022, 32.0));
//			repository.save(new Currency(3, "mock currency 3", "mck3", false, 10002, 0.03, 0.033, 33.0));
//			repository.save(new Currency(4, "mock currency 4", "mck4", false, 10003, 0.04, 0.044, 34.0));
//			repository.save(new Currency(5, "mock currency 5", "mck5", false, 10004, 0.05, 0.055, 35.0));
//			repository.save(new Currency(6, "mock currency 6", "mck6", false, 10005, 0.06, 0.066, 36.0));
//
//		};
//	}
	
	
	
	
	
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of users
			//repository.save(new User("francois", "l'embrouille", "fe", "francois@embrouille.com", "123", null, null, null));

			
			// fetch all users
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
				System.out.println(user.getId() + " " + user.getFirstname() + " " + user.getLastname());
			}
			

			log.info("");
			
			
			//System.out.println(log.toString());

			// fetch an individual user by ID
			/*
			User user = repository.findOne(5);
			log.info("User found with findOne(1L):");
			log.info("--------------------------------");
			log.info(user.toString());
			log.info("");
			*/

			// fetch users by last name
			/*
			log.info("User found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (User bauer : repository.findByLastname("l'embrouille")) {
				log.info(bauer.toString());
			}
			
			
			log.info("");
			*/
		};
	}
	
}
