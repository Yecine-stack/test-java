package main;

package main;

import java.security.SecureRandom;
import java.util.Random;

public class MotDePasseService {

    public static final String MAJUSCULES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String MINUSCULES = "abcdefghijklmnopqrstuvwxyz";
    public static final String CHIFFRES = "0123456789";
    public static final String SPECIAUX = "!@#$%&*?";

    private final Random random = new SecureRandom();

    public String genererMotDePasse(int longueur) {
        if (longueur < 12 || longueur > 64)
            throw new IllegalArgumentException("Longueur hors de [12, 64] : " + longueur);
        String alphabet = MAJUSCULES + MINUSCULES + CHIFFRES + SPECIAUX;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longueur; i++)
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        return sb.toString();
    }
}
