package fr.afgj.coinbot;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;

import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.entity.CurrencyRate;
import fr.afgj.coinbot.entity.OrderHistoryBot;
import fr.afgj.coinbot.entity.User;
import fr.afgj.coinbot.entity.UserConfiguration;
import fr.afgj.coinbot.external.api.entities.coinmarketcap.Market;
import fr.afgj.coinbot.external.api.miscellaneous.CoinMarketCapGetFirstHundredMarket;
import fr.afgj.coinbot.external.api.miscellaneous.intf.ICoinMarketCapGetFirstHundredMarket;
import fr.afgj.coinbot.repository.CurrencyRateRepository;
import fr.afgj.coinbot.repository.CurrencyRepository;
import fr.afgj.coinbot.repository.UserConfigurationRepository;
import fr.afgj.coinbot.repository.UserRepository;
import fr.afgj.coinbot.service.CurrencyRateService;
import fr.afgj.coinbot.service.CurrencyService;
import fr.afgj.coinbot.service.OrderHistoryBotService;

@SpringBootApplication
public class ConnexionServeurCoinbotApplication {

	private static final Logger log = LogManager.getLogger();
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ConnexionServeurCoinbotApplication.class, args);
		CurrencyRepository currencyRep = ctx.getBean(CurrencyRepository.class);
		CurrencyRateRepository currencyRateRep = ctx.getBean(CurrencyRateRepository.class);

		System.out.println("********************************** DEBUT TESTS ***************************************");
		
		System.out.println("----------------- exist ?----------------------");
		CurrencyService cs = ctx.getBean(CurrencyService.class);
