package main;

public class Compte {
	 private int cin;
	private int s;
	 public Compte(int c, int soldeInit) { cin = c; s = soldeInit; }
	 public int solde() { return s; }
	 public int client() { return cin; }
	 public void deposer(int montant) { s += montant; }
	 public void retirer(int montant) { s -= montant; }
	}