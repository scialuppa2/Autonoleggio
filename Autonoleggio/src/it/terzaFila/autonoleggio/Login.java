package it.terzaFila.autonoleggio;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login {

    private static final String FILE_UTENTI = "utenti.txt";
    private HashMap<String, String> credenziali;
    
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
            if (credenziali.get(email).equals(password)) {
                System.out.println("Accesso riuscito!");
                // Indirizza l'utente al menu appropriato
                // Esegui le azioni necessarie per il menu
            } else {
                System.out.println("Password errata. Accesso negato.");
            }
        } else {
            System.out.println("Email non trovata. Accesso negato.");
        }
    }

    private static HashMap<String, String> LeggiCredenziali() {
    	HashMap<String, String> credenziali = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_UTENTI))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String email = parts[2].trim();
                    String password = parts[3].trim();
                    credenziali.put(email, password);
                }
            }
         // Stampa il contenuto della mappa
            for (Map.Entry<String, String> entry : credenziali.entrySet()) {
                String email = entry.getKey();
                String password = entry.getValue();
                System.out.println("Email: " + email + ", Password: " + password);
            }
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la lettura del file: " + e.getMessage());
        }
        return credenziali;
    }
}
