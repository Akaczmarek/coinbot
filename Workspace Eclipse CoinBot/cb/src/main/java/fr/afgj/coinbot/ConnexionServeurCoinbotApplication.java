package fr.afgj.coinbot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.repository.CurrencyRepository;
import fr.afgj.coinbot.repository.UserRepository;
import fr.afgj.coinbot.test.calculation.InsertMock;

@SpringBootApplication
public class ConnexionServeurCoinbotApplication {
	
	private static final Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		SpringApplication.run(ConnexionServeurCoinbotApplication.class, args);
		
		//chargement mock
		
		
		InsertMock im = new InsertMock();

	}
	
	
	
	
	
	
	
	
	
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
