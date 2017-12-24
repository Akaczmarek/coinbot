package fr.afgj.coinbot;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.repository.CurrencyRateRepository;
import fr.afgj.coinbot.repository.CurrencyRepository;
import fr.afgj.coinbot.repository.UserRepository;

@SpringBootApplication

public class ConnexionServeurCoinbotApplication {

	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ConnexionServeurCoinbotApplication.class, args);
		CurrencyRepository currencyRep = ctx.getBean(CurrencyRepository.class);
		CurrencyRateRepository currencyRateRep = ctx.getBean(CurrencyRateRepository.class);
		
		Currency cr = currencyRep.findOne(1);
		
		System.out.println("currency trouvé" + cr.getName() +  " (id = " + cr.getIdcurrency() + ")");
		
		
		System.out.println("----------------");
		
		List<CurrencyRate> CurrencyRates = currencyRateRep.findByCurrency(cr);
		int i = 0;
		for (CurrencyRate currencyRate : CurrencyRates) {
			System.out.println(i + ". currency rate (id = " + currencyRate.getIdcurrencyrate() + ") valeur bid :" + currencyRate.getBidbtc());
			i++;
		}
		
	}
	
	
	public CommandLineRunner chargementDonnéesCurrency(CurrencyRateRepository repository) {
		return (args) -> {
			// save a couple of users
			// repository.save(new User("francois", "l'embrouille", "fe",
			// "francois@embrouille.com", "123", null, null, null));

			// fetch all users

			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (CurrencyRate cr : repository.findAll()) {


			}

			log.info("");

		};
	}
	
	
	public CommandLineRunner chargementDonnéesCurrencyRate(CurrencyRateRepository repository) {
		return (args) -> {
			// save a couple of users
			// repository.save(new User("francois", "l'embrouille", "fe",
			// "francois@embrouille.com", "123", null, null, null));

			// fetch all users

			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (CurrencyRate cr : repository.findAll()) {


			}

			log.info("");

		};
	}
	

//	// ajout des currency rate mockés
//
//	public CommandLineRunner saveMockCurrency(CurrencyRateRepository repository) {
//		return (args) -> {
//
//			// Sauvegarde des mocks
//
//			PrintWriter writer;
//			try {
//				writer = new PrintWriter("CurrencyMock6.csv", "UTF-8");
//
//				// création de l'objet currency rate
//				Currency cr = new Currency(6, "mock currency 6", "mck6", false, 10005,0.06, 0.066, 36.0);
//				final Long StartTimeLong = 1514050791000L; // 23 novembre 2017
//				final Long EndTimeLong = 1517342118000L; // 30 janvier 2018
//				//final Long EndTimeLong = 1514057991100L; // petit test
//
//				// valeur de départ
//				double askbtc = 0.00007639;
//				double bidbtc = 0.00007628;
//				double delta = 0.00000130;
//				double deltaBidAsk = 0.00000016;
//
//				// sens d'évolution
//				double valueSens = 0.51;// valeur comprise entre 0 et 1; si = 0.5 => 1 chance sur deux de monter, si
//										// >0.5 plus de chance de monter
//				int signe = 1;
//				
//				// variable tampon
//				String text ="";
//
//				for (Long date = StartTimeLong; date < EndTimeLong; date += 1800000) {
//
//					Date timerecord = new Date(date);
//
//					// définition du signe
//
//					if (Math.random() <= valueSens) {
//						signe = 1;
//					} else {
//						signe = -1;
//					}
//
//					if(askbtc<0.00001500) {
//						askbtc=askbtc+0.00002000;
//					}
//					askbtc = askbtc + (signe) * (Math.random() * delta) ;
//					bidbtc = askbtc - (Math.random() * delta) - 0.00000002 ;
//
//					CurrencyRate crr = new CurrencyRate(cr, timerecord, bidbtc, askbtc);
//
//					repository.save(crr);
//					
//					text = date + ";" + bidbtc + ";" + askbtc;
//					
//					writer.println(text.replace(".", ","));
//
//				}
//
//				writer.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			System.out.println("chargement des données fini");
//
//		};
//	}

	// ajout des currency
	// @Bean //le bean fait que ça s'éxécute au démarrage
	// public CommandLineRunner saveMockCurrency(CurrencyRepository repository) {
	// return (args) -> {
	//
	//
	// repository.save(new Currency(1, "mock currency 1", "mck1", false, 10000,
	// 0.01, 0.02, 30.0));
	// repository.save(new Currency(2, "mock currency 2", "mck2", false, 10001,
	// 0.02, 0.022, 32.0));
	// repository.save(new Currency(3, "mock currency 3", "mck3", false, 10002,
	// 0.03, 0.033, 33.0));
	// repository.save(new Currency(4, "mock currency 4", "mck4", false, 10003,
	// 0.04, 0.044, 34.0));
	// repository.save(new Currency(5, "mock currency 5", "mck5", false, 10004,
	// 0.05, 0.055, 35.0));
	// repository.save(new Currency(6, "mock currency 6", "mck6", false, 10005,
	// 0.06, 0.066, 36.0));
	//
	// };
	// }

	//@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of users
			// repository.save(new User("francois", "l'embrouille", "fe",
			// "francois@embrouille.com", "123", null, null, null));

			// fetch all users
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
				System.out.println(user.getId() + " " + user.getFirstname() + " " + user.getLastname());
			}

			log.info("");

			// System.out.println(log.toString());

			// fetch an individual user by ID
			/*
			 * User user = repository.findOne(5); log.info("User found with findOne(1L):");
			 * log.info("--------------------------------"); log.info(user.toString());
			 * log.info("");
			 */

			// fetch users by last name
			/*
			 * log.info("User found with findByLastName('Bauer'):");
			 * log.info("--------------------------------------------"); for (User bauer :
			 * repository.findByLastname("l'embrouille")) { log.info(bauer.toString()); }
			 * 
			 * 
			 * log.info("");
			 */
		};
	}

}
