package edu.cmu.cs.cs214.hw2.expression;

/**
 * 
 * Class to implement absolute value to an Expression.
 * @author zhilinh
 *
 */
public final class AbsoluteValueExpression implements Expression {

	private Expression value;
	
	/**
	 * Public constructor that assigns a value to the
	 * instance Expression.
	 * 
	 * @param value of an Expression which needs to get
	 * an absolute value.
	 */
	public AbsoluteValueExpression(Expression value) {
		this.value = value;
	}
	
	/**
	 * toString method that returns the Expression with
	 * absolute value.
	 */
	@Override
	public String toString() {
		if (value.eval() < 0) {
			return "-(" + value.toString() + ")";
		} else {
			return value.toString();
		}
	}
	
	/**
	 * Method that returns the value of the Expression.
	 */
	public double eval() {
		if (value.eval() < 0) {
			return -1 * value.eval();
		} else {
			return value.eval();
		}
	}

}
