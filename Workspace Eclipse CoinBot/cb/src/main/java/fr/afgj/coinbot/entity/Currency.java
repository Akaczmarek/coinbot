package fr.afgj.coinbot.entity;
// Generated 21 d�c. 2017 09:38:56 by Hibernate Tools 5.1.6.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private Set<OrderHistoryBot> orderhistorybots = new HashSet<OrderHistoryBot>(0);
	private Set<CurrencyRate> currencyrates = new HashSet<CurrencyRate>(0);
	private Set<CurrencyTrend> currencytrends = new HashSet<CurrencyTrend>(0);
	// MIS EN COMM ALAIN 29/12
//	private List<CurrencyRate> currencyratesStudy = new ArrayList<CurrencyRate>();

	public Currency() {
	}

	public Currency(int idcurrency, boolean refcurrency) {
		this.idcurrency = idcurrency;
		this.refcurrency = refcurrency;
	}
	
	

	public Currency(int idcurrency, String name, String symbol, boolean refcurrency, Integer rank, Double volumeeur,
			Double volumeusd, Double humannote) {
		super();
		this.idcurrency = idcurrency;
		this.name = name;
		this.symbol = symbol;
		this.refcurrency = refcurrency;
		this.rank = rank;
		this.volumeeur = volumeeur;
		this.volumeusd = volumeusd;
		this.humannote = humannote;
	}

	public Currency(int idcurrency, String name, String symbol, boolean refcurrency, Integer rank, Double volumeeur,
			Double volumeusd, Double humannote, Set<OrderHistoryBot> orderhistorybots, Set<CurrencyRate> currencyrates,
			Set<CurrencyTrend> currencytrends) {
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public Set<OrderHistoryBot> getOrderhistorybots() {
		return this.orderhistorybots;
	}

	public void setOrderhistorybots(Set<OrderHistoryBot> orderhistorybots) {
		this.orderhistorybots = orderhistorybots;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
	public Set<CurrencyRate> getCurrencyrates() {
		return this.currencyrates;
	}

	public void setCurrencyrates(Set<CurrencyRate> currencyrates) {
		this.currencyrates = currencyrates;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
	public Set<CurrencyTrend> getCurrencytrends() {
		return this.currencytrends;
	}

	public void setCurrencytrends(Set<CurrencyTrend> currencytrends) {
		this.currencytrends = currencytrends;
	}
	// MIS EN COMM ALAIN 29/12
//
//	public List<CurrencyRate> getCurrencyratesStudy() {
//		return currencyratesStudy;
//	}
//
//	public void setCurrencyratesStudy(List<CurrencyRate> currencyratesStudy) {
//		this.currencyratesStudy = currencyratesStudy;
//	}
	
	
	

}
