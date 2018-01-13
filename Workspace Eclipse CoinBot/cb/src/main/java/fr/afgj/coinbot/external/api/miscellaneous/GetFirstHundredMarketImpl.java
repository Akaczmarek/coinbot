package fr.afgj.coinbot.external.api.miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import fr.afgj.coinbot.external.api.CoinMarketCapPublic;
import fr.afgj.coinbot.external.api.entities.coinmarketcap.Market;
import fr.afgj.coinbot.external.api.intf.ICoinMarketCapPublic;
import fr.afgj.coinbot.external.api.miscellaneous.intf.IGetFirstHundredMarket;

public class GetFirstHundredMarketImpl implements IGetFirstHundredMarket {

	ICoinMarketCapPublic CmcDao;

	public GetFirstHundredMarketImpl() {
		super();
		this.setCmcDao(new CoinMarketCapPublic());
	}

	public Set<Market> getMarket() {

		ICoinMarketCapPublic CmcDao = new CoinMarketCapPublic();
		Set<Market> listMarket = new HashSet<>();

		listMarket = new HashSet<>();
		
		// Ici on va parser la chaines recu en objet 
		try {
			// instanciation de la lib Gson pour parser
			Gson gson = new Gson();
			
			// Cette ligne parse tous les objets de la chaine de caractere, pas besoin de boucle.
			List<Market> liste = gson.fromJson(CmcDao.getFirstHundredMarket().toString(),
					new TypeToken<ArrayList<Market>>() {
					}.getType());
			
			// On ajoute a listMarket les objets precedemment creer
			listMarket = new HashSet<Market>(liste);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problemes de parsage");
		}
		
		// On renvoie la liste d'objet
		return listMarket;

	}

	private void setCmcDao(ICoinMarketCapPublic CmcDao) {
		this.CmcDao = CmcDao;
	}

}
