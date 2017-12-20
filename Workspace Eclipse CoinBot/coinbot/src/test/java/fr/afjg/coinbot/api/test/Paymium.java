package fr.afjg.coinbot.api.test;

import fr.afjg.coinbot.external.api.miscellaneous.PaymiumGetBtcCurrency;
import fr.afjg.coinbot.external.api.miscellaneous.intf.IPaymiumGetBtcCurrency;

public class Paymium {

	public static void main(String[] args) {
		
		IPaymiumGetBtcCurrency btcCurrency = new PaymiumGetBtcCurrency();
		System.out.println(btcCurrency.getBtcCurreny());
		
	}

}
