package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Compte;

class TestCompte {
	Compte c;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		c=new Compte(1234,1500);
	}

	@AfterEach
	void tearDown() throws Exception { //in the start of each test, we start from compte(1234,1500)
		c=null;
	}

	@Test
	void testSolde() {
		assertTrue(c.solde()==1500);
	}

	@Test
	void testDeposer() {
		c.deposer(500);
		assertEquals(c.solde(),2000);
	}

	@Test
	void testRetirer() {
		c.retirer(500);
		assertEquals(c.solde(), 1000);
	}

}
