package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * Class to test the class VariableExpression
 * @author zhilinh
 *
 */
public class VariableTest {
	
	private double number = 0;
	private String name = "x";
	private Variable xTest = new Variable(name);

	/**
	 * Test for eval method to the value returned.
	 */
	@Test
	public void testEval() {
		assertEquals(BigDecimal.valueOf(xTest.eval()), BigDecimal.valueOf(number));
	}
	
	/**
	 * Test for toString method.
	 */
	@Test
	public void testtoString() {
		assertEquals(name + " = " + Double.toString(number), xTest.toString());
	}
	
	/**
	 * Test for store method to update the value of the variable.
	 */
	@Test
	public void testStore() {
		double value = 1.0;
		xTest.store(value);
		assertEquals(BigDecimal.valueOf(value), BigDecimal.valueOf(xTest.eval()));
	}
	
	/**
	 * Test for name method the the name returned.
	 */
	@Test
	public void testName() {
		assertEquals(xTest.name(), name);
	}

}
