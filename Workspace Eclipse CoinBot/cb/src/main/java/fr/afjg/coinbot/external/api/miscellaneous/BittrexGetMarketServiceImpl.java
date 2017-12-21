package fr.afjg.coinbot.external.api.miscellaneous;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.afjg.coinbot.external.api.BittrexPublic;
import fr.afjg.coinbot.external.api.entites.bittrex.Markets;
import fr.afjg.coinbot.external.api.entites.bittrex.Results;
import fr.afjg.coinbot.external.api.intf.IBittrexPublic;
import fr.afjg.coinbot.external.api.miscellaneous.intf.IBittrexGetMarketService;

public class BittrexGetMarketServiceImpl implements IBittrexGetMarketService {

	IBittrexPublic bittrexPublic;

	public BittrexGetMarketServiceImpl() {
		super();
		this.setBittrexPublic(new BittrexPublic());
	}

	public Markets getMarket(){
		try {
			JSONObject jsonObj = new JSONObject( bittrexPublic.getMarkets().toString() );
			Markets market = new Markets();
			JSONArray jsonArray = jsonObj.getJSONArray("result");

			market.setSuccess(jsonObj.getBoolean("success"));
			market.setMessage(jsonObj.getString("message"));

			for (int i = 0; i < jsonArray.length(); i++) {
				Results result = new Results();
				jsonObj = (JSONObject) jsonArray.get(i);

				if (jsonObj.isNull("MarketName")) {
					result.setMarketName("");
				} else {
					result.setMarketName(jsonObj.getString("MarketName"));
				}

				if (jsonObj.isNull("MarketCurrency")) {
					result.setMarketCurrency("");
				} else {
					result.setMarketCurrency(jsonObj.getString("MarketCurrency"));
				}

				if (jsonObj.isNull("MarketCurrencyLong")) {
					result.setMarketCurrencyLong("");
				} else {
					result.setMarketCurrencyLong(jsonObj.getString("MarketCurrencyLong"));
				}

				if (jsonObj.isNull("Notice")) {
					result.setNotice("");
				} else {
					result.setNotice(jsonObj.getString("Notice"));
				}
				
				if (jsonObj.isNull("IsActive")) {
					result.setActive(false);
				} else {
					result.setActive(jsonObj.getBoolean("IsActive"));
				}
				
				if (jsonObj.isNull("IsSponsored")) {
					result.setSponsored(false);
				} else {
					result.setSponsored(jsonObj.getBoolean("IsSponsored"));
				}
				

				if (jsonObj.isNull("LogoUrl")) {
					result.setLogoUrl("");
				} else {
					result.setLogoUrl(jsonObj.getString("LogoUrl"));
				}

				if (jsonObj.isNull("BaseCurrency")) {
					result.setBaseCurrency("");
				} else {
					result.setBaseCurrency(jsonObj.getString("BaseCurrency"));
				}

				if (jsonObj.isNull("BaseCurrencyLong")) {
					result.setBaseCurrencyLong("");
				} else {
					result.setBaseCurrencyLong(jsonObj.getString("BaseCurrencyLong"));
				}

				if (jsonObj.isNull("MinTradeSize")) {
					result.setBaseCurrencyLong("");
				} else {
					result.setMinTradeSize(jsonObj.getLong("MinTradeSize"));
				}
				

				if (jsonObj.isNull("Created")) {
					result.setCreated("");
				} else {
					result.setCreated(jsonObj.getString("Created"));
				}
				market.addResult(result);
			}

			return market;
		} catch (JSONException e) {
			return null;
		}
		
	}
	

	private void setBittrexPublic(IBittrexPublic ittrexPublic) {
		this.bittrexPublic = ittrexPublic;
	}

}
