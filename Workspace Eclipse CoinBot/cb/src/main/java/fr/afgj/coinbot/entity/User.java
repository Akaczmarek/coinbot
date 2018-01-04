package fr.afgj.coinbot.entity;
// Generated 21 d�c. 2017 09:38:56 by Hibernate Tools 5.1.6.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", schema = "public")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Expose
	private int id;
	@Expose
	private String firstname;
	@Expose
	private String lastname;
	@Expose
	private String pseudo;
	@Expose
	private String mail;
	@Expose
	private String password;

	private UserConfiguration userconfiguration;

	private ApiKey apikey;
	private Set<OrderHistoryBot> orderhistorybots = new HashSet<OrderHistoryBot>(0);

	public User() {
	}

	public User(String firstname, String lastname, String pseudo, String mail, String password,
			UserConfiguration userconfiguration, ApiKey apikey, Set<OrderHistoryBot> orderhistorybots) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.pseudo = pseudo;
		this.mail = mail;
		this.password = password;
		this.userconfiguration = userconfiguration;
		this.apikey = apikey;
		this.orderhistorybots = orderhistorybots;
	}

	public User(int id, String firstname, String lastname, String mail, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.password = password;

	}

	public User(int id, String firstname, String lastname, String pseudo, String mail, String password,
			UserConfiguration userconfiguration, ApiKey apikey, Set<OrderHistoryBot> orderhistorybots) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.pseudo = pseudo;
		this.mail = mail;
		this.password = password;
		this.userconfiguration = userconfiguration;
		this.apikey = apikey;
		this.orderhistorybots = orderhistorybots;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "firstname", nullable = false, length = 40)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = false, length = 40)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "pseudo", length = 50)
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Column(name = "mail", nullable = false, length = 250)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public UserConfiguration getUserconfiguration() {
		return this.userconfiguration;
	}

	public void setUserconfiguration(UserConfiguration userconfiguration) {
		this.userconfiguration = userconfiguration;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public ApiKey getApikey() {
		return this.apikey;
	}

	public void setApikey(ApiKey apikey) {
		this.apikey = apikey;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<OrderHistoryBot> getOrderhistorybots() {
		return this.orderhistorybots;
	}

	public void setOrderhistorybots(Set<OrderHistoryBot> orderhistorybots) {
		this.orderhistorybots = orderhistorybots;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", password=");
		builder.append(password);
		builder.append(", userconfiguration=");
		builder.append(userconfiguration);
		builder.append(", apikey=");
		builder.append(apikey);
		builder.append("]");
		return builder.toString();
	}

}
