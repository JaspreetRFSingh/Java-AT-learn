package com.jstech.calculatortestatsk;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.epam.tat.module4.Calculator;

public class TestCalculator extends TestListenerImpl{
	Calculator calculator = new Calculator();

	static CSVUtil csvu = new CSVUtil();
	static ExcelUtil excu = new ExcelUtil();


	@Test
	void testAddition() {
		long expected = 90;
		long actual = calculator.sum(45, 45);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testAdditionWithNegativeValue() {
		long expected = 0;
		long actual = calculator.sum(-3, 3);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testAdditiveIdentity() {
		long expected = 9;
		long actual = calculator.sum(9, 0);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testSubtraction() {
		long expected = 21;
		long actual = calculator.sub(45, 24);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testSubtractionWithNegativeValue() {
		long expected = -6;
		long actual = calculator.sub(-3, 3);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testSubtractionWithBothNegativeValues() {
		long expected = 0;
		long actual = calculator.sub(-3, -3);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testNegativeInteger() {
		boolean actual = calculator.isNegative(-1);
		Assert.assertEquals(actual, true);
	}

	@Test
	void testNegativeIntegerWithPositiveValue() {
		boolean actual = calculator.isNegative(1);
		Assert.assertEquals(actual, false);
	}

	@Test
	void testPositiveIntegerWithNegativeValue() {
		boolean actual = calculator.isPositive(-1);
		Assert.assertEquals(actual, false);
	}

	@Test
	void testPositiveInteger() {
		boolean actual = calculator.isPositive(1);
		Assert.assertEquals(actual, true);
	}

	@Test(groups = { "multiply" })
	void testMultiplyTwoNegativeValues() {
		double actual = calculator.mult(-12.0, -12.0);
		double expected = 144.0;
		Assert.assertEquals(actual, expected);
	}

	@Test(groups = { "multiply" })
	void testMultiply() {
		double actual = calculator.mult(12.0, 12.0);
		double expected = 144.0;
		Assert.assertEquals(actual, expected);
	}

	@Test(groups = { "multiply" })
	void testMultiplicativeIdentity() {
		double actual = calculator.mult(21.0, 1);
		double expected = 21.0;
		Assert.assertEquals(actual, expected);
	}

	@Test(groups = { "multiply" })
	void testMultiplyWithZero() {
		double actual = calculator.mult(12.0, 0);
		double expected = 0;
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testDivide() {
		double expected = 1;
		double actual = calculator.div(23, 23.0);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testDivideWithNegativeNumerator() {
		double expected = -1;
		double actual = calculator.div(-23, 23.0);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void testDivideWithNegativeDenominator() {
		double expected = -1;
		double actual = calculator.div(23, -23.0);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void negativeTestDivide() {
		double expected = 1;
		double actual = calculator.div(23.1, 23);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void negativeTestMultiply() {
		double expected = 1;
		double actual = calculator.mult(23.1, 23);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void negativeTestAddition() {
		double expected = 46;
		double actual = calculator.sum(23.1, 23);
		Assert.assertEquals(actual, expected);
	}

	@Test
	void negativeTestSubtract() {
		double expected = 0;
		double actual = calculator.sub(23.1, 23);
		Assert.assertEquals(actual, expected);
	}
	
	
	@DataProvider(name = "divideByZeroTest")
	public static  Object [][] divideByZeroDataProvider(){
		return new Object[][] {{21,0}};
	}
	
	@Test(dataProvider = "divideByZeroTest", expectedExceptions = {NumberFormatException.class})
	void testDivideByZero(int x, int y) {
		double expected = 0;
		double actual = calculator.div(x, y);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(dataProvider = "divideByZeroTest", expectedExceptions = {ArithmeticException.class})
	void negativeTestDivideByZero(int x, int y) {
		double expected = 0;
		double actual = calculator.div(x, y);
		Assert.assertEquals(actual, expected);
	}

	
	
	@DataProvider(name = "testAddition")
	public static Object[][] additionOfTwoNumbers() {
		return excu.sumData();
	}

	@Test(dataProvider = "testAddition" , groups = {"dataProvider"})
	public void additionChecker(double number1, double number2, double expected) {
		Assert.assertEquals(calculator.sum(number1, number2), expected);
	}

	@DataProvider(name = "testSubtraction")
	public static Object[][] subtractionOfTwoNumbers() {
		return csvu.subtractionUsingDataFromCSV();
	}

	@Test(dataProvider = "testSubtraction", groups = {"dataProvider"})
	public void subtractionChecker(long number1, long number2, long expected) {
		Assert.assertEquals(calculator.sub(number1, number2), expected);
	}
	
	@DataProvider(name = "testMultiplication")
	public static Object[][] multiplicationOfTwoNumbers() {
		return new Object[][] { { 2, 3, 6 }, { 6, 7, 42 }, { 19, -1, -19 }, { 22, 0, 0 }, { -13, 13, -169 } };
	}

	@Test(dataProvider = "testMultiplication" , groups = {"dataProvider"})
	public void multiplicationChecker(double number1, double number2, double expected) {
		Assert.assertEquals(calculator.mult(number1, number2), expected);
	}

	@DataProvider(name = "testDivision")
	public static Object[][] divisionOfTwoNumbers() {
		return new Object[][] { { 3, 3, 1 }, { 16, 8, 2 }, { 19, 1, 19 }, { 0, 22, 0 }, { -23, 23, -1 } };
	}

	@Test(dataProvider = "testDivision", groups = {"dataProvider"})
	public void divisionChecker(double number1, double number2, double expected) {
		Assert.assertEquals(calculator.div(number1, number2), expected);
	}
	
	
	
}