//		ICoinMarketCapGetFirstHundredMarket cmc = new CoinMarketCapGetFirstHundredMarket();
//		Set<Market> markets = null;
//		try {
//			markets = cmc.getMarket();
//			System.out.println("nb currency : " + markets.size());
//			
//			for (Market market : markets) {
//				// if market.getName = bitcoin -> currency.refCurrency = true
//				Currency currency = new Currency();
//				currency.setName(market.getName());
//				currency.setSymbol(market.getSymbol());
//				currency.setRank( market.getRank() );
//				currency.setVolumeeur( market.getVolume_eur24h() );
//				currency.setVolumeusd( market.getVolume_usd24h() );
//				System.out.println( cs.existByName(currency.getName()) );
//			}
//			
//		} catch (IOException | JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("---------find one currency-----------------");
		Currency cr = currencyRep.findOne(1);

		System.out.println("currency trouvé------> " + cr.getName() + " (id = " + cr.getIdcurrency() + ")");

		System.out.println("--------------------------");



		System.out.println("---------Currency Rate By dates-----------------");
		
		CurrencyRateService crs = ctx.getBean(CurrencyRateService.class);
		Date startDate = new Date(1514946302000L);
		Date endDate = new Date(1514953502000L);
		
		List<CurrencyRate> crr1 = crs.findByDates(startDate, endDate);
		System.out.println(crr1);
		
		System.out.println("---------Currency Rate By dates and id Currency-----------------");
		
		int idcr = cr.getIdcurrency();
		List<CurrencyRate> crr2 = crs.findByDatesAndCurrency(startDate, endDate, idcr);
		
		for (CurrencyRate currencyRate : crr2) {
			System.out.println(currencyRate.getCurrency().getName());
		}

		System.out.println("-------------OHB BY USER -------------");
		OrderHistoryBotService ohbs = ctx.getBean(OrderHistoryBotService.class);
		List<OrderHistoryBot> ohbList = ohbs.findOHBByIdUser(1);
		for (OrderHistoryBot orderHistoryBot : ohbList) {
			System.out.println(orderHistoryBot.getCurrency().getName());
			Gson gson = new Gson();
			System.out.println(gson.toJson(orderHistoryBot));
		}
		
		System.out.println("-------------SAVE USERCONFIG -------------");
		UserConfigurationRepository userConfigurationRepository = ctx.getBean(UserConfigurationRepository.class);
		// récupération d'un user existant
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		User user = userRepository.findOne(2);
		UserConfiguration userConfiguration = new UserConfiguration(user);
		
		if (userConfigurationRepository.exists(user.getId())) {
			System.out.println("existe déjà ne pas ajouter");
		}else {
			System.out.println("ajout de l'identité : " + user.getId());
			userConfigurationRepository.save(userConfiguration);
		}

		
		
		
		

		System.out.println("********************************** FIN TESTS ***************************************");
		
		
		//Stage 0 : chargement de la liste de devises
		//Stage 0 : loading the currencies list
		//CurrencyService cs = ctx.getBean(CurrencyService.class);
		List<Currency> currencies = cs.currencies();
		System.out.println("chargement des devises réalisé");
		
		//Stage 1 : loading the currencies Rates list and 
		
		// OrderHistoryBot ohb2 = userRep.

		// List<CurrencyRate> CurrencyRates = currencyRateRep.findByCurrency(cr);
		// //Set<CurrencyRate> CurrencyRates = cr.getCurrencyrates();
		//
		// int i = 0;
		// for (CurrencyRate currencyRate : CurrencyRates) {
		// System.out.println(i + ". currency rate (id = " +
		// currencyRate.getIdcurrencyrate() + ") valeur bid :" +
		// currencyRate.getBidbtc());
		// i++;
		// }
		//
		// partie à
		// conserver*********************************************************************************************************
		// // first loading
		// //loading data into currencies trends bot
		// CurrenciesTrendsBot ctb = CurrenciesTrendsBot.getInstance();
		// CurrencyTrendService cts = ctx.getBean(CurrencyTrendService.class);
		// CurrencyService cs = ctx.getBean(CurrencyService.class);
		// List<Currency> currencies = cs.currencies();
		//
		// for (Currency currency : currencies) {
		// CurrencyTrend ct = ctx.getBean(CurrencyTrend.class);
		// ct.setCurrency(currency);
		// cts.saveCurrencyTrend(ct);
		// ctb.getCurrenciesTrends().add(ct);
		// }
		//
		// for (CurrencyTrend ct : ctb.getCurrenciesTrends()) {
		// System.out.println(ct.getIdtrend() + " " + ct.getCurrency().getName());
		// }
		// **************************************************************************************************

		// //essai de récupération de
		// données****************************************************************
		// CurrencyRateService crs = ctx.getBean(CurrencyRateService.class);
		// Date date0 = new Date(1514017735000L);
		// Date Recentlydate = new Date(1514190535000L);
		// List<CurrencyRate> currencyRates = crs.currencyRatesByDate(date0,
		// Recentlydate, cr);
		//
		// System.out.println(currencyRates.size());
		// //************************************************************************************************

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

	// // ajout des currency rate mockés
	//
	// public CommandLineRunner saveMockCurrency(CurrencyRateRepository repository)
	// {
	// return (args) -> {
	//
	// // Sauvegarde des mocks
	//
	// PrintWriter writer;
	// try {
	// writer = new PrintWriter("CurrencyMock6.csv", "UTF-8");
	//
	// // création de l'objet currency rate
	// Currency cr = new Currency(6, "mock currency 6", "mck6", false, 10005,0.06,
	// 0.066, 36.0);
	// final Long StartTimeLong = 1514050791000L; // 23 novembre 2017
	// final Long EndTimeLong = 1517342118000L; // 30 janvier 2018
	// //final Long EndTimeLong = 1514057991100L; // petit test
	//
	// // valeur de départ
	// double askbtc = 0.00007639;
	// double bidbtc = 0.00007628;
	// double delta = 0.00000130;
	// double deltaBidAsk = 0.00000016;
	//
	// // sens d'évolution
	// double valueSens = 0.51;// valeur comprise entre 0 et 1; si = 0.5 => 1 chance
	// sur deux de monter, si
	// // >0.5 plus de chance de monter
	// int signe = 1;
	//
	// // variable tampon
	// String text ="";
	//
	// for (Long date = StartTimeLong; date < EndTimeLong; date += 1800000) {
	//
	// Date timerecord = new Date(date);
	//
	// // définition du signe
	//
	// if (Math.random() <= valueSens) {
	// signe = 1;
	// } else {
	// signe = -1;
	// }
	//
	// if(askbtc<0.00001500) {
	// askbtc=askbtc+0.00002000;
	// }
	// askbtc = askbtc + (signe) * (Math.random() * delta) ;
	// bidbtc = askbtc - (Math.random() * delta) - 0.00000002 ;
	//
	// CurrencyRate crr = new CurrencyRate(cr, timerecord, bidbtc, askbtc);
	//
	// repository.save(crr);
	//
	// text = date + ";" + bidbtc + ";" + askbtc;
	//
	// writer.println(text.replace(".", ","));
	//
	// }
	//
	// writer.close();
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// System.out.println("chargement des données fini");
	//
	// };
	// }

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

	// @Bean
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