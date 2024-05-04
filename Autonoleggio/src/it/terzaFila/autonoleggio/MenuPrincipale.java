package it.terzaFila.autonoleggio;

import java.time.LocalDate;
import java.util.Scanner;

import it.terzaFila.autonoleggio.entity.Auto;

public class MenuPrincipale {

	public void menuAccessoUtente() {

		Scanner scanner = new Scanner(System.in);
		
		boolean loggedIn = false; // ma serve?
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
	
	public void menuAdmin() {

		Scanner scanner = new Scanner(System.in);
		Float prezzo = (float) 0;
		String modello = "";
		
		boolean prenotata = false;
		LocalDate data = null;
		LocalDate durata = null;
		
		boolean ripeti = true;

		while (ripeti) {
			
			System.out.println("\n --- Gestisci auto --- \n");
			System.out.println("Scegli un'opzione:");
			System.out.println("1. carica auto");
			System.out.println("2. salva auto");
			System.out.println("3. inserisci auto");
			System.out.println("4. elimina auto");
			System.out.println("0. Esci");

			int scelta = scanner.nextInt();

			switch (scelta) {
			
			case 1:
				System.out.println("Leggo auto.txt");
				
				/* TODO 
				 *  (boolean)  if (loadAuto("auto.txt")){
				 *  	System.out.println("caricamento effettuato");
				 *  }
				 *  	implementare try catch nel metodo (IOException FileNotFoundException  )	    
				 * 		
				 */
				break;
				
				case 2:
					System.out.println("Salvatagio auto.txt");
					
					/* TODO 
					 *  (boolean)  if (saveAuto("auto.txt")){
					 *  	System.out.println("salvataggio effettuato");
					 *  }
					 *  	implementare try catch nel metodo (IOException FileNotFoundException  )	    
					 * 		
					 */
					break;
				
				case 3:
					System.out.println("Aggiungi auto in lista");
					
					modello = scanner.nextLine();
					prezzo = scanner.nextFloat();
					
					//metodo set
					Auto auto = new Auto(modello, prezzo);
					// getListAuto.add(auto);
					
					
					/* TODO 
					 *  (boolean)  if (addAuto()){
					 *  	System.out.println("aggiunta effettuata");
					 *  }
					 *  	   
					 * 		
					 */
					break;
				
				case 4:
					System.out.println("Elimina auto in lista");
					
					int numero = scanner.nextInt();
					//getListaAuto.remove();
					
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
