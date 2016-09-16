package edu.cmu.cs.cs214.hw2.expression;

public class DerivativeExpression implements Expression {

	private final double deltaX = 1e-9;
	private Expression fn;
	private Variable independentVar;
	private double fnVal;
	
	/**
	* Creates an expression representing the derivative of the specified
	* function with respect to the specified variable.
	*
	* @param fn the function whose derivative this expression represents
	* @param independentVar the variable with respect to which we're
	* differentiating
	*/
	public DerivativeExpression(Expression fn, Variable indepedent) {
		fnVal = fn.eval();
		this.fn = fn;
		this.independentVar = indepedent;
	}
	
	@Override
	public double eval() {
		// TODO Auto-generated method stub
		independentVar.store(independentVar.eval() + deltaX);
		return (fn.eval() - fnVal) / deltaX;
	}

}
