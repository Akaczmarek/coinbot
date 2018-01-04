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
		try {
			Gson gson = new Gson();
			// System.out.println(CmcDao.getFirstHundredMarket());

			List<Market> liste = gson.fromJson(CmcDao.getFirstHundredMarket().toString(),
					new TypeToken<ArrayList<Market>>() {
					}.getType());
			listMarket = new HashSet<Market>(liste);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problemes de parsage");

		}

		return listMarket;

	}

	private void setCmcDao(ICoinMarketCapPublic CmcDao) {
		this.CmcDao = CmcDao;
	}

}
