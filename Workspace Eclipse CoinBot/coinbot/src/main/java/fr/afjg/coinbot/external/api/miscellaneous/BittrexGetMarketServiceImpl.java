package fr.afjg.coinbot.external.api.miscellaneous;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.afjg.coinbot.dao.impl.api.BittrexDaoImpl;
import fr.afjg.coinbot.external.api.entites.bittrex.Market;
import fr.afjg.coinbot.external.api.entites.bittrex.Result;
import fr.afjg.coinbot.external.api.intf.BittrexDaoIntf;
import fr.afjg.coinbot.external.api.miscellaneous.intf.BittrexGetMarketServiceIntf;

public class BittrexGetMarketServiceImpl implements BittrexGetMarketServiceIntf {

	BittrexDaoIntf bittrexDao;

	public BittrexGetMarketServiceImpl() {
		super();
		this.setBittrexDao(new BittrexDaoImpl());
	}

	public Market getMarket() throws IOException, JSONException {

		StringBuffer sb = bittrexDao.getMarket();
		JSONObject jsonObj = new JSONObject(sb.toString());
		Market market = new Market();
		JSONArray jsonArray = jsonObj.getJSONArray("result");

		market.setSuccess(jsonObj.getBoolean("success"));
		market.setMessage(jsonObj.getString("message"));

		for (int i = 0; i < jsonArray.length(); i++) {
			Result result = new Result();
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
	}
	

	private void setBittrexDao(BittrexDaoIntf bittrexDao) {
		this.bittrexDao = bittrexDao;
	}

}
