package hibernate.entity;
// Generated 21 d�c. 2017 09:38:56 by Hibernate Tools 5.1.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Currency generated by hbm2java
 */
@Entity
@Table(name = "currency", schema = "public")
public class Currency implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idcurrency;
	private String name;
	private String symbol;
	private boolean refcurrency;
	private Integer rank;
	private Double volumeeur;
	private Double volumeusd;
	private Double humannote;
	private Set<Orderhistorybot> orderhistorybots = new HashSet<Orderhistorybot>(0);
	private Set<Currencyrate> currencyrates = new HashSet<Currencyrate>(0);
	private Set<Currencytrend> currencytrends = new HashSet<Currencytrend>(0);

	public Currency() {
	}

	public Currency(int idcurrency, boolean refcurrency) {
		this.idcurrency = idcurrency;
		this.refcurrency = refcurrency;
	}

	public Currency(int idcurrency, String name, String symbol, boolean refcurrency, Integer rank, Double volumeeur,
			Double volumeusd, Double humannote, Set<Orderhistorybot> orderhistorybots, Set<Currencyrate> currencyrates,
			Set<Currencytrend> currencytrends) {
		this.idcurrency = idcurrency;
		this.name = name;
		this.symbol = symbol;
		this.refcurrency = refcurrency;
		this.rank = rank;
		this.volumeeur = volumeeur;
		this.volumeusd = volumeusd;
		this.humannote = humannote;
		this.orderhistorybots = orderhistorybots;
		this.currencyrates = currencyrates;
		this.currencytrends = currencytrends;
	}

	@Id

	@Column(name = "idcurrency", unique = true, nullable = false)
	public int getIdcurrency() {
		return this.idcurrency;
	}

	public void setIdcurrency(int idcurrency) {
		this.idcurrency = idcurrency;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "symbol", length = 25)
	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Column(name = "refcurrency", nullable = false)
	public boolean isRefcurrency() {
		return this.refcurrency;
	}

	public void setRefcurrency(boolean refcurrency) {
		this.refcurrency = refcurrency;
	}

	@Column(name = "rank")
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Column(name = "volumeeur", precision = 17, scale = 17)
	public Double getVolumeeur() {
		return this.volumeeur;
	}

	public void setVolumeeur(Double volumeeur) {
		this.volumeeur = volumeeur;
	}

	@Column(name = "volumeusd", precision = 17, scale = 17)
	public Double getVolumeusd() {
		return this.volumeusd;
	}

	public void setVolumeusd(Double volumeusd) {
		this.volumeusd = volumeusd;
	}

	@Column(name = "humannote", precision = 17, scale = 17)
	public Double getHumannote() {
		return this.humannote;
	}

	public void setHumannote(Double humannote) {
		this.humannote = humannote;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
	public Set<Orderhistorybot> getOrderhistorybots() {
		return this.orderhistorybots;
	}

	public void setOrderhistorybots(Set<Orderhistorybot> orderhistorybots) {
		this.orderhistorybots = orderhistorybots;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
	public Set<Currencyrate> getCurrencyrates() {
		return this.currencyrates;
	}

	public void setCurrencyrates(Set<Currencyrate> currencyrates) {
		this.currencyrates = currencyrates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
	public Set<Currencytrend> getCurrencytrends() {
		return this.currencytrends;
	}

	public void setCurrencytrends(Set<Currencytrend> currencytrends) {
		this.currencytrends = currencytrends;
	}

}