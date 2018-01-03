package fr.afgj.coinbot.external.api.miscellaneous;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.afgj.coinbot.external.api.CoinMarketCapPublic;
import fr.afgj.coinbot.external.api.entities.coinmarketcap.Market;
import fr.afgj.coinbot.external.api.intf.CoinMarketCapPublicIntf;
import fr.afgj.coinbot.external.api.miscellaneous.intf.ICoinMarketCapGetFirstHundredMarket;

public class CoinMarketCapGetFirstHundredMarket implements ICoinMarketCapGetFirstHundredMarket{
	
	CoinMarketCapPublicIntf CmcDao;

	public CoinMarketCapGetFirstHundredMarket() {
		super();
		this.setCmcDao(new CoinMarketCapPublic());
	}

	public Set<Market> getMarket() throws IOException, JSONException {

		Set<Market> listMarket = new HashSet<>();
		JSONObject jsonObj = new JSONObject( "{ \"result\" : " + CmcDao.getFirstHundredMarket() + " } ");
		
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
				market.setRank("");
			} else {
				market.setRank(jsonObj.getString("rank"));
			}
			
			if (jsonObj.isNull("price_usd")) {
				market.setPrice_usd("");
			} else {
				market.setPrice_usd(jsonObj.getString("price_usd"));
			}
			
			if (jsonObj.isNull("price_btc")) {
				market.setPrice_btc("");
			} else {
				market.setPrice_btc(jsonObj.getString("price_btc"));
			}
			

			if (jsonObj.isNull("volume_usd24h")) {
				market.setVolume_usd24h("");
			} else {
				market.setVolume_usd24h(jsonObj.getString("volume_usd24h"));
			}

			if (jsonObj.isNull("market_cap_usd")) {
				market.setMarket_cap_usd("");
			} else {
				market.setMarket_cap_usd(jsonObj.getString("market_cap_usd"));
			}

			if (jsonObj.isNull("available_supply")) {
				market.setAvailable_supply("");
			} else {
				market.setAvailable_supply(jsonObj.getString("available_supply"));
			}

			if (jsonObj.isNull("total_supply")) {
				market.setTotal_supply("");
			} else {
				market.setTotal_supply(jsonObj.getString("total_supply"));
			}

			if (jsonObj.isNull("max_supply")) {
				market.setMax_supply("");
			} else {
				market.setMax_supply(jsonObj.getString("max_supply"));
			}

			if (jsonObj.isNull("percent_change_1h")) {
				market.setPercent_change_1h("");
			} else {
				market.setPercent_change_1h(jsonObj.getString("percent_change_1h"));
			}

			if (jsonObj.isNull("percent_change_24h")) {
				market.setPercent_change_24h("");
			} else {
				market.setPercent_change_24h(jsonObj.getString("percent_change_24h"));
			}

			if (jsonObj.isNull("percent_change_7d")) {
				market.setPercent_change_7d("");
			} else {
				market.setPercent_change_7d(jsonObj.getString("percent_change_7d"));
			}

			if (jsonObj.isNull("last_updated")) {
				market.setLast_updated("");
			} else {
				market.setLast_updated(jsonObj.getString("last_updated"));
			}

			if (jsonObj.isNull("price_eur")) {
				market.setPrice_eur("");
			} else {
				market.setPrice_eur(jsonObj.getString("price_eur"));
			}

			if (jsonObj.isNull("volume_eur24h")) {
				market.setVolume_eur24h("");
			} else {
				market.setVolume_eur24h(jsonObj.getString("volume_eur24h"));
			}

			if (jsonObj.isNull("market_cap_eur")) {
				market.setMarket_cap_eur("");
			} else {
				market.setMarket_cap_eur(jsonObj.getString("market_cap_eur"));
			}
			
			listMarket.add(market);
			
		}

		return listMarket;
	}
	

	private void setCmcDao(CoinMarketCapPublicIntf CmcDao) {
		this.CmcDao = CmcDao;
	}

}
