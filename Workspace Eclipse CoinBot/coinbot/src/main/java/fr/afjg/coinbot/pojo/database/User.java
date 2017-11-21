package fr.afjg.coinbot.pojo.database;

public class User {

	private int idUser;
	private String firstName;
	private String lastName;
	private String mail;
	private String apiKey;
	private UserConfiguration config;

	public User() {

	}

	// getter & setters-------------------------------------------------------------

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public UserConfiguration getConfig() {
		return config;
	}

	public void setConfig(UserConfiguration config) {
		this.config = config;
	}
	

}
