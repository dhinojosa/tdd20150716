package com.xyzcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	@Test
	public void testAddTwoNumbers() {
		Calculator calculator = new Calculator();
		int actual = calculator.add(5, 3);
		assertEquals("Calculator returned unexpected value", 8, actual);
	}
}
