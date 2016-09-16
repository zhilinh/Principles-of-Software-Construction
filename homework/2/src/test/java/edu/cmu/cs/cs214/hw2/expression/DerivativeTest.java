package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import org.junit.Test;

public class DerivativeTest {
	
	private Variable xUndefined = new Variable("x");
	private Expression x = xUndefined;
	private Expression xSquare = new ProductExpression(x, x);
	private Expression y = new NumberExpression(2.0);
	private Expression xTest = new DifferenceExpression(xSquare, y);

	@Test
	public void testEval() {
		double tolerance = 1e-7;
		xUndefined.store(Math.random());
		Expression derivativeTest = new DerivativeExpression(xTest, xUndefined);
		assertTrue(Math.abs(2 * xUndefined.eval() - derivativeTest.eval()) < tolerance);
	}
}
