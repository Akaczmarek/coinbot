package fr.afjg.coinbot.external.api;

import java.io.IOException;

import fr.afjg.coinbot.external.api.ConnexionPublic;
import fr.afjg.coinbot.external.api.intf.IBittrexPublic;

public class BittrexPublic implements IBittrexPublic{
	
	public ConnexionPublic api;
	
	public BittrexPublic() {
		super();
	}
	
	public StringBuffer getMarkets() {
		
		String url = "https://bittrex.com/api/v1.1/public/getmarkets";
		try {
			this.setApi(new ConnexionPublic(url));
			return this.getApi().print_content();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Impossible de récupérer l'API");
		}
		return null;
	}
	

	
	public StringBuffer getMarketSummary(String market){
		
		String url = "https://bittrex.com/api/v1.1/public/getmarketsummary?market=" +  market;
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
