package com.jstech.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveATest {

	RemoveA ra;

	@BeforeEach
	void initialize() {
		ra = new RemoveA();
	}

	@Test
	void testWithNoChars() {
		String actual = "";
		String expected = "";
		assertEquals(expected, actual);
	}

	@Test
	void testWithOneA() {
		String actual = ra.removeA("A");
		String expected = "";
		assertEquals(expected, actual);
	}

	@Test
	void testWithTwoAs() {
		String actual = ra.removeA("AA");
		String expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	void testWithTwoChars() {
		String actual = ra.removeA("AB");
		String expected = "B";
		assertEquals(expected, actual);
	}
	
	@Test
	void testWithTwoCharsWithB() {
		String actual = ra.removeA("BA");
		String expected = "B";
		assertEquals(expected, actual);
	}
	
	@Test
	void testWithTwoCharsWithoutA() {
		String actual = ra.removeA("BJ");
		String expected = "BJ";
		assertEquals(expected, actual);
	}
	
	@Test
	void testWithAAtThird() {
		String actual = ra.removeA("BJAJGJH");
		String expected = "BJAJGJH";
		assertEquals(expected, actual);
	}

	@Test
	void testWithAAfterThird() {
		String actual = ra.removeA("BJKKHLAJGJH");
		String expected = "BJKKHLAJGJH";
		assertEquals(expected, actual);
	}
	
	@Test
	void testThreeCharsWithA() {
		String actual = ra.removeA("ABJ");
		String expected = "BJ";
		assertEquals(expected, actual);
	}
	
	@Test
	void testThreeCharsWithoutA() {
		String actual = ra.removeA("PBJ");
		String expected = "PBJ";
		assertEquals(expected, actual);
	}
	
	@Test
	void testFourCharsWithA() {
		String actual = ra.removeA("GABJ");
		String expected = "GBJ";
		assertEquals(expected, actual);
	}
	
	@Test
	void testFourCharsWithoutA() {
		String actual = ra.removeA("PGBJ");
		String expected = "PGBJ";
		assertEquals(expected, actual);
	}
	
	@Test
	void testFourCharsWithTwoAs() {
		String actual = ra.removeA("AABJ");
		String expected = "BJ";
		assertEquals(expected, actual);
	}
	
	@Test
	void testFourCharsWithOneA() {
		String actual = ra.removeA("PAGBJ");
		String expected = "PGBJ";
		assertEquals(expected, actual);
	}
	
	
	
	
}