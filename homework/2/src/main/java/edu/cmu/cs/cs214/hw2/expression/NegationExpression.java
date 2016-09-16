package edu.cmu.cs.cs214.hw2.expression;

public final class NegationExpression implements Expression {

	private Expression operand;
	
	public NegationExpression(Expression operand) {
		this.operand = operand;
	}
	
	@Override
	public double eval() {
		// TODO Auto-generated method stub
		return -1 * operand.eval();
	}
	
	@Override
	public String toString() {
		return "-(" + operand.toString() + ")";
	}

}
