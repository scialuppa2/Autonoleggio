package it.terzaFila.autonoleggio;

import java.util.Scanner;

public class MenuPrincipale {

	public void menuAccessoUtente() {

		Scanner scanner = new Scanner(System.in);
		
		boolean loggedIn = false;
		boolean ripeti = true;

		while (ripeti) {
			
			System.out.println("\n ---Benvenuto nell'autonoleggio!--- \n");
			System.out.println("Scegli un'opzione:");
			System.out.println("1. Accedi");
			System.out.println("2. Registrati");
			System.out.println("0. Esci");

			int scelta = scanner.nextInt();

			switch (scelta) {
			
			case 1:
				if (!loggedIn) {
					accedi();
					loggedIn = true;
				} else {
					System.out.println("Sei già loggato!");
				}
				break;
				
			case 2:
				registrati();
				break;
				
			default:
				System.out.println("Arrivederci!");
				//System.exit(0);
				return;			
			}
		}
		
		scanner.close();
	}

	
	public void menuCliente() {

		Scanner scanner = new Scanner(System.in);
		Float prezzo = (float) 0;
		String modello = "";
		
		boolean ripeti = true;

		while (ripeti) {
			
			System.out.println("\n --- Cerca auto --- \n");
			System.out.println("Scegli un'opzione:");
			System.out.println("1. per prezzo");
			System.out.println("2. Modello");
			System.out.println("0. Esci");

			int scelta = scanner.nextInt();

			switch (scelta) {
			
			case 1:
				System.out.println("Inserisci Prezzo");
				prezzo = scanner.nextFloat();
				// TODO ricerca(prezzo);
				break;
				
			case 2:
				System.out.println("Inserisci modello");
				modello = scanner.nextLine();
				// TODO ricerca(modello);
				break;
				
			default:
				System.out.println("Arrivederci!");
				//System.exit(0);
				return;			
			}
		}
		
		scanner.close();
	}

	
	
	public static void accedi() {
		// Qui implementa la logica per l'accesso
		System.out.println("Hai effettuato l'accesso con successo!");
	}

	public static void registrati() {
		// Qui implementa la logica per la registrazione
		System.out.println("Registrazione completata con successo!");
	}

}
