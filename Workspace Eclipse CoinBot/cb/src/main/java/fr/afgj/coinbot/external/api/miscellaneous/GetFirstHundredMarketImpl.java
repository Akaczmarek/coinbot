package fr.afgj.coinbot.external.api.miscellaneous;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		boolean done = false;
		while (done == false) {
			if (listMarket.size() != 0) {
				listMarket = new HashSet<>();
			}
			try {
				JSONObject jsonObj = new JSONObject("{ \"result\" : " + CmcDao.getFirstHundredMarket() + " } ");

				JSONArray jsonArray = jsonObj.getJSONArray("result");

				for (int i = 0; i < jsonArray.length(); i++) {
					Market market = new Market();
					jsonObj = (JSONObject) jsonArray.get(i);

					if (jsonObj.isNull("id")) {
						market.setId("");
					} else {
						market.setId(jsonObj.getString("id"));
					}

					if (jsonObj.isNull("name")) {
						market.setName("");
					} else {
						market.setName(jsonObj.getString("name"));
					}

					if (jsonObj.isNull("symbol")) {
						market.setSymbol("");
					} else {
						market.setSymbol(jsonObj.getString("symbol"));
					}

					if (jsonObj.isNull("rank")) {
						market.setRank(-1);
					} else {
						market.setRank(Integer.parseInt(jsonObj.getString("rank")));
					}

					if (jsonObj.isNull("price_usd")) {
						market.setPrice_usd(0d);
					} else {
						market.setPrice_usd(jsonObj.getDouble("price_usd"));
					}
					if (jsonObj.isNull("price_btc")) {
						market.setPrice_btc(0d);
					} else {
						market.setPrice_btc(jsonObj.getDouble("price_btc"));
					}

					if (jsonObj.isNull("24h_volume_usd")) {
						market.setVolume_usd24h(-1d);
					} else {
						market.setVolume_usd24h(jsonObj.getDouble("24h_volume_usd"));
					}

					if (jsonObj.isNull("market_cap_usd")) {
						market.setMarket_cap_usd(0d);
					} else {
						market.setMarket_cap_usd(jsonObj.getDouble("market_cap_usd"));
					}

					if (jsonObj.isNull("available_supply")) {
						market.setAvailable_supply(0d);
					} else {
						market.setAvailable_supply(jsonObj.getDouble("available_supply"));
					}

					if (jsonObj.isNull("total_supply")) {
						market.setTotal_supply(0d);
					} else {
						market.setTotal_supply(jsonObj.getDouble("total_supply"));
					}

					if (jsonObj.isNull("max_supply")) {
						market.setMax_supply(0d);
					} else {
						market.setMax_supply(jsonObj.getDouble("max_supply"));
					}

					if (jsonObj.isNull("percent_change_1h")) {
						market.setPercent_change_1h(0d);
					} else {
						market.setPercent_change_1h(jsonObj.getDouble("percent_change_1h"));
					}

					if (jsonObj.isNull("percent_change_24h")) {
						market.setPercent_change_24h(0d);
					} else {
						market.setPercent_change_24h(jsonObj.getDouble("percent_change_24h"));
					}

					if (jsonObj.isNull("percent_change_7d")) {
						market.setPercent_change_7d(0d);
					} else {
						market.setPercent_change_7d(jsonObj.getDouble("percent_change_7d"));
					}

					if (jsonObj.isNull("last_updated")) {
						market.setLast_updated("");
					} else {
						market.setLast_updated(jsonObj.getString("last_updated"));
					}

					if (jsonObj.isNull("price_eur")) {
						market.setPrice_eur(0d);
					} else {
						market.setPrice_eur(jsonObj.getDouble("price_eur"));
					}

					if (jsonObj.isNull("24h_volume_eur")) {
						market.setVolume_eur24h(-1d);
					} else {
						market.setVolume_eur24h(Double.parseDouble(jsonObj.getString("24h_volume_eur")));
					}

					if (jsonObj.isNull("market_cap_eur")) {
						market.setMarket_cap_eur(0d);
					} else {
						market.setMarket_cap_eur(jsonObj.getDouble("market_cap_eur"));
					}
					listMarket.add(market);
				}
				done = true;
			} catch (JSONException e) {
				e.printStackTrace();
				System.out.println("Problemes de parsage");
				done = false;
			}
		}

		return listMarket;

	}

	private void setCmcDao(ICoinMarketCapPublic CmcDao) {
		this.CmcDao = CmcDao;
	}

}
