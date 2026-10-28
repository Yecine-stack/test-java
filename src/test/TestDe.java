package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import main.De;

class TestDe {
De de = new De();
@RepeatedTest(value = 20,
name = "lancer {currentRepetition}/{totalRepetitions}")
void valeurEntreUnEtSix(RepetitionInfo info) {
int valeur = de.lancer();
assertTrue(valeur >= 1 && valeur <= 6,
"lancer " + info.getCurrentRepetition() + " : " + valeur);
}
}