package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the class ExponentiationExpression
 * @author zhilinh
 *
 */
public class ExponentiationTest {
	
	private Expression exponentiationTest;
	private final double number1 = 2.0;
	private final double number2 = 4.0;
	private final double number3 = 16.0;
	private Expression addend1 = new NumberExpression(number1);
	private Expression addend2 = new NumberExpression(number2);
	
	/**
	 * Set up to test the constructor.
	 */
	@Before
	public void setup() {
		exponentiationTest = new ExponentiationExpression(addend1, addend2);
	}
	
	/**
	 * Test for toString method.
	 */
	@Test
	public void testtoString() {
		assertEquals("(" + addend1.toString() + "^" + addend2.toString() + ")", exponentiationTest.toString());
	}
	
	/**
	 * Test for eval method to the value returned.
	 */
	@Test
	public void testEval() {
		assertEquals(BigDecimal.valueOf(number3), BigDecimal.valueOf(exponentiationTest.eval()));
	}

}
