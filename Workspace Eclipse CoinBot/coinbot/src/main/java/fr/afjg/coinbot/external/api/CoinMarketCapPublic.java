package fr.afjg.coinbot.external.api;

import java.io.IOException;

import fr.afjg.coinbot.external.api.ConnexionPublic;
import fr.afjg.coinbot.external.api.intf.CoinMarketCapPublicIntf;

public class CoinMarketCapPublic implements CoinMarketCapPublicIntf{

	public ConnexionPublic api;

	public CoinMarketCapPublic() {
		super();
	}

	public StringBuffer getFirstHundredMarket() throws IOException {

		String url = "https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=50";
		this.setApi(new ConnexionPublic(url));
		return this.getApi().print_content();
	}

	public ConnexionPublic getApi() {
		return api;
	}

	public void setApi(ConnexionPublic api) {
		this.api = api;
	}
	
}
