package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import org.junit.Test;

public class NewtonsTest {
	private double approxZero = Math.sqrt(2.0);
	private double tolerance = 1e-7;
	private Variable xUndefined = new Variable("x");
	private Expression x = xUndefined;
	private Expression xSquare = new ProductExpression(x, x);
	private Expression y = new NumberExpression(2.0);
	private Expression xTest = new DifferenceExpression(xSquare, y);

	@Test
	public void testZero() {
		NewtonsMethod newtonsTest = new NewtonsMethod();
		xUndefined.store(1.0);
		double result = newtonsTest.zero(xTest, xUndefined, approxZero, tolerance);
		assertTrue(Math.abs(result - approxZero) < tolerance);
	}
}
