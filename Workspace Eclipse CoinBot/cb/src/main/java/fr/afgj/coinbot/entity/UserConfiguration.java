package fr.afgj.coinbot.entity;
// Generated 21 d�c. 2017 09:38:56 by Hibernate Tools 5.1.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.google.gson.annotations.Expose;

/**
 * Userconfiguration generated by hbm2java
 */
@Entity
@Table(name = "userconfiguration", schema = "public")
public class UserConfiguration implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Expose
	private int id;
	@Expose
	private User user;
	@Expose
	private Double betvalue;
	@Expose
	private Double securevalue;
	@Expose
	private Integer risklevel;
	@Expose
	private Boolean stopbotafter;
	@Expose
	private Boolean stopbot;
	@Expose
	private Integer daysordersbloqued;
	@Expose
	private Integer daysoneorderbloqued;
	@Expose
	private Double betfraction;

	public UserConfiguration() {
	}

	public UserConfiguration(User user) {
		this.user = user;
	}

	public UserConfiguration(User user, Double betvalue) {
		super();
		this.user = user;
		this.betvalue = betvalue;
	}

	public UserConfiguration(User user, Double betvalue, Double securevalue, Integer risklevel, Boolean stopbotafter,
			Boolean stopbot, Integer daysordersbloqued, Integer daysoneorderbloqued) {
		this.user = user;
		this.betvalue = betvalue;
		this.securevalue = securevalue;
		this.risklevel = risklevel;
		this.stopbotafter = stopbotafter;
		this.stopbot = stopbot;
		this.daysordersbloqued = daysordersbloqued;
		this.daysoneorderbloqued = daysoneorderbloqued;
	}
	
	

	public UserConfiguration(User user, Double betvalue, Double securevalue, Integer risklevel, Boolean stopbotafter,
			Boolean stopbot, Integer daysordersbloqued, Integer daysoneorderbloqued, Double betfraction) {
		super();
		this.user = user;
		this.betvalue = betvalue;
		this.securevalue = securevalue;
		this.risklevel = risklevel;
		this.stopbotafter = stopbotafter;
		this.stopbot = stopbot;
		this.daysordersbloqued = daysordersbloqued;
		this.daysoneorderbloqued = daysoneorderbloqued;
		this.betfraction = betfraction;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "betvalue", precision = 17, scale = 17)
	public Double getBetvalue() {
		return this.betvalue;
	}

	public void setBetvalue(Double betvalue) {
		this.betvalue = betvalue;
	}

	@Column(name = "securevalue", precision = 17, scale = 17)
	public Double getSecurevalue() {
		return this.securevalue;
	}

	public void setSecurevalue(Double securevalue) {
		this.securevalue = securevalue;
	}

	@Column(name = "risklevel")
	public Integer getRisklevel() {
		return this.risklevel;
	}

	public void setRisklevel(Integer risklevel) {
		this.risklevel = risklevel;
	}

	@Column(name = "stopbotafter")
	public Boolean getStopbotafter() {
		return this.stopbotafter;
	}

	public void setStopbotafter(Boolean stopbotafter) {
		this.stopbotafter = stopbotafter;
	}

	@Column(name = "stopbot")
	public Boolean getStopbot() {
		return this.stopbot;
	}

	public void setStopbot(Boolean stopbot) {
		this.stopbot = stopbot;
	}

	@Column(name = "daysordersbloqued")
	public Integer getDaysordersbloqued() {
		return this.daysordersbloqued;
	}

	public void setDaysordersbloqued(Integer daysordersbloqued) {
		this.daysordersbloqued = daysordersbloqued;
	}

	@Column(name = "daysoneorderbloqued")
	public Integer getDaysoneorderbloqued() {
		return this.daysoneorderbloqued;
	}

	public void setDaysoneorderbloqued(Integer daysoneorderbloqued) {
		this.daysoneorderbloqued = daysoneorderbloqued;
	}

	@Column(name = "betfraction")
	public Double getBetfraction() {
		return betfraction;
	}

	public void setBetfraction(Double betfraction) {
		this.betfraction = betfraction;
	}
	
	

}
