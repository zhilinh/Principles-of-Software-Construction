package edu.cmu.cs.cs214.hw2.expression;

public class NewtonsMethod {

	/**
	* Returns a zero of the specified function using Newton's method with
	* approxZero as the initial estimate.
	*
	* @param fn the function whose zero is to be found
	* @param x the independent variable of the function
	* @param approxZero initial approximation for the zero of the function
	* @param tolerance how close to zero f(the returned value) has to be
	* @return a value x for which f(x) is "close to zero" (<= tolerance)
	*/
	public double zero(Expression fn, Variable x, double approxZero, double tolerance) {
		while (Math.abs(x.eval() - approxZero) > tolerance) {
			x.store(x.eval() - fn.eval() / new DerivativeExpression(fn, x).eval());
		}
		return x.eval();
	}

}
