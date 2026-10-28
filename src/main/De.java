package main;
import java.util.Random;

public class De {
private final Random random = new Random();
public int lancer() {
return random.nextInt(6) + 1; // entre 1 et 6
}
}