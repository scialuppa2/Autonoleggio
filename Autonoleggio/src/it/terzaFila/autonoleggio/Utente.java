package it.terzaFila.autonoleggio;

public class Utente {
	//Attributi
	protected String email;
	protected String password;
	protected String ruolo;
	
	//Costruttore
	public Utente(String email, String password, String ruolo) {
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
	
	
	

}
