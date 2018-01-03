package fr.afgj.coinbot.external.api.entities.paymium;

public class BtcCurrency {
	private double high;
	private double low;
	private double volume;
	private double bid;
	private double ask;
	private double midpoint;
	private double vwap;
	private int at;
	private double price;
	private double open;
	private int variation;
	private String currency;
	private String tradeId;
	private double size;

	public BtcCurrency() {
		super();
	}

	public BtcCurrency(double high, double low, double volume, double bid, double ask, double midpoint, double vwap,
			int at, double price, double open, int variation, String currency, String tradeId, double size) {
		super();
		this.high = high;
		this.low = low;
		this.volume = volume;
		this.bid = bid;
		this.ask = ask;
		this.midpoint = midpoint;
		this.vwap = vwap;
		this.at = at;
		this.price = price;
		this.open = open;
		this.variation = variation;
		this.currency = currency;
		this.tradeId = tradeId;
		this.size = size;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public double getMidpoint() {
		return midpoint;
	}

	public void setMidpoint(double midpoint) {
		this.midpoint = midpoint;
	}

	public double getVwap() {
		return vwap;
	}

	public void setVwap(double vwap) {
		this.vwap = vwap;
	}

	public int getAt() {
		return at;
	}

	public void setAt(int at) {
		this.at = at;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public int getVariation() {
		return variation;
	}

	public void setVariation(int variation) {
		this.variation = variation;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcCurrency [high=");
		builder.append(high);
		builder.append(", low=");
		builder.append(low);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", bid=");
		builder.append(bid);
		builder.append(", ask=");
		builder.append(ask);
		builder.append(", midpoint=");
		builder.append(midpoint);
		builder.append(", vwap=");
		builder.append(vwap);
		builder.append(", at=");
		builder.append(at);
		builder.append(", price=");
		builder.append(price);
		builder.append(", open=");
		builder.append(open);
		builder.append(", variation=");
		builder.append(variation);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ask);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + at;
		temp = Double.doubleToLongBits(bid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		temp = Double.doubleToLongBits(high);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(low);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(midpoint);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(open);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		result = prime * result + variation;
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vwap);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BtcCurrency other = (BtcCurrency) obj;
		if (Double.doubleToLongBits(ask) != Double.doubleToLongBits(other.ask))
			return false;
		if (at != other.at)
			return false;
		if (Double.doubleToLongBits(bid) != Double.doubleToLongBits(other.bid))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (Double.doubleToLongBits(high) != Double.doubleToLongBits(other.high))
			return false;
		if (Double.doubleToLongBits(low) != Double.doubleToLongBits(other.low))
			return false;
		if (Double.doubleToLongBits(midpoint) != Double.doubleToLongBits(other.midpoint))
			return false;
		if (Double.doubleToLongBits(open) != Double.doubleToLongBits(other.open))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		if (tradeId == null) {
			if (other.tradeId != null)
				return false;
		} else if (!tradeId.equals(other.tradeId))
			return false;
		if (variation != other.variation)
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		if (Double.doubleToLongBits(vwap) != Double.doubleToLongBits(other.vwap))
			return false;
		return true;
	}

}
