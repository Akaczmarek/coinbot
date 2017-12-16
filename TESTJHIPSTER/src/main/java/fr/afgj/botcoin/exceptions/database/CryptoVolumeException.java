package fr.afjg.coinbot.exceptions.database;

public class CryptoVolumeException extends RuntimeException {
	
	public CryptoVolumeException() {
		super();
	}
	
	public CryptoVolumeException(String mess) {
		super(mess);
	}

}
