package fr.afgj.coinbot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 2381775979321782950L;
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String lastname;
	@Column
	private String firstname;
	@Column
	private String pseudo;
	@Column
	private String mail;
	@Column
	private String password;

	public User() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(lastname);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}
