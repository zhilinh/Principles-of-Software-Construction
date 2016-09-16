package edu.cmu.cs.cs214.hw2.expression;

public final class NumberExpression implements Expression{
	
	private double valueExpressed;
	
	public NumberExpression(double value) {
		valueExpressed = value;
	}
	
	@Override
	public String toString() {
		return Double.toString(valueExpressed);
	}
	
	public double eval() {
		// TODO Auto-generated method stub
		return valueExpressed;
	}

}
