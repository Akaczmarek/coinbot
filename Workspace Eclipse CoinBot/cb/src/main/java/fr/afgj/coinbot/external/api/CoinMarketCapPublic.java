package fr.afgj.coinbot.external.api;

import java.io.IOException;

import fr.afgj.coinbot.external.api.intf.ICoinMarketCapPublic;

public class CoinMarketCapPublic implements ICoinMarketCapPublic {

	public ConnexionPublic api;

	public CoinMarketCapPublic() {
		super();
	}

	public StringBuffer getFirstHundredMarket() {

		String url = "https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=100";
		try {
			this.setApi(new ConnexionPublic(url));
			return this.getApi().print_content();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Impossible de récupérer l'API");
		}
		return null;
	}

	public ConnexionPublic getApi() {
		return api;
	}

	public void setApi(ConnexionPublic api) {
		this.api = api;
	}

}
