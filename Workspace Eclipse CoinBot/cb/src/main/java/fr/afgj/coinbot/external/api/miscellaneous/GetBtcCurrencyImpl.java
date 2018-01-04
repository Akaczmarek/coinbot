package fr.afgj.coinbot.external.api.miscellaneous;

import org.json.JSONException;
import org.json.JSONObject;

import fr.afgj.coinbot.external.api.PaymiumPublic;
import fr.afgj.coinbot.external.api.entities.paymium.BtcCurrency;
import fr.afgj.coinbot.external.api.intf.IPaymiumPublic;
import fr.afgj.coinbot.external.api.miscellaneous.intf.IGetBtcCurrency;

public class GetBtcCurrencyImpl implements IGetBtcCurrency {
	
	IPaymiumPublic paymiumPublic;

	public GetBtcCurrencyImpl() {
		super();
		this.setPaymiumPublic(new PaymiumPublic());
	}

	@Override
	public BtcCurrency getBtcCurreny() {
		
		try {
			JSONObject jsonObj = new JSONObject( paymiumPublic.getBtcCurrency().toString() );
			BtcCurrency btcCurrency = new BtcCurrency();

			if (jsonObj.isNull("high")) {
				btcCurrency.setHigh(0);
			} else {
				btcCurrency.setHigh(jsonObj.getDouble("high"));
			}
			if (jsonObj.isNull("low")) {
				btcCurrency.setLow(0);
			} else {
				btcCurrency.setLow(jsonObj.getDouble("low"));
			}
			if (jsonObj.isNull("volume")) {
				btcCurrency.setVolume(0);
			} else {
				btcCurrency.setVolume(jsonObj.getDouble("volume"));
			}
			if (jsonObj.isNull("bid")) {
				btcCurrency.setBid(0);
			} else {
				btcCurrency.setBid(jsonObj.getDouble("bid"));
			}
			if (jsonObj.isNull("ask")) {
				btcCurrency.setAsk(0);
			} else {
				btcCurrency.setAsk(jsonObj.getDouble("ask"));
			}
			if (jsonObj.isNull("midpoint")) {
				btcCurrency.setMidpoint(0);
			} else {
				btcCurrency.setMidpoint(jsonObj.getDouble("midpoint"));
			}
			if (jsonObj.isNull("vwap")) {
				btcCurrency.setVwap(0);
			} else {
				btcCurrency.setVwap(jsonObj.getDouble("vwap"));
			}
			if (jsonObj.isNull("at")) {
				btcCurrency.setAt(0);
			} else {
				btcCurrency.setAt(jsonObj.getInt("at"));
			}
			if (jsonObj.isNull("price")) {
				btcCurrency.setPrice(0);
			} else {
				btcCurrency.setPrice(jsonObj.getDouble("price"));
			}
			if (jsonObj.isNull("open")) {
				btcCurrency.setOpen(0);
			} else {
				btcCurrency.setOpen(jsonObj.getDouble("open"));
			}
			if (jsonObj.isNull("variation")) {
				btcCurrency.setVariation(0);
			} else {
				btcCurrency.setVariation(jsonObj.getInt("variation"));
			}
			if (jsonObj.isNull("currency")) {
				btcCurrency.setCurrency("");
			} else {
				btcCurrency.setCurrency(jsonObj.getString("currency"));
			}
			if (jsonObj.isNull("trade_id")) {
				btcCurrency.setTradeId("");
			} else {
				btcCurrency.setTradeId(jsonObj.getString("trade_id"));
			}
			if (jsonObj.isNull("size")) {
				btcCurrency.setSize(0);
			} else {
				btcCurrency.setSize(jsonObj.getDouble("size"));
			}

			return btcCurrency;
		} catch (JSONException e) {
			return null;
		}
		
	}
	

	private void setPaymiumPublic(IPaymiumPublic paymiumPublic) {
		this.paymiumPublic = paymiumPublic;
	}

}
