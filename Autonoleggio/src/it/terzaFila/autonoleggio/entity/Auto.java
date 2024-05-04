package it.terzaFila.autonoleggio.entity;

import java.time.LocalDate;


	// 6/5 come consegna voglio il link e il jar file dell'eseguibile

	//siete una software house e venite incaricati di sviluppare un autonoleggio. questo autonoleggio presenta due attori:
	// il manager che può inserire auto 
	//e rimuoverle (e anche effettuare ricerche)
	//e il cliente: il cliente può noleggiare un'auto 
	//(quindi ci sarà uno stato noleggiata a true o false), 
	//effettuare una ricerca per prezzo o per nome auto. 
	//una volta che un'auto è noleggiata fino a quando non si restituisce
	//non può essere noleggiata da qualcun altro.
	// il twist: in realtà questo autonoleggio 
	//è una base segreta di batman e inserendo il suo nome 
	//e una password compare la batmobile che non è visibile a nessun altro. Batman può aggiungere o rimuovere nuove batmobili.
	//auto: modello - prezzo - tipo(b/n) - quantità - data - inizio - durate
	//utenti: user - pass - generalità - flag (c,m,b)
	


public class Auto {
	
	protected String modello;
	protected float prezzo;
	protected boolean batman;	
	protected boolean prenotata;
	protected LocalDate data;
	protected LocalDate durata;
	
	public Auto(String modello, float prezzo, boolean batman) {
		
		this.modello = modello;
		this.prezzo = prezzo;
		this.batman = batman;		
		
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isBatman() {
		return batman;
	}

	public void setBatman(boolean batman) {
		this.batman = batman;
	}

	public boolean isPrenotata() {
		return prenotata;
	}

	public void setPrenotata(boolean prenotata) {
		this.prenotata = prenotata;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(String data) {
		this.data = this.stringToDate(data);
	}

	public LocalDate getDurata() {
		return durata;
	}

	public void setDurata(LocalDate durata) {
		this.durata = durata;
	}
	
	public String dateToString(LocalDate data) {
		
		return data.getDayOfMonth() + "/" + data.getMonth() + "/" + data.getYear();
 		
	}
	
public LocalDate stringToDate(String data) {
	
		Integer dd = Integer.valueOf(data.split("/")[0]) ;
		Integer mm = Integer.valueOf(data.split("/")[1]) ;
		Integer yyyy = Integer.valueOf(data.split("/")[2]) ;		
		
		return LocalDate.of(yyyy, mm, dd);
 		
	}
	
	public String toString() {
		
		return this.modello + "," + this.prezzo + "," + this.batman + "," + this.prenotata + "," + this.dateToString(this.data) + "," + this.durata.getDayOfYear();
		
		
	}


}
