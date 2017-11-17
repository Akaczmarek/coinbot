package fr.afjg.coinbot.pojo;

public class Result {
	
	private String marketCurrency;
	private String baseCurrency;
	private String marketCurrencyLong;
	private String baseCurrencyLong;
	private long minTradeSize;
	private String marketName;
	private boolean isActive;
	private String created;
	private String notice;
	private boolean isSponsored;
	private String logoUrl;
	
	public Result() {
		this("", "", "", "", 0, "", false, "", "", false, "");
	}

	public Result(String marketCurrency, String baseCurrency, String marketCurrencyLong,
			String baseCurrencyLong, long minTradeSize, String marketName, boolean isActive, String created,
			String notice, boolean isSponsored, String logoUrl) {
		super();
		this.marketCurrency = marketCurrency;
		this.baseCurrency = baseCurrency;
		this.marketCurrencyLong = marketCurrencyLong;
		this.baseCurrencyLong = baseCurrencyLong;
		this.minTradeSize = minTradeSize;
		this.marketName = marketName;
		this.isActive = isActive;
		this.created = created;
		this.notice = notice;
		this.isSponsored = isSponsored;
		this.logoUrl = logoUrl;
	}

	public String getMarketCurrency() {
		return marketCurrency;
	}

	public void setMarketCurrency(String marketCurrency) {
		this.marketCurrency = marketCurrency;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getMarketCurrencyLong() {
		return marketCurrencyLong;
	}

	public void setMarketCurrencyLong(String marketCurrencyLong) {
		this.marketCurrencyLong = marketCurrencyLong;
	}

	public String getBaseCurrencyLong() {
		return baseCurrencyLong;
	}

	public void setBaseCurrencyLong(String baseCurrencyLong) {
		this.baseCurrencyLong = baseCurrencyLong;
	}

	public long getMinTradeSize() {
		return minTradeSize;
	}

	public void setMinTradeSize(long minTradeSize) {
		this.minTradeSize = minTradeSize;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public boolean isSponsored() {
		return isSponsored;
	}

	public void setSponsored(boolean isSponsored) {
		this.isSponsored = isSponsored;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [marketCurrency=");
		builder.append(marketCurrency);
		builder.append(", baseCurrency=");
		builder.append(baseCurrency);
		builder.append(", marketCurrencyLong=");
		builder.append(marketCurrencyLong);
		builder.append(", baseCurrencyLong=");
		builder.append(baseCurrencyLong);
		builder.append(", minTradeSize=");
		builder.append(minTradeSize);
		builder.append(", marketName=");
		builder.append(marketName);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", created=");
		builder.append(created);
		builder.append(", notice=");
		builder.append(notice);
		builder.append(", isSponsored=");
		builder.append(isSponsored);
		builder.append(", logoUrl=");
		builder.append(logoUrl);
		builder.append("]");
		return builder.toString();
	}
	
	

	

}
