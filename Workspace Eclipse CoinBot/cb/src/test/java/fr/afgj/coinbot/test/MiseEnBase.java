package fr.afgj.coinbot.test;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import fr.afgj.coinbot.repository.CurrencyRepository;
import fr.afgj.coinbot.repository.CurrencyTrendRepository;
import fr.afgj.coinbot.service.CurrencyService;
import fr.afgj.coinbot.ConnexionServeurCoinbotApplication;
import fr.afgj.coinbot.entity.Currency;
import fr.afgj.coinbot.external.api.entities.coinmarketcap.Market;
import fr.afgj.coinbot.external.api.miscellaneous.BittrexGetMarketServiceImpl;
import fr.afgj.coinbot.external.api.miscellaneous.CoinMarketCapGetFirstHundredMarket;
import fr.afgj.coinbot.external.api.miscellaneous.intf.IBittrexGetMarketSummary;
import fr.afgj.coinbot.external.api.miscellaneous.intf.ICoinMarketCapGetFirstHundredMarket;

public class MiseEnBase {

	public static void main(String[] args) {
		// Verifier que les données ne sont pas deja entrées dans la base
		// update si deja existant sinon insert
		// premiere entrée en base
		ApplicationContext ctx = SpringApplication.run(ConnexionServeurCoinbotApplication.class, args);
		CurrencyService cs = ctx.getBean(CurrencyService.class);
		ICoinMarketCapGetFirstHundredMarket cmc = new CoinMarketCapGetFirstHundredMarket();
		Set<Market> markets = null;
		try {
			markets = cmc.getMarket();
			System.out.println("nb currency : " + markets.size());
			
			for (Market market : markets) {
				// if market.getName = bitcoin -> currency.refCurrency = true
				Currency currency = new Currency();
				currency.setName(market.getName());
				currency.setSymbol(market.getSymbol());
				currency.setRank( market.getRank() );
				currency.setVolumeeur( market.getVolume_eur24h() );
				currency.setVolumeusd( market.getVolume_usd24h() );
				if( cs.existByName(currency.getName()) ) {
					cs.updateByName(currency);
				}
				cs.saveCurrency(currency);
				System.out.println(currency);
			}
			
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
