package fr.afgj.coinbot.entity;
// Generated 21 d�c. 2017 09:38:56 by Hibernate Tools 5.1.6.Final

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afgj.coinbot.calculation.OperationsOnCurrencyTrend;

/**
 * Currencytrend generated by hbm2java
 */

@Entity
@Table(name = "currencytrend", schema = "public")
public class CurrencyTrend implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idtrend;
	private Currency currency;
	private Boolean lasttrendgrowing;
	private Integer lasttrendweight;
	private Date timerecord;
	private Double notetobuy;
	private Double notetosell;
	private Double valuebidbtc;
	private Double valueaskbtc;

	public CurrencyTrend() {
	}

	public CurrencyTrend(int idtrend) {
		this.idtrend = idtrend;
		// this.currency = currency;
	}

	public CurrencyTrend(int idtrend, Currency currency, Boolean lasttrendgrowing, Integer lasttrendweight,
			Date timerecord, Double notetobuy, Double notetosell, Double valuebidbtc, Double valueaskbtc) {
		this.idtrend = idtrend;
		this.currency = currency;
		this.lasttrendgrowing = lasttrendgrowing;
		this.lasttrendweight = lasttrendweight;
		this.timerecord = timerecord;
		this.notetobuy = notetobuy;
		this.notetosell = notetosell;
		this.valuebidbtc = valuebidbtc;
		this.valueaskbtc = valueaskbtc;
	}

	@Id

	@Column(name = "idtrend", unique = true, nullable = false)
	public int getIdtrend() {
		return this.idtrend;
	}

	public void setIdtrend(int idtrend) {
		this.idtrend = idtrend;
	}

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "idcurrency", nullable = false)
	 public Currency getCurrency() {
	 return this.currency;
	 }

	 public void setCurrency(Currency currency) {
	 this.currency = currency;
	 }

	@Column(name = "lasttrendgrowing")
	public Boolean getLasttrendgrowing() {
		return this.lasttrendgrowing;
	}

	public void setLasttrendgrowing(Boolean lasttrendgrowing) {
		this.lasttrendgrowing = lasttrendgrowing;
	}

	@Column(name = "lasttrendweight")
	public Integer getLasttrendweight() {
		return this.lasttrendweight;
	}

	public void setLasttrendweight(Integer lasttrendweight) {
		this.lasttrendweight = lasttrendweight;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timerecord", length = 29)
	public Date getTimerecord() {
		return this.timerecord;
	}

	public void setTimerecord(Date timerecord) {
		this.timerecord = timerecord;
	}

	@Column(name = "notetobuy", precision = 17, scale = 17)
	public Double getNotetobuy() {
		return this.notetobuy;
	}

	public void setNotetobuy(Double notetobuy) {
		this.notetobuy = notetobuy;
	}

	@Column(name = "notetosell", precision = 17, scale = 17)
	public Double getNotetosell() {
		return this.notetosell;
	}

	public void setNotetosell(Double notetosell) {
		this.notetosell = notetosell;
	}

	@Column(name = "valuebidbtc", precision = 17, scale = 17)
	public Double getValuebidbtc() {
		return this.valuebidbtc;
	}

	public void setValuebidbtc(Double valuebidbtc) {
		this.valuebidbtc = valuebidbtc;
	}

	@Column(name = "valueaskbtc", precision = 17, scale = 17)
	public Double getValueaskbtc() {
		return this.valueaskbtc;
	}

	public void setValueaskbtc(Double valueaskbtc) {
		this.valueaskbtc = valueaskbtc;
	}


	// methods
	// ----------------------------------------------------------------------

	/*
	 * Mise à jour de la tendance de la devise
	 * return true si tout c'est bien passé, false sinon
	 * 
	 */
	public boolean updateCT() {
		List<CurrencyRate> crs = new ArrayList<>();
		OperationsOnCurrencyTrend ooct = new OperationsOnCurrencyTrend(crs, this);
		
		return false;
	}

	public volatile static Comparator<CurrencyTrend> CTNoteToBuyComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {
			// TODO Auto-generated method stub

			int noteCT1 = (int) (CT1.getNotetobuy() * 1000);
			int noteCT2 = (int) (CT2.getNotetobuy() * 1000);
			return noteCT2 - noteCT1;
		}
	};

	public volatile static Comparator<CurrencyTrend> CTNoteToSellComparator = new Comparator<CurrencyTrend>() {

		@Override
		public int compare(CurrencyTrend CT1, CurrencyTrend CT2) {

			int noteCT1 = (int) (CT1.getNotetosell() * 1000);
			int noteCT2 = (int) (CT2.getNotetosell() * 1000);
			return noteCT2 - noteCT1;

		}
	};

}
