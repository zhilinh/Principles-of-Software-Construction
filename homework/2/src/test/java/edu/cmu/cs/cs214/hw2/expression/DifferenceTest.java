package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the class DifferenceExpression
 * @author zhilinh
 *
 */
public class DifferenceTest {
	
	private Expression differenceTest;
	private double number1 = 1.0;
	private double number2 = 2.0;
	private double number3 = -1.0;
	private Expression addend1 = new NumberExpression(number1);
	private Expression addend2 = new NumberExpression(number2);
	
	/**
	 * Set up to test the constructor.
	 */
	@Before
	public void setup() {
		differenceTest = new DifferenceExpression(addend1, addend2);
	}
	
	/**
	 * Test for toString method.
	 */
	@Test
	public void testtoString() {
		assertEquals("(" + addend1.toString() + "-" + addend2.toString() + ")", differenceTest.toString());
	}
	
	/**
	 * Test for eval method to the value returned.
	 */
	@Test
	public void testEval() {
		assertEquals(BigDecimal.valueOf(number3), BigDecimal.valueOf(differenceTest.eval()));
	}

}
