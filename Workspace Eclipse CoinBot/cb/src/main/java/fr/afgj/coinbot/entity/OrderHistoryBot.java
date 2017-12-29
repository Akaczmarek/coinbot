package fr.afgj.coinbot.entity;
// Generated 21 d�c. 2017 09:38:56 by Hibernate Tools 5.1.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Orderhistorybot generated by hbm2java
 */
@Entity
@Table(name = "orderhistorybot", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderHistoryBot implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Currency currency;
	private OrderType ordertype;
	private User user;
	private Date timestampsend;
	private Date timestampactivated;
	private Date timestampcancelled;
	private Date timestampfinished;
	private Double currencyvalue;
	private Double volume;
	private Double gainbtc;

	public OrderHistoryBot() {
	}

	public OrderHistoryBot(int id, Currency currency, User user) {
		this.id = id;
		this.currency = currency;
		this.user = user;
	}

	public OrderHistoryBot(int id, Currency currency, OrderType ordertype, User user, Date timestampsend,
			Date timestampactivated, Date timestampcancelled, Date timestampfinished, Double currencyvalue,
			Double volume, Double gainbtc) {
		this.id = id;
		this.currency = currency;
		this.ordertype = ordertype;
		this.user = user;
		this.timestampsend = timestampsend;
		this.timestampactivated = timestampactivated;
		this.timestampcancelled = timestampcancelled;
		this.timestampfinished = timestampfinished;
		this.currencyvalue = currencyvalue;
		this.volume = volume;
		this.gainbtc = gainbtc;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcurrency", nullable = false)
	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ordertype")
	public OrderType getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(OrderType ordertype) {
		this.ordertype = ordertype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestampsend", length = 29)
	public Date getTimestampsend() {
		return this.timestampsend;
	}

	public void setTimestampsend(Date timestampsend) {
		this.timestampsend = timestampsend;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestampactivated", length = 29)
	public Date getTimestampactivated() {
		return this.timestampactivated;
	}

	public void setTimestampactivated(Date timestampactivated) {
		this.timestampactivated = timestampactivated;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestampcancelled", length = 29)
	public Date getTimestampcancelled() {
		return this.timestampcancelled;
	}

	public void setTimestampcancelled(Date timestampcancelled) {
		this.timestampcancelled = timestampcancelled;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestampfinished", length = 29)
	public Date getTimestampfinished() {
		return this.timestampfinished;
	}

	public void setTimestampfinished(Date timestampfinished) {
		this.timestampfinished = timestampfinished;
	}

	@Column(name = "currencyvalue", precision = 17, scale = 17)
	public Double getCurrencyvalue() {
		return this.currencyvalue;
	}

	public void setCurrencyvalue(Double currencyvalue) {
		this.currencyvalue = currencyvalue;
	}

	@Column(name = "volume", precision = 17, scale = 17)
	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	@Column(name = "gainbtc", precision = 17, scale = 17)
	public Double getGainbtc() {
		return this.gainbtc;
	}

	public void setGainbtc(Double gainbtc) {
		this.gainbtc = gainbtc;
	}

}
