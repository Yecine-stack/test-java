package main;

public class CalculateurLivraison {
	public enum ModeLivraison { STANDARD, EXPRESS }
	public static final double SEUIL_GRATUITE = 100;
	public double frais(double montant, ModeLivraison mode, boolean premium) {
	if (montant < 0)
	throw new IllegalArgumentException("Montant négatif : " + montant);
	if (mode == null)
	throw new IllegalArgumentException("Mode de livraison obligatoire");
	if (mode == ModeLivraison.STANDARD)
	return montant < SEUIL_GRATUITE ? 7 : 0;
	return premium ? 10 : 15;
	}
	public double totalAPayer(double montant, ModeLivraison mode, boolean premium) {
	return montant + frais(montant, mode, premium);
	}
}