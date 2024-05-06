package it.terzaFila.autonoleggio;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import it.terzaFila.autonoleggio.entity.Auto;

public class MenuPrincipale {

	public static void menuAccessoUtente() {

		Scanner scanner = new Scanner(System.in);

		boolean loggedIn = false; // ma serve?
		boolean ripeti = true;
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

		while (ripeti) {

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
			case 0:
				System.out.println("Arrivederci!");
				System.exit(0);
			default:
				System.err.println("Scelta non valida. Riprova!");
//				return;
			}
		}

		scanner.close();
	}

	public static void menuCliente() {
		Scanner scanner = new Scanner(System.in);
		Float prezzo = (float) 0;
		String modello = "";
		// Creare un'istanza di GestioneAuto

		GestioneAuto gestioneAuto = new GestioneAuto("auto.txt");

		boolean ripeti = true;
		System.out.println("========================================");
		System.out.println("      RICERCA L'AUTO DA NOLEGGIARE      ");
		System.out.println("========================================");

		while (ripeti) {
			System.out.println("==========================");
			System.out.println("    Scegli un'opzione:   ");
			System.out.println("==========================");
			System.out.println("1. Stampa lista auto  ");
			System.out.println("2. Cerca auto per prezzo ");
			System.out.println("3. Cerca auto per modello ");
			System.out.println("__________________________");
			System.out.println("0. Esci");

			int scelta = scanner.nextInt();

			switch (scelta) {

			case 1:
				GestioneAuto.stampaListaAuto(false);

				gestioneNoleggio(GestioneAuto.autoList, scanner);
				break;
			case 2:
				System.out.println("Inserisci Prezzo:");
				prezzo = scanner.nextFloat();
				scanner.nextLine();

				List<Auto> autoPerPrezzo = gestioneAuto.findPrice(prezzo);
				stampaRicercaAuto(autoPerPrezzo);
				gestioneNoleggio(autoPerPrezzo, scanner); // Corretto il passaggio dei risultati della ricerca

				break;

			case 3:
				scanner.nextLine();
				System.out.println("Inserisci Modello:");
				modello = scanner.nextLine();
				List<Auto> autoPerModello = gestioneAuto.findModel(modello);
				stampaRicercaAuto(autoPerModello);
				gestioneNoleggio(autoPerModello, scanner); // Corretto il passaggio dei risultati della ricerca
				break;
			case 0:
				System.out.println("Arrivederci!");
				System.exit(0);

			default:
				System.err.println("Scelta non valida. Riprova!");
//				return;
			}
		}

		scanner.close();
	}

	public static void menuAdmin() {

		Scanner scanner = new Scanner(System.in);
		GestioneAuto gestioneAuto = new GestioneAuto("auto.txt");
/*		Float prezzo = (float) 0;
		String modello = "";

		boolean prenotata = false;
		LocalDate data = null;
		LocalDate durata = null;*/

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
				System.out.println("Arrivederci!");
				System.exit(0);

				break;
			default:
				System.err.println("Scelta non valida. Riprova!");
				break;
				
				
			}
		}

		scanner.close();
	}

	public static void menuBatman() {

		Scanner scanner = new Scanner(System.in);
		GestioneAuto gestioneAuto = new GestioneAuto("auto.txt");
//		Float prezzo = (float) 0;
//		String modello = "";
//
//		boolean prenotata = false;
//		LocalDate data = null;
//		LocalDate durata = null;

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
				System.out.println("Arrivederci!");
				System.exit(0);
//				break;
			default:
				System.err.println("Scelta non valida. Riprova!");
				break;
			}
		}
	}

	private static void stampaRicercaAuto(List<Auto> autoList) {
		System.out.println("\n Risultati della ricerca: \n");
		if (autoList.isEmpty()) {
			System.out.println("Nessun risultato trovato.");
		} else {
			for (Auto auto : autoList) {
				System.out.println(auto);
			}
		}
	}

	private static void gestioneNoleggio(List<Auto> risultatiRicerca, Scanner scanner) {
		System.out.println("_________________________________");
		System.out.println("Desideri noleggiare un'auto? (S/N)");
		String risposta = scanner.next();
		if (risposta.equalsIgnoreCase("S")) {
			System.out.println("Inserisci l'ID dell'auto da noleggiare:");
			int idAuto = scanner.nextInt();

			// Consuma il carattere di nuova riga rimanente nel buffer
			scanner.nextLine();

			// Ottenere le date di inizio e fine noleggio dall'utente
			System.out.println("Inserisci la data di inizio noleggio (DD/MM/YYYY):");

			LocalDate dataInizio = Auto.stringToDate(scanner.nextLine());

			System.out.println("Inserisci la durata del noleggio in giorni");
			Integer dataFine = Integer.valueOf(scanner.nextInt());

			for (Auto auto : risultatiRicerca) {

				if (auto.getIdAuto() == idAuto) {
					if (!auto.isPrenotata()) { /* !GestioneAuto.isDisponible(auto, dataInizio, dataFine */

						// Segna l'auto come prenotata e salva le modifiche
						auto.setPrenotata(true);

						auto.setData(dataInizio); // Imposta la data di inizio noleggio
						auto.setDurata(dataFine); // Imposta la data di fine noleggio
						System.out.println("Auto noleggiata con successo!");

						// Salva le modifiche nel file auto.txt
						GestioneAuto.salvaAutoSuFile();

						return;
					} else {
						System.out.println("Questa auto è già stata noleggiata.");
						return;
					}
				}
			}
			System.out.println("Nessuna auto trovata con l'ID specificato.");
		}
	}

}
