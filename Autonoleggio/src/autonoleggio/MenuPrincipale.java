package autonoleggio;

import java.util.Scanner;

public class MenuPrincipale {

	public void menuAccessoUtente() {

		Scanner scanner = new Scanner(System.in);
		
		boolean loggedIn = false;

		while (true) {
			System.out.println("Benvenuto nell'autonoleggio!");
			System.out.println("Scegli un'opzione:");
			System.out.println("1. Accedi");
			System.out.println("2. Registrati");
			System.out.println("3. Esci");

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
			case 3:
				System.out.println("Arrivederci!");
				System.exit(0);
			default:
				System.out.println("Scelta non valida. Riprova.");
			}
		}
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
