package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class VariableTest {
	
	private double number = 0;
	private String name = "x";
	private Variable xTest = new Variable(name);

	
	@Test
	public void testEval() {
		assertEquals(BigDecimal.valueOf(xTest.eval()), BigDecimal.valueOf(number));
	}
	
	@Test
	public void testtoString() {
		assertEquals(name + " is a variable with value " + Double.toString(number), xTest.toString());
	}
	
	@Test
	public void testStore() {
		double value = 1.0;
		xTest.store(value);
		assertEquals(BigDecimal.valueOf(value), BigDecimal.valueOf(xTest.eval()));
	}
	
	@Test
	public void testName() {
		assertEquals(xTest.name(), name);
	}

}
