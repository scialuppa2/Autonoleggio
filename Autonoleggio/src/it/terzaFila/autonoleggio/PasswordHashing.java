package it.terzaFila.autonoleggio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {

	public static String hashPassword(String password) {
		try {
			// Creiamo una MessageDigest instance per SHA-256
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			// System.out.println("istanza di SHA-256 creata");
			byte[] encodedhash = digest.digest(password.getBytes());
			// System.out.println("password hashata, array di byte generato");
			// Convertiamo l'array di byte in una stringa esadecimale
//	            for(byte b : encodedhash) {
//	                System.out.format("%02x", b);
//	            }
			StringBuilder hexString = new StringBuilder(2 * encodedhash.length);

			for (int i = 0; i < encodedhash.length; i++) {
				String hex = Integer.toHexString(0xff & encodedhash[i]);
				// System.out.format("Valore byte: %02x --> Stringa esadecimale:
				// %s\n",encodedhash[i],hex);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			// System.out.println("password hashata completa: "+hexString.toString());
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
