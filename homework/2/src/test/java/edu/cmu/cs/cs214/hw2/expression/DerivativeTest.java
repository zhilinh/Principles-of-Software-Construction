package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import org.junit.Test;

/**
 * Class to test the class DerivativeExpression
 * @author zhilinh
 *
 */
public class DerivativeTest {
	
	private Variable xUndefined = new Variable("x");
	private Expression x = xUndefined;
	private Expression xSquare = new ProductExpression(x, x);
	private Expression y = new NumberExpression(2.0);
	private Expression xTest = new DifferenceExpression(xSquare, y);

	/**
	 * Test for eval method by randomly generating the value of variable
	 * xUndefined with name "x" in Expression xTest which is "x * x - 2"
	 * to compute its derivative "2 * x" and compare the value returned
	 * to the supposed answer.
	 */
	@Test
	public void testEval() {
		final double tolerance = 1e-5;
		xUndefined.store(Math.random());
		Expression derivativeTest = new DerivativeExpression(xTest, xUndefined);
		assertTrue(Math.abs(2 * xUndefined.eval() - derivativeTest.eval()) < tolerance);
	}
}
