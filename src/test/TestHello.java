package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Hello;

class TestHello {
	Hello h= new Hello();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("before each");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After each");
	}

	@Test
	void testGetMessage() {
		System.out.println("testMessage");
		String s = h.getMessage("From GI3");
		assertEquals("Hello From GI3", s);
	}
	
	@Test
	void testGetMessage2() {
		System.out.println("testMessage");
		String s = h.getMessage("From GI3S1");
		assertEquals("Hello From GI3S1", s);
	}
}
