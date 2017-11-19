package fr.afjg.coinbot.database.exceptions;

public class CryptoVolumeException extends RuntimeException {
	
	public CryptoVolumeException() {
		super();
	}
	
	public CryptoVolumeException(String mess) {
		super(mess);
	}

}
