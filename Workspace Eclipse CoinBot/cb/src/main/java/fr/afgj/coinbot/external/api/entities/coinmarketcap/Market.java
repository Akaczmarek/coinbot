package fr.afgj.coinbot.external.api.entities.coinmarketcap;

public class Market {

	private String id;
	private String name;
	private String symbol;
	private Integer rank;
	private String price_usd;
	private String price_btc;
	private Double volume_usd24h;
	private String market_cap_usd;
	private String available_supply;
	private String total_supply;
	private String max_supply;
	private String percent_change_1h;
	private String percent_change_24h;
	private String percent_change_7d;
	private String last_updated;
	private String price_eur;
	private Double volume_eur24h;
	private String market_cap_eur;
	
	public Market() {
		super();
	}

	public Market(String id, String name, String symbol, Integer rank, String price_usd, String price_btc,
			Double volume_usd24h, String market_cap_usd, String available_supply, String total_supply,
			String max_supply, String percent_change_1h, String percent_change_24h, String percent_change_7d,
			String last_updated, String price_eur, Double volume_eur24h, String market_cap_eur) {
		super();
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.rank = rank;
		this.price_usd = price_usd;
		this.price_btc = price_btc;
		this.volume_usd24h = volume_usd24h;
		this.market_cap_usd = market_cap_usd;
		this.available_supply = available_supply;
		this.total_supply = total_supply;
		this.max_supply = max_supply;
		this.percent_change_1h = percent_change_1h;
		this.percent_change_24h = percent_change_24h;
		this.percent_change_7d = percent_change_7d;
		this.last_updated = last_updated;
		this.price_eur = price_eur;
		this.volume_eur24h = volume_eur24h;
		this.market_cap_eur = market_cap_eur;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getPrice_usd() {
		return price_usd;
	}

	public void setPrice_usd(String price_usd) {
		this.price_usd = price_usd;
	}

	public String getPrice_btc() {
		return price_btc;
	}

	public void setPrice_btc(String price_btc) {
		this.price_btc = price_btc;
	}

	public Double getVolume_usd24h() {
		return volume_usd24h;
	}

	public void setVolume_usd24h(Double volume_usd24h) {
		this.volume_usd24h = volume_usd24h;
	}

	public String getMarket_cap_usd() {
		return market_cap_usd;
	}

	public void setMarket_cap_usd(String market_cap_usd) {
		this.market_cap_usd = market_cap_usd;
	}

	public String getAvailable_supply() {
		return available_supply;
	}

	public void setAvailable_supply(String available_supply) {
		this.available_supply = available_supply;
	}

	public String getTotal_supply() {
		return total_supply;
	}

	public void setTotal_supply(String total_supply) {
		this.total_supply = total_supply;
	}

	public String getMax_supply() {
		return max_supply;
	}

	public void setMax_supply(String max_supply) {
		this.max_supply = max_supply;
	}

	public String getPercent_change_1h() {
		return percent_change_1h;
	}

	public void setPercent_change_1h(String percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
	}

	public String getPercent_change_24h() {
		return percent_change_24h;
	}

	public void setPercent_change_24h(String percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
	}

	public String getPercent_change_7d() {
		return percent_change_7d;
	}

	public void setPercent_change_7d(String percent_change_7d) {
		this.percent_change_7d = percent_change_7d;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	public String getPrice_eur() {
		return price_eur;
	}

	public void setPrice_eur(String price_eur) {
		this.price_eur = price_eur;
	}

	public Double getVolume_eur24h() {
		return volume_eur24h;
	}

	public void setVolume_eur24h(Double volume_eur24h) {
		this.volume_eur24h = volume_eur24h;
	}

	public String getMarket_cap_eur() {
		return market_cap_eur;
	}

	public void setMarket_cap_eur(String market_cap_eur) {
		this.market_cap_eur = market_cap_eur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Market [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", symbol=");
		builder.append(symbol);
		builder.append(", rank=");
		builder.append(rank);
		builder.append(", price_usd=");
		builder.append(price_usd);
		builder.append(", price_btc=");
		builder.append(price_btc);
		builder.append(", volume_usd24h=");
		builder.append(volume_usd24h);
		builder.append(", market_cap_usd=");
		builder.append(market_cap_usd);
		builder.append(", available_supply=");
		builder.append(available_supply);
		builder.append(", total_supply=");
		builder.append(total_supply);
		builder.append(", max_supply=");
		builder.append(max_supply);
		builder.append(", percent_change_1h=");
		builder.append(percent_change_1h);
		builder.append(", percent_change_24h=");
		builder.append(percent_change_24h);
		builder.append(", percent_change_7d=");
		builder.append(percent_change_7d);
		builder.append(", last_updated=");
		builder.append(last_updated);
		builder.append(", price_eur=");
		builder.append(price_eur);
		builder.append(", volume_eur24h=");
		builder.append(volume_eur24h);
		builder.append(", market_cap_eur=");
		builder.append(market_cap_eur);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((available_supply == null) ? 0 : available_supply.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((last_updated == null) ? 0 : last_updated.hashCode());
		result = prime * result + ((market_cap_eur == null) ? 0 : market_cap_eur.hashCode());
		result = prime * result + ((market_cap_usd == null) ? 0 : market_cap_usd.hashCode());
		result = prime * result + ((max_supply == null) ? 0 : max_supply.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((percent_change_1h == null) ? 0 : percent_change_1h.hashCode());
		result = prime * result + ((percent_change_24h == null) ? 0 : percent_change_24h.hashCode());
		result = prime * result + ((percent_change_7d == null) ? 0 : percent_change_7d.hashCode());
		result = prime * result + ((price_btc == null) ? 0 : price_btc.hashCode());
		result = prime * result + ((price_eur == null) ? 0 : price_eur.hashCode());
		result = prime * result + ((price_usd == null) ? 0 : price_usd.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((total_supply == null) ? 0 : total_supply.hashCode());
		result = prime * result + ((volume_eur24h == null) ? 0 : volume_eur24h.hashCode());
		result = prime * result + ((volume_usd24h == null) ? 0 : volume_usd24h.hashCode());
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
		Market other = (Market) obj;
		if (available_supply == null) {
			if (other.available_supply != null)
				return false;
		} else if (!available_supply.equals(other.available_supply))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (last_updated == null) {
			if (other.last_updated != null)
				return false;
		} else if (!last_updated.equals(other.last_updated))
			return false;
		if (market_cap_eur == null) {
			if (other.market_cap_eur != null)
				return false;
		} else if (!market_cap_eur.equals(other.market_cap_eur))
			return false;
		if (market_cap_usd == null) {
			if (other.market_cap_usd != null)
				return false;
		} else if (!market_cap_usd.equals(other.market_cap_usd))
			return false;
		if (max_supply == null) {
			if (other.max_supply != null)
				return false;
		} else if (!max_supply.equals(other.max_supply))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (percent_change_1h == null) {
			if (other.percent_change_1h != null)
				return false;
		} else if (!percent_change_1h.equals(other.percent_change_1h))
			return false;
		if (percent_change_24h == null) {
			if (other.percent_change_24h != null)
				return false;
		} else if (!percent_change_24h.equals(other.percent_change_24h))
			return false;
		if (percent_change_7d == null) {
			if (other.percent_change_7d != null)
				return false;
		} else if (!percent_change_7d.equals(other.percent_change_7d))
			return false;
		if (price_btc == null) {
			if (other.price_btc != null)
				return false;
		} else if (!price_btc.equals(other.price_btc))
			return false;
		if (price_eur == null) {
			if (other.price_eur != null)
				return false;
		} else if (!price_eur.equals(other.price_eur))
			return false;
		if (price_usd == null) {
			if (other.price_usd != null)
				return false;
		} else if (!price_usd.equals(other.price_usd))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (total_supply == null) {
			if (other.total_supply != null)
				return false;
		} else if (!total_supply.equals(other.total_supply))
			return false;
		if (volume_eur24h == null) {
			if (other.volume_eur24h != null)
				return false;
		} else if (!volume_eur24h.equals(other.volume_eur24h))
			return false;
		if (volume_usd24h == null) {
			if (other.volume_usd24h != null)
				return false;
		} else if (!volume_usd24h.equals(other.volume_usd24h))
			return false;
		return true;
	}
	
	

	

}
