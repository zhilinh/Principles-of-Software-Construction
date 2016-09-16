package edu.cmu.cs.cs214.hw2.expression;

public final class SumExpression implements Expression {
	
	private Expression addend1, addend2;
	
	public SumExpression(Expression addend1, Expression addend2) {
		this.addend1 = addend1;
		this.addend2 = addend2;
	}

	public double eval() {
		// TODO Auto-generated method stub
		return addend1.eval() + addend2.eval();
	}
	
	@Override
	public String toString() {
		return "(" + addend1.toString() + "+" + addend2.toString() + ")";
	}

}
