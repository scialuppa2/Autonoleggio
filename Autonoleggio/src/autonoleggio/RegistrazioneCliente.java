package autonoleggio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistrazioneCliente {
    
    public static void registraCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto! Inserisci i tuoi dati per la registrazione:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        nome = InputValidator.formattaNome(nome); // Applica la formattazione del nome
        while (!InputValidator.validaNome(nome)) {
            System.out.println("Il nome non è valido. Inserisci un nome valido:");
            nome = scanner.nextLine();
            nome = InputValidator.formattaNome(nome); // Applica la formattazione del nome
        }

        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();
        cognome = InputValidator.formattaNome(cognome); // Applica la formattazione del cognome
        while (!InputValidator.validaCognome(cognome)) {
            System.out.println("Il cognome non è valido. Inserisci un cognome valido:");
            cognome = scanner.nextLine();
            cognome = InputValidator.formattaNome(cognome); // Applica la formattazione del cognome
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();
        while (!InputValidator.validaEmail(email)) {
            System.out.println("L'email non è valida. Inserisci un'email valida:");
            email = scanner.nextLine();
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();
        while (!InputValidator.validaPassword(password)) {
            System.out.println("La password non è valida. Inserisci una password valida (almeno 8 caratteri):");
            password = scanner.nextLine();
        }

        // Scrivi i dati su un file di testo
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("clienti.txt", true));
            writer.println("Nome: " + nome);
            writer.println("Cognome: " + cognome);
            writer.println("Email: " + email);
            writer.println("Password: " + password);
            writer.println(); // Aggiungi una riga vuota per separare i dati
            writer.close();
            System.out.println("Registrazione completata! I dati sono stati salvati.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il salvataggio dei dati.");
            e.printStackTrace();
        }
    }
}
