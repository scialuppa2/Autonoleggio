package it.terzaFila.autonoleggio.entity;

import it.terzaFila.autonoleggio.Utente;

public class Cliente extends Utente{
	
	protected String nome;
	protected String cognome;
	
	public Cliente(String nome, String cognome, String username, String password, String ruolo) {
		super(username, password, ruolo);
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	
	

}
