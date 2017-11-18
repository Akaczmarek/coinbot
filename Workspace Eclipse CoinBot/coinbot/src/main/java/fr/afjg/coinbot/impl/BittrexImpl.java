package fr.afjg.coinbot.impl;

import java.io.IOException;

import fr.afjg.coinbot.api.ConnexionApi;
import fr.afjg.coinbot.intf.BittrexIntf;

public class BittrexImpl implements BittrexIntf{
	
	ConnexionApi api;
	
	public BittrexImpl() {
		super();
	}
	
	public StringBuffer getMarket() throws IOException {
		
		String url = "https://bittrex.com/api/v1.1/public/getmarkets";
		api = new ConnexionApi(url);
		
		
		return api.print_content();
	}
	
}
