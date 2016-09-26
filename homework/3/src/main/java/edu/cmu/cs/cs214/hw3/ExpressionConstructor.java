package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.List;
import edu.cmu.cs.cs214.hw2.expression.DifferenceExpression;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.ProductExpression;
import edu.cmu.cs.cs214.hw2.expression.SumExpression;
import edu.cmu.cs.cs214.hw2.expression.Variable;

public class ExpressionConstructor {
	
	private String[] args;
	private List<Variable> vList;
	
	public ExpressionConstructor(String[] args, List<Variable> vList) {
		this.args = args;
		this.vList = vList;
	}
	
	public List<Expression> Constructor() {
		Expression left = new Variable("");
		Expression tmp = new Variable("");
		List<Expression> result = new ArrayList<Expression>();
		List<String> operatorList = new ArrayList<String>();
		String tmpOperator = "";

		operatorList.add("+");
		operatorList.add("-");
		operatorList.add(".");
		operatorList.add("=");

		for (String i : args) {
			if (operatorList.contains(i)) {
				if (i.equals("=")) {
					left = tmp;
					tmpOperator = "=";
				} else {
					tmpOperator = i;
				}
				} else if (tmpOperator.equals("+")) {
					tmp = new SumExpression(tmp, new WordExpression(i, vList));
				} else if (tmpOperator.equals(".")) {
					tmp = new ProductExpression(tmp, new WordExpression(i, vList));
				} else if (tmpOperator.equals("-")) {
					tmp = new DifferenceExpression(tmp, new WordExpression(i, vList));
				} else {
					tmp = new WordExpression(i, vList);
				}
		}
		result.add(left);
		result.add(tmp);
		return result;
	}
}