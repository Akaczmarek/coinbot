package fr.afjg.coinbot.external.api;

import java.io.IOException;

public class PaymiumPublic implements fr.afjg.coinbot.external.api.intf.IPaymiumPublic{
	private ConnexionPublic api;

	public PaymiumPublic() {
		super();
	}
	
	public StringBuffer getBtcCurrency() {
		
		String url = "https://paymium.com/api/v1/data/eur/ticker";
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
