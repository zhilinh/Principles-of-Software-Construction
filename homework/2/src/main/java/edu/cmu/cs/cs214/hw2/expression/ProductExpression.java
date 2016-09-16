package edu.cmu.cs.cs214.hw2.expression;

public final class ProductExpression implements Expression {

	private Expression factor1, factor2;
	
	public ProductExpression(Expression factor1, Expression factor2) {
		this.factor1 = factor1;
		this.factor2 = factor2;
	}
	
	@Override
	public String toString() {
		return "(" + factor1.toString() + "*" + factor2.toString() + ")";
	}
	public double eval() {
		// TODO Auto-generated method stub
		return factor1.eval() * factor2.eval();
	}

}
