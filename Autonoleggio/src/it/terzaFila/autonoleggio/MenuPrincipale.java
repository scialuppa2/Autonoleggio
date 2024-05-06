package it.terzaFila.autonoleggio;

import java.time.LocalDate;
import java.util.Scanner;

import it.terzaFila.autonoleggio.entity.Auto;



public class MenuPrincipale {

	public static void menuAccessoUtente() {

		Scanner scanner = new Scanner(System.in);
		
		boolean loggedIn = false; // ma serve?
		boolean ripeti = true;

		while (ripeti) {
			
			System.out.println("\r\n"
					+ "                _                    _                  _         _______                 ______ _ _       \r\n"
					+ "     /\\        | |                  | |                (_)       |__   __|               |  ____(_) |      \r\n"
					+ "    /  \\  _   _| |_ ___  _ __   ___ | | ___  __ _  __ _ _  ___      | | ___ _ __ ______ _| |__   _| | __ _ \r\n"
					+ "   / /\\ \\| | | | __/ _ \\| '_ \\ / _ \\| |/ _ \\/ _` |/ _` | |/ _ \\     | |/ _ \\ '__|_  / _` |  __| | | |/ _` |\r\n"
					+ "  / ____ \\ |_| | || (_) | | | | (_) | |  __/ (_| | (_| | | (_) |    | |  __/ |   / / (_| | |    | | | (_| |\r\n"
					+ " /_/    \\_\\__,_|\\__\\___/|_| |_|\\___/|_|\\___|\\__, |\\__, |_|\\___/     |_|\\___|_|  /___\\__,_|_|    |_|_|\\__,_|\r\n"
					+ "                                             __/ | __/ |                                                   \r\n"
					+ "                                            |___/ |___/                                                    \r\n"
					+ "");
			System.out.println("       Benvenuto !!!        ");
			System.out.println("============================");
			System.out.println("      Scegli un'opzione:    ");
			System.out.println("============================");
			System.out.println("1. Accedi");
			System.out.println("2. Registrati");
			System.out.println("_____________________________");
			System.out.println("0. Esci");


			int scelta = scanner.nextInt(); // se inserisci stringa da errore non gestito

			switch (scelta) {
          
			case 1:
				if (!loggedIn) {
					Login login = new Login();

				    login.accesso();
					loggedIn = true;
				} else {
					System.out.println("Sei già loggato!");
				}
				break;
				
			case 2:
				RegistrazioneCliente.registraCliente();
				break;
				
			default:
				System.out.println("Arrivederci!");
				//System.exit(0);
				return;			
			}
		}
		
		scanner.close();
	}

	
	public static void menuCliente() {

		Scanner scanner = new Scanner(System.in);
		Float prezzo = (float) 0;
		String modello = "";
		
		boolean ripeti = true;

		while (ripeti) {
			
			System.out.println("\n --- Cerca auto --- \n");
			System.out.println("Scegli un'opzione:");
			System.out.println("1. per prezzo");
			System.out.println("2. Modello");
			System.out.println("3. Torna al menù iniziale");
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
				
			case 3:
                menuAccessoUtente();
                break;
				
			default:
				System.out.println("Arrivederci!");
				//System.exit(0);
				return;			
			}
		}
		
		scanner.close();
	}
	
	public static void menuAdmin() {

		Scanner scanner = new Scanner(System.in);
		GestioneAuto gestioneAuto = new GestioneAuto("auto.txt");
		Float prezzo = (float) 0;
		String modello = "";
		
		boolean prenotata = false;
		LocalDate data = null;
		LocalDate durata = null;
		
		boolean ripeti = true;
		
		System.out.println("======================================");
        System.out.println("          Menu Gestione Auto:         ");
        System.out.println("======================================");

		while (ripeti) {
	        System.out.println("======================================");
	        System.out.println("         SCEGLI UN'OPERAZIONE         ");
	        System.out.println("======================================");
	        System.out.println("1. Stampare lista auto disponibili");
	        System.out.println("2. Aggiungi nuova auto");
	        System.out.println("3. Rimuovere un'auto dalla lista");
	        System.out.println("4. Torna al menù iniziale");
	        System.out.println("_______________________________________");
	        System.out.println("0. Esci dall'applicazione");

	        int scelta = scanner.nextInt();

	        switch (scelta) {
	            case 1:
	            	GestioneAuto.stampaListaAuto(false);
	                break;
	            case 2:
	            	GestioneAuto.aggiungiAuto();
	                break;
	            case 3:
	                GestioneAuto.rimuoviAuto();
	                break;
	            case 4:
	                menuAccessoUtente();
	                break;

	            case 0:
	                System.out.println("Grazie e arrivederci !");
	                ripeti = false;
	                break;
	            default:
	                System.out.println("Scelta non valida. Riprova.");
	                break;
	        }
	    }

	    scanner.close();
	}
	
	public static void menuBatman() {
	    Scanner scanner = new Scanner(System.in);
	    GestioneAuto gestioneAuto = new GestioneAuto("auto.txt");
	    Float prezzo = (float) 0;
	    String modello = "";

	    boolean prenotata = false;
	    LocalDate data = null;
	    LocalDate durata = null;

	    boolean ripeti = true;

	    System.out.println("======================================");
	    System.out.println("          BENTORNATO BATMAN:         ");
	    System.out.println("======================================");
	    System.out.println("⠈⠙⠲⢶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣿⡀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⡄⠀⠀⠀⠀⠀⠀⠀⣼⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣿⠟⠓⠉\r\n"
	    		+ "⠀⠀⠀⠀⠈⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⢀⣧⣶⣦⣇⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠉⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣾⣿⣿⣿⣿⣶⣶⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠛⠛⠛⠛⠛⠛⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠟⠛⠛⠛⠛⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	    		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
	    while (ripeti) {
	    	System.out.println("========================================");
		    System.out.println("          SCEGLI UN'OPERAZIONE:         ");
		    System.out.println("========================================");
	        System.out.println("1. Stampare lista auto disponibili");
	        System.out.println("2. Aggiungi nuova batmobile");
	        System.out.println("3. Rimuovere una batmobile dalla lista");
	        System.out.println("4. Torna al menù iniziale");
	        System.out.println("________________________________________");
	        System.out.println("0. Esci dall'applicazione");

	        int scelta = scanner.nextInt();

	        switch (scelta) {
	            case 1:
	                GestioneAuto.stampaListaAuto(true);
	                break;
	            case 2:
	                GestioneAuto.aggiungiBatmobile();
	                break;
	            case 3:
	                GestioneAuto.rimuoviAuto();
	                break;
	            case 4:
	                menuAccessoUtente();
	                break;
	            case 0:
	                System.out.println("Grazie e arrivederci !");
	                ripeti = false;
	                break;
	            default:
	                System.out.println("Scelta non valida. Riprova.");
	                break;
	        }
	    }
	}


}


