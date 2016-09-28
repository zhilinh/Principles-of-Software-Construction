package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.List;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.Variable;

/**
 * Class to convert a string to an Expression.
 * @author zhilinh
 *
 */
public class WordExpression implements Expression {
	
	private List<Variable> vList = new ArrayList<Variable>();
	
	/**
	 * Construct an Expression with variables assigned names.
	 * @param w the string to convert.
	 * @param wList the variable to initialize.
	 */
	public WordExpression(String w, List<Variable> wList) {
		char[] word;
		word = w.toCharArray();
		for (char i : word) {
			for (Variable j : wList) {			
				if (j.name().equals(Character.toString(i))) {
					vList.add(j);
					break;
				}
			}
		}
	}
	
	/**
	 * toString method to combine all names of variables to make the string.
	 */
	@Override
	public String toString() {
		String op = "";
		for (Variable i : vList) {
			op += i.name();
		}
		return op;		
	}

	/**
	 * Method to get the value of the Expression as a written number.
	 */
	@Override
	public double eval() {
		double sum = 0;
		if (vList.size() != 1 && vList.get(0).eval() == 0) {				//If the number gets more than one digit
			return -1.1;													//and the first character values 0,
		}																	//we should discard this solution because
		for (int i = 0 ; i < vList.size(); i++) {							//it is illegal.
			sum += vList.get(i).eval() * Math.pow(10, vList.size() - i - 1);
		}
		return sum;
	}

}
