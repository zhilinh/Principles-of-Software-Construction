package edu.cmu.cs.cs214.hw2.expression;

/**
 * Class to compute the product of the values of two Expressions
 * @author zhilinh
 *
 */
public final class ProductExpression implements Expression {

	private Expression factor1, factor2;
	
	/**
	 * Public construct that assigns two Expression to instance Expressions.
	 * 
	 * @param factor1 the first factor of the multiplication
     * @param factor2 the second factor of the multiplication
	 */
	public ProductExpression(Expression factor1, Expression factor2) {
		this.factor1 = factor1;
		this.factor2 = factor2;
	}
	
	/**
	 * toString method that returns a string of two Expressions and the operator
	 * with parentheses.
	 */
	@Override
	public String toString() {
		return "(" + factor1.toString() + "*" + factor2.toString() + ")";
	}
	
	/**
	 * Method that returns the value of the product.
	 * 
	 * @return returns the value of the Expression.
	 */
	public double eval() {
		return factor1.eval() * factor2.eval();
	}

}
