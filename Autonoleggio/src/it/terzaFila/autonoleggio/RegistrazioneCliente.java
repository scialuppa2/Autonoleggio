package it.terzaFila.autonoleggio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistrazioneCliente {
    
    public static void registraCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ciao nuovo cliente !");
        System.out.println("Inserisci i tuoi dati per la registrazione:");

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

     // Scrivi i dati completi del cliente su un file di testo separato
        try {
            PrintWriter clientiWriter = new PrintWriter(new FileWriter("utenti.txt", true));
            clientiWriter.println(nome + "," + cognome + "," + email + "," + password);
            clientiWriter.println(); // Aggiungi una riga vuota per separare i dati
            clientiWriter.close();
            System.out.println("Registrazione completata! I tuoi dati sono stati salvati.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il salvataggio dei dati del cliente.");
            e.printStackTrace();
        }


        /* Scrivi solo email e password su un file separato per le credenziali
        try {
            PrintWriter utentiWriter = new PrintWriter(new FileWriter("utenti.txt", true));
            utentiWriter.println(email + ":" + password);
            utentiWriter.close();
            System.out.println("Le credenziali sono state salvate.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il salvataggio delle credenziali.");
            e.printStackTrace();
        }*/

    }
}
