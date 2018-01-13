package fr.afgj.coinbot.test;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import fr.afgj.coinbot.ConnexionServeurCoinbotApplication;
import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.external.api.entities.coinmarketcap.Market;
import fr.afgj.coinbot.external.api.miscellaneous.GetFirstHundredMarketImpl;
import fr.afgj.coinbot.external.api.miscellaneous.intf.IGetFirstHundredMarket;
import fr.afgj.coinbot.service.ICurrencyService;

public class MiseEnBase {
	//pour tentative de push
	
	public static void main(String[] args) {
		// Verifier que les données ne sont pas deja entrées dans la base
		// update si deja existant sinon insert
		// premiere entrée en base
		MiseEnBase miseEnBase = new MiseEnBase();
		ApplicationContext ctx = SpringApplication.run(ConnexionServeurCoinbotApplication.class, args);

		MiseEnBase.persistCurrency(ctx);

	}

	public static void persistCurrency(ApplicationContext ctx) {
		ICurrencyService cs = ctx.getBean(ICurrencyService.class);
		IGetFirstHundredMarket cmc = new GetFirstHundredMarketImpl();
		Set<Market> markets = null;

		markets = cmc.getMarket();
		System.out.println("nb currency : " + markets.size());

		for (Market market : markets) {
			Currency currency = new Currency();
			currency.setName(market.getName());
			currency.setSymbol(market.getSymbol());
			currency.setRank(market.getRank());
			currency.setVolumeeur(market.getVolume_eur24h());
			currency.setVolumeusd(market.getVolume_usd24h());
			// System.out.println("Currency : " + currency.toString());
			if (cs.existsByName(currency.getName())) {
				// System.out.println("Updating ...");
				currency = cs.findByName(currency.getName());
				cs.updateById(currency);
				// System.out.println("Updated !");

			} else {
				// System.out.println("Saving ...");
				cs.saveCurrency(currency);
				// System.out.println("Saved !");
			}

		}
	}

}
