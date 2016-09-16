package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the class NegationExpression
 * @author zhilinh
 *
 */
public class NegationTest {
	
	private Expression negationTest;
	private double number1 = 1.0;
	private double number2 = -1.0;
	private Expression addend1 = new NumberExpression(number1);
	
	/**
	 * Set up to test the constructor.
	 */
	@Before
	public void setup() {
		negationTest = new NegationExpression(addend1);
	}
	
	/**
	 * Test for toString method.
	 */
	@Test
	public void testtoString() {
		assertEquals("-(" + addend1.toString() + ")", negationTest.toString());
	}
	
	/**
	 * Test for eval method to the value returned.
	 */
	@Test
	public void testEval() {
		assertEquals(BigDecimal.valueOf(number2), BigDecimal.valueOf(negationTest.eval()));
	}

}
