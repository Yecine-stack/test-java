package test;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.CalculateurLivraison;
import main.CalculateurLivraison.ModeLivraison;

public class TestCalculateurLivraison {
    CalculateurLivraison liv;

    @BeforeEach void setUp() { liv = new CalculateurLivraison(); }

    @Test void standardPayante() { assertEquals(7.0, liv.frais(80, ModeLivraison.STANDARD, false)); }
    @Test void standardGratuite() { assertEquals(0.0, liv.frais(150, ModeLivraison.STANDARD, false)); }
    @Test void expressOrdinaire() { assertEquals(15.0, liv.frais(50, ModeLivraison.EXPRESS, false)); }
    @Test void expressPremium() { assertEquals(10.0, liv.frais(50, ModeLivraison.EXPRESS, true)); }
    @Test void totalAPayer() { assertEquals(87.0, liv.totalAPayer(80, ModeLivraison.STANDARD, false)); }
}*/

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import main.CalculateurLivraison;
import main.CalculateurLivraison.ModeLivraison;

public class TestCalculateurLivraison {
    CalculateurLivraison liv;

    @BeforeEach void setUp() { liv = new CalculateurLivraison(); }

    /*@Test
    void testAllRules() {
        assertAll(
            () -> assertEquals(7.0, liv.frais(80, ModeLivraison.STANDARD, false), "Standard < 100"),
            () -> assertEquals(0.0, liv.frais(150, ModeLivraison.STANDARD, false), "Standard >= 100"),
            () -> assertEquals(15.0, liv.frais(50, ModeLivraison.EXPRESS, false), "Express ordinaire"),
            () -> assertEquals(10.0, liv.frais(50, ModeLivraison.EXPRESS, true), "Express premium"),
            () -> assertEquals(87.0, liv.totalAPayer(80, ModeLivraison.STANDARD, false), "Total à payer")
        );
    }*/
    /*@ParameterizedTest(name = "commande de {0} DT : livraison standard gratuite")
    @ValueSource(doubles = { 100, 150.5, 1000 })
    void standardGratuite(double montant) {
    assertEquals(0, liv.frais(montant, ModeLivraison.STANDARD, false), 1e-9);
    }
    @ParameterizedTest(name = "le montant {0} est refusé")
    @ValueSource(doubles = { -0.01, -1.0, -100.0 })
    void montantNegatifRefuse(double montant) {
    assertThrows(IllegalArgumentException.class,
    () -> liv.frais(montant, ModeLivraison.STANDARD, false));
    }*/
    @ParameterizedTest(name = "{0} DT, {1}, premium = {2} : {3} DT")
    @CsvSource({
    "99.99, STANDARD, false, 7",
    "100, STANDARD, false, 0",
    "100, STANDARD, true, 0",
    "50, EXPRESS, false, 15",
    "50, EXPRESS, true, 10"
    })
    void frais(double m, ModeLivraison mode, boolean p, double attendu) {
    assertEquals(attendu, liv.frais(m, mode, p), 1e-9);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/commands.csv", numLinesToSkip = 1)
    void total(double m, ModeLivraison mode, boolean p, double total) {
    assertEquals(total, liv.totalAPayer(m, mode, p), 1e-9);
    }
    @ParameterizedTest
    @EnumSource(ModeLivraison.class)
    void premiumMoinsCher(ModeLivraison mode) {
    assertTrue(liv.frais(50, mode, true)
    <= liv.frais(50, mode, false));
    }
}

