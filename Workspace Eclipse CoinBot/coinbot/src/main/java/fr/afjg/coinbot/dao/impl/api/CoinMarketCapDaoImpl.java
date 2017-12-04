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

		String url = "https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=25";
		this.setApi(new ConnexionPublic(url));
		StringBuffer sb = new StringBuffer();
		sb.append("{ \"result\" : ");
		sb.append(this.getApi().print_content());
		sb.append(" } ");
		return sb;
	}

	public ConnexionPublic getApi() {
		return api;
	}

	public void setApi(ConnexionPublic api) {
		this.api = api;
	}
	
}
