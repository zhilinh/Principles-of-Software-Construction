package edu.cmu.cs.cs214.hw2.expression;

public final class DifferenceExpression implements Expression {

	private Expression op1, op2;
	
	public DifferenceExpression(Expression op1, Expression op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	@Override
	public String toString() {
		return "(" + op1.toString() + "-" + op2.toString() + ")";
	}
	public double eval() {
		// TODO Auto-generated method stub
		return op1.eval() - op2.eval();
	}

}
