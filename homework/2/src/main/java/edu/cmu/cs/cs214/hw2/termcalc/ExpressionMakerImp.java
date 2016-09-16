package edu.cmu.cs.cs214.hw2.termcalc;

import edu.cmu.cs.cs214.hw2.expression.AbsoluteValueExpression;
import edu.cmu.cs.cs214.hw2.expression.DifferenceExpression;
import edu.cmu.cs.cs214.hw2.expression.DivisionExpression;
import edu.cmu.cs.cs214.hw2.expression.ExponentiationExpression;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.NegationExpression;
import edu.cmu.cs.cs214.hw2.expression.NumberExpression;
import edu.cmu.cs.cs214.hw2.expression.ProductExpression;
import edu.cmu.cs.cs214.hw2.expression.SumExpression;

public class ExpressionMakerImp implements ExpressionMaker{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Expression sumExpression(Expression addend1, Expression addend2) {
		// TODO Auto-generated method stub
		Expression sumExpression = new SumExpression(addend1, addend2);
		return sumExpression;
	}

	@Override
	public Expression differenceExpression(Expression op1, Expression op2) {
		// TODO Auto-generated method stub
		Expression differenceExpression = new DifferenceExpression(op1, op2);
		return differenceExpression;
	}

	@Override
	public Expression productExpression(Expression factor1, Expression factor2) {
		// TODO Auto-generated method stub
		Expression productExpression = new ProductExpression(factor1, factor2);
		return productExpression;
	}

	@Override
	public Expression divisionExpression(Expression dividend, Expression divisor) {
		// TODO Auto-generated method stub
		Expression divisionExpression = new DivisionExpression(dividend, divisor);
		return divisionExpression;
	}

	@Override
	public Expression exponentiationExpression(Expression base, Expression exponent) {
		// TODO Auto-generated method stub
		Expression exponentiationExpression = new ExponentiationExpression(base, exponent);
		return exponentiationExpression;
	}

	@Override
	public Expression negationExpression(Expression operand) {
		// TODO Auto-generated method stub
		Expression negationExpression = new NegationExpression(operand);
		return negationExpression;
	}

	@Override
	public Expression absoluteValueExpression(Expression value) {
		// TODO Auto-generated method stub
		Expression absoluteValueExpression = new AbsoluteValueExpression(value);
		return absoluteValueExpression;
	}

	@Override
	public Expression numberExpression(double value) {
		// TODO Auto-generated method stub
		Expression numberExpression = new NumberExpression(value);
		return numberExpression;
	}

}
