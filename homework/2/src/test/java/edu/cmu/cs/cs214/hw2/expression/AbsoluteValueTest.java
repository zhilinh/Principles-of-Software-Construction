package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the class AbsoluteValueExpression
 * @author zhilinh
 *
 */
public class AbsoluteValueTest {
	
	private Expression absTest1;
	private Expression absTest2;
	private final double number1 = 1.0;
	private final double number2 = -1.0;
	private Expression addend1 = new NumberExpression(number1);
	private Expression addend2 = new NumberExpression(number2);
	
	/**
	 * Set up to test the constructor.
	 */
	@Before
	public void setup() {
		absTest1 = new AbsoluteValueExpression(addend1);
		absTest2 = new AbsoluteValueExpression(addend2);
	}
	/**
	 * Test for toString method.
	 */
	@Test
	public void testtoString() {
		assertEquals("-(" + addend2.toString() + ")", absTest2.toString());
		assertEquals(addend1.toString(), absTest1.toString());
	}
	
	/**
	 * Test for eval method to the value returned.
	 */
	@Test
	public void testEval() {
		assertEquals(BigDecimal.valueOf(number1), BigDecimal.valueOf(absTest1.eval()));
		assertEquals(BigDecimal.valueOf(number1), BigDecimal.valueOf(absTest2.eval()));
	}

}
