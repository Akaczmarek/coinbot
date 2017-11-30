package fr.afjg.coinbot.dao.impl.api;

import java.io.IOException;

import fr.afjg.coinbot.api.ConnexionPublic;
import fr.afjg.coinbot.dao.intf.api.CoinMarketCapDaoIntf;

public class CoinMarketCapDaoImpl implements CoinMarketCapDaoIntf{

	public ConnexionPublic api;

	public CoinMarketCapDaoImpl() {
		super();
	}

	public StringBuffer getFirstHundredMarket() throws IOException {

		String url = "https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=100";
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
