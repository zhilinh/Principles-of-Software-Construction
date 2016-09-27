package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.List;
import edu.cmu.cs.cs214.hw2.expression.DifferenceExpression;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.ProductExpression;
import edu.cmu.cs.cs214.hw2.expression.SumExpression;
import edu.cmu.cs.cs214.hw2.expression.Variable;

/**
 * Class to construct two Expression besides the "=".
 * @author zhilinh
 *
 */
public class ExpressionConstructor {
	
	private String[] args;
	private List<Variable> vList;
	
	/**
	 * Assign a string list of Expression and a list of variables to instances. 
	 * @param args a string list to be transformed.
	 * @param vList a variable list with all characters.
	 */
	public ExpressionConstructor(String[] args, List<Variable> vList) {
		this.args = args;
		this.vList = vList;
	}
	
	/**
	 * Method to analyze the composition of an equation. Transform string and operation
	 * into Expression to calculate.
	 * @return a list of two Expression result besides the "=".
	 */
	public List<Expression> Constructor() {
		Expression left = new Variable("");
		Expression tmp = new Variable("");
		List<Expression> result = new ArrayList<Expression>();
		List<String> operatorList = new ArrayList<String>();
		String tmpOperator = "";
		int lastExpression = 0;
		int equalsNumber = 0;

		operatorList.add("+");operatorList.add("-");		//Operator list.
		operatorList.add(".");operatorList.add("=");

		for (String i : args) {
			if (operatorList.contains(i)) {					//If it is an operator.
				if (lastExpression == 1) {
					lastExpression = 0;
					if (i.equals("=")) {
						left = tmp;
						tmpOperator = "=";
						equalsNumber++;
					} else {
						tmpOperator = i;
					}
				} else {									//If two letters come along without an operator.
					throw new IllegalArgumentException("Invalid Input!");
				}
			} else if (lastExpression == 0) {				//If another string comes.
				lastExpression = 1;
				if (tmpOperator.equals("+")) {
					tmp = new SumExpression(tmp, new WordExpression(i, vList));
				} else if (tmpOperator.equals(".")) {
					tmp = new ProductExpression(tmp, new WordExpression(i, vList));
				} else if (tmpOperator.equals("-")) {
					tmp = new DifferenceExpression(tmp, new WordExpression(i, vList));
				} else {
					tmp = new WordExpression(i, vList);
				}				
			} else {										//If two operators come along, throw an exception.
				throw new IllegalArgumentException("Invalid Input!");
			}
		}
		
		if (equalsNumber != 1) {							//If there are more than one "=".
			throw new IllegalArgumentException("Invalid Input!");
		}
		result.add(left);
		result.add(tmp);
		return result;										//Return two Expression besides the "=".
	}
}