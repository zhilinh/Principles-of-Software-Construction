package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.List;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.Variable;

public class Cryptarithm {

	public static void main(String[] args) {
		Parsing parsingPart = new Parsing(args);
		List<Variable> vList = parsingPart.doParsing();
		
		ExpressionConstructor expressionPart = new ExpressionConstructor(args, vList);
		List<Expression> result = expressionPart.Constructor();
		
		Combination combinePart = new Combination(vList.size());
		combinePart.generator(combinePart.onetoTen(), new ArrayList<Integer>());
		Solution solv = new Solution(combinePart.getcList(), vList, result);
		
		List<String> rList = solv.Comparison();
		if (rList.size() == 0) {
			System.out.println(rList.size() + " solution(s)");
		} else {
			System.out.println(rList.size() + " solution(s):");
			for (String i : rList) {
			System.out.println(i);
			}
		}
	}

}
