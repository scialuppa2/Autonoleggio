package it.terzaFila.autonoleggio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.terzaFila.autonoleggio.entity.Auto;

public class GestioneAuto {
    private static String FILE_PATH = "auto.txt";
	private static List<Auto> autoList;

	public GestioneAuto(String FILE_PATH) {
		this.FILE_PATH = FILE_PATH;
		this.autoList = new ArrayList<>();
		leggiAutoDaFile();
	}

	private void leggiAutoDaFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				int idAuto = Integer.parseInt(parts[0].trim());
                String marchio = parts[1].trim(); 
				String modello = parts[2].trim();
				float prezzo = Float.parseFloat(parts[3].trim());
				boolean prenotata = Boolean.parseBoolean(parts[4].trim());

				Auto auto = new Auto(idAuto, marchio, modello, prezzo);
				auto.setPrenotata(prenotata);
				autoList.add(auto);
			}
		} catch (IOException e) {
			System.out.println("Si è verificato un errore durante la lettura del file: " + e.getMessage());
		}
	}

	public static void stampaListaAuto() {
		System.out.println("==============================================");
		System.out.println("         Lista delle auto disponibili:        ");
		System.out.println("==============================================");

		for (Auto auto : autoList) {
			System.out.println(auto);
		}
	}

	public static void aggiungiAuto() {
		Scanner scanner = new Scanner(System.in);

		// Richiesta dei dati per la nuova auto
		System.out.println("Inserisci l'ID dell'auto:");
        int idAuto = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline

        System.out.println("Inserisci il marchio dell'auto:");
        String marchio = scanner.nextLine();
        
		System.out.println("Inserisci il modello dell'auto:");
		String modello = scanner.nextLine();

		System.out.println("Inserisci il prezzo dell'auto:");
		float prezzo = scanner.nextFloat();

		// Creazione dell'oggetto Auto con i dati inseriti dall'utente
		Auto nuovaAuto = new Auto(idAuto, marchio, modello, prezzo);

		// Aggiunta della nuova auto alla lista
		autoList.add(nuovaAuto);

		// Salvataggio delle modifiche su file
		salvaAutoSuFile();

	}

	public static void rimuoviAuto() {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Inserisci il numero identificativo dell'auto da rimuovere:");
	    int idAuto = scanner.nextInt();

	    
	    // Verifica se esiste un'auto con il modello specificato
	    boolean autoTrovata = false;
	    for (Auto auto : autoList) {
	        if (auto.getIdAuto() == idAuto) {
	            autoTrovata = true;
	            autoList.remove(auto);
	            System.out.println("Auto con identificativo" + idAuto + "rimossa con successo.");
	            break;
	        }
	    }
	    
	    // Se non è stata trovata un'auto con l'ID specificato
	    if (!autoTrovata) {
	        System.out.println("Nessuna auto trovata con l'ID specificato: " + idAuto);
	    }
	    
	    // Salvataggio delle modifiche su file
	    salvaAutoSuFile();
	    
	}


	private static void salvaAutoSuFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Auto auto : autoList) {
                writer.println(auto.getIdAuto() + "," + auto.getMarchio() + "," + auto.getModello() + "," + auto.getPrezzo() + "," + auto.isPrenotata());
            }
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il salvataggio delle auto su file: " + e.getMessage());
        }
    }
}