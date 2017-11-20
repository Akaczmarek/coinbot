package fr.afjg.coinbot.impl.api;

import java.io.IOException;

import fr.afjg.coinbot.api.ConnexionPublic;
import fr.afjg.coinbot.intf.api.BittrexIntf;

public class BittrexImpl implements BittrexIntf{
	
	ConnexionPublic api;
	
	public BittrexImpl() {
		super();
	}
	
	public StringBuffer getMarket() throws IOException {
		
		String url = "https://bittrex.com/api/v1.1/public/getmarkets";
		api = new ConnexionPublic(url);
		
		
		return api.print_content();
	}
	
}
