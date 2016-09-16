package edu.cmu.cs.cs214.hw2.expression;

public final class DivisionExpression implements Expression {

	private Expression dividend, divisor;
	
	public DivisionExpression(Expression dividend, Expression divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
	}
	
	@Override
	public String toString() {
		return "(" + dividend.toString() + "/" + divisor.toString() + ")";
	}
	public double eval() {
		// TODO Auto-generated method stub
		return dividend.eval() / divisor.eval();
	}

}
