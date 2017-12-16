package fr.afjg.coinbot.dao.impl.api;

import java.io.IOException;

import fr.afjg.coinbot.api.ConnexionPublic;
import fr.afjg.coinbot.dao.intf.api.BittrexDaoIntf;

public class BittrexDaoImpl implements BittrexDaoIntf{
	
	public ConnexionPublic api;
	
	public BittrexDaoImpl() {
		super();
	}
	
	public StringBuffer getMarket() throws IOException {
		
		String url = "https://bittrex.com/api/v1.1/public/getmarkets";
		this.setApi(new ConnexionPublic(url));
		return this.getApi().print_content();
	}
	

	
	public StringBuffer getMarketSummary(String market) throws IOException {
		
		String url = "https://bittrex.com/api/v1.1/public/getmarketsummary?market=" +  market;
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
