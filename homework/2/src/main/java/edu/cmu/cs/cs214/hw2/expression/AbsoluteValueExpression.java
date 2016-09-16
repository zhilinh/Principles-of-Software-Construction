package edu.cmu.cs.cs214.hw2.expression;

public final class AbsoluteValueExpression implements Expression {

	private Expression value;
	
	public AbsoluteValueExpression(Expression value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		if (value.eval() < 0) {
			return "-(" + value.toString() + ")";
		} else {
			return value.toString();
		}
	}
	
	public double eval() {
		// TODO Auto-generated method stub
		if (value.eval() < 0) {
			return -1 * value.eval();
		} else {
			return value.eval();
		}
	}

}
