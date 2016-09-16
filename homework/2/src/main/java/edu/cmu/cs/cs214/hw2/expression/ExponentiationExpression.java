package edu.cmu.cs.cs214.hw2.expression;

public final class ExponentiationExpression implements Expression {

	private Expression base, exponent;
	
	public ExponentiationExpression(Expression base, Expression exponent) {
		this.base = base;
		this.exponent = exponent;
	}
	
	@Override
	public String toString() {
		return "(" + base.toString() + "^" + exponent.toString() + ")";
	}
	
	public double eval() {
		// TODO Auto-generated method stub
		return Math.pow(base.eval(), exponent.eval());
	}

}
