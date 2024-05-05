package it.terzaFila.autonoleggio;

import java.util.List;
import java.util.regex.Pattern;

import it.terzaFila.autonoleggio.entity.Auto;

public class InputValidator {

	public static boolean validaNome(String nome) {
        return nome.matches("[A-Z][a-zA-Z]*");
    }

	public static boolean validaCognome(String cognome) {
	    return cognome.matches("[A-Z][a-zA-Z'\\s]+");
	}
    
    public static String formattaNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            return nome;
        }
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }
    
    public static boolean validaEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(regex).matcher(email).matches();
    }
    
    public static boolean validaPassword(String password) {
        return password.length() >= 8;
    }
    
    public static boolean verificaIdAuto(List<Auto> autoList, int idAuto) {
        for (Auto auto : autoList) {
            if (auto.getIdAuto() == idAuto) {
                return true; // L'ID auto esiste già
            }
        }
        return false; // L'ID auto non esiste
    }

    
}
