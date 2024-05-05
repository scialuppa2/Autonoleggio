package it.terzaFila.autonoleggio;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Login {

	private static final String FILE_UTENTI = "utenti.txt";
	private HashMap<String, String[]> credenziali;

	public Login() {
		credenziali = LeggiCredenziali();
	}

	public void accesso() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci email:");
		String email = scanner.nextLine();
		System.out.println("Inserisci password:");
		String password = scanner.nextLine();

		// Verifica se l'email è presente nelle credenziali
		if (credenziali.containsKey(email)) {
			// Se l'email è presente, verifica se la password corrisponde
			String[] credenzialiUtente = credenziali.get(email);
			String passwordStored = credenzialiUtente[1]; // Password salvata per l'email specificata
			String ruolo = credenzialiUtente[2]; // Ruolo dell'utente

			if (passwordStored.equals(password)) {
				System.out.println("Accesso riuscito!");
				boolean isBatman = ruolo.equals("batman"); // Determina se l'utente è Batman
				// Verifica il ruolo e indirizza l'utente al menu appropriato
				if (ruolo.equals("user")) {
					// Utente normale
					// Esegui le azioni necessarie per il menu dell'utente
					MenuPrincipale.menuCliente();
				} else if (ruolo.equals("admin")) {
					// Admin
					// Esegui le azioni necessarie per il menu dell'admin
					MenuPrincipale.menuAdmin();
				} else if (ruolo.equals("batman")) {
					// Batman
					// Esegui le azioni necessarie per il menu di batman
					MenuPrincipale.menuBatman();
					// Passa il valore di isBatman al metodo stampaListaAuto() solo se l'utente è
					// Batman
					GestioneAuto.stampaListaAuto(true);
				}
			} else {
				System.out.println("Password errata. Accesso negato.");
				accesso();
			}
		} else {
			System.out.println("Email non trovata. Accesso negato.");
			accesso();
		}

	}

	private static HashMap<String, String[]> LeggiCredenziali() {
		HashMap<String, String[]> credenziali = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_UTENTI))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 5) { // Controlla se ci sono tutti e 5 i campi
					String email = parts[2].trim();
					String password = parts[3].trim();
					String ruolo = parts[4].trim();
					// Crea un array contenente email, password e ruolo
					String[] credenzialiUtente = { email, password, ruolo };
					credenziali.put(email, credenzialiUtente);
				}
			}
		} catch (IOException e) {
			System.out.println("Si è verificato un errore durante la lettura del file: " + e.getMessage());
		}
		return credenziali;
	}

}
