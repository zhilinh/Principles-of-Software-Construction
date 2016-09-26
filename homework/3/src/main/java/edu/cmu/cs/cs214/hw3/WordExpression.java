package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.List;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.Variable;

public class WordExpression implements Expression {
	
	private List<Variable> vList = new ArrayList<Variable>();
	
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
	
	@Override
	public String toString() {
		String op = "";
		for (Variable i : vList) {
			op += i.name();
		}
		return op;		
	}

	@Override
	public double eval() {
		double sum = 0;
		if (vList.size() != 1 && vList.get(0).eval() == 0) {
			return -1.1;
		}
		for (int i = 0 ; i < vList.size(); i++) {
			sum += vList.get(i).eval() * Math.pow(10, vList.size() - i - 1);
		}
		return sum;
	}

}
