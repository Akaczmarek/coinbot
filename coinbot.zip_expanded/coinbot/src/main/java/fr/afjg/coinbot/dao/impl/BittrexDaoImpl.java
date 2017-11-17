package fr.afjg.coinbot.dao.impl;

import java.io.IOException;

import fr.afjg.coinbot.api.ConnexionApi;
import fr.afjg.coinbot.dao.intf.BittrexDaoIntf;

public class BittrexDaoImpl implements BittrexDaoIntf{
	
	public ConnexionApi api;
	
	public BittrexDaoImpl() {
		super();
	}
	
	public StringBuffer getMarket() throws IOException {
		
		String url = "https://bittrex.com/api/v1.1/public/getmarkets";
		this.setApi(new ConnexionApi(url));
		return this.getApi().print_content();
	}

	public ConnexionApi getApi() {
		return api;
	}

	public void setApi(ConnexionApi api) {
		this.api = api;
	}
	
}
