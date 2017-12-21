package fr.afgj.coinbot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ApiKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 279415113186945651L;
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String apiKey;
	
	
	public ApiKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	
	
	
	

}
