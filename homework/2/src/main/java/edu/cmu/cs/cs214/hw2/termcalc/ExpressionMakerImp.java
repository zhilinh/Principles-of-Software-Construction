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

/**
 * Class to implement ExpressionMaker and create a new Expression
 * @author zhilinh
 *
 */
public class ExpressionMakerImp implements ExpressionMaker{

	/**
	 * Method that returns a new Expression of the sum of addend1 and addend2.
	 */
	@Override
	public Expression sumExpression(Expression addend1, Expression addend2) {
		Expression sumExpression = new SumExpression(addend1, addend2);
		return sumExpression;
	}

	/**
	 * Method that returns a new Expression of the difference of op1 and op2.
	 */
	@Override
	public Expression differenceExpression(Expression op1, Expression op2) {
		Expression differenceExpression = new DifferenceExpression(op1, op2);
		return differenceExpression;
	}

	/**
	 * Method that returns a new Expression of the product of factor1 and factor2.
	 */
	@Override
	public Expression productExpression(Expression factor1, Expression factor2) {
		Expression productExpression = new ProductExpression(factor1, factor2);
		return productExpression;
	}

	/**
	 * Method that returns a new Expression of the division of dividend and divisor.
	 */
	@Override
	public Expression divisionExpression(Expression dividend, Expression divisor) {
		Expression divisionExpression = new DivisionExpression(dividend, divisor);
		return divisionExpression;
	}

	/**
	 * Method that returns a new Expression of the exponentiation of base and exponent.
	 */
	@Override
	public Expression exponentiationExpression(Expression base, Expression exponent) {
		Expression exponentiationExpression = new ExponentiationExpression(base, exponent);
		return exponentiationExpression;
	}

	/**
	 * Method that returns a new Expression of the the negated operand.
	 */
	@Override
	public Expression negationExpression(Expression operand) {
		Expression negationExpression = new NegationExpression(operand);
		return negationExpression;
	}

	/**
	 * Method that returns a new Expression of the absolute value Expression of value.
	 */
	@Override
	public Expression absoluteValueExpression(Expression value) {
		Expression absoluteValueExpression = new AbsoluteValueExpression(value);
		return absoluteValueExpression;
	}

	/**
	 * Method that returns a new Expression of the value.
	 */
	@Override
	public Expression numberExpression(double value) {
		Expression numberExpression = new NumberExpression(value);
		return numberExpression;
	}

}
