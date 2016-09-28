package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.Variable;

/**
 * Class to provide solutions for Cryptarithm using an iterator.
 * @author zhilinh
 *
 */
public class Solution {
	
	private List<List<Integer>> cList = new ArrayList<List<Integer>>();
	private List<Variable> vList;
	private List<Expression> result;

	/**
	 * Assign a combination list, a variable list and two Expression to instances.
	 * @param getcList a combination list of numbers.
	 * @param vList a variable list representing the characters.
	 * @param result contains two Expression besides the "=".
	 */
	public Solution(List<List<Integer>> getcList, List<Variable> vList, List<Expression> result) {
		this.vList = vList;
		this.cList = getcList;
		this.result = result;
	}

	/**
	 * Method to generate the values of two Expression and determine
	 * whether they are equal to output the solutions.
	 * @return a list of solutions to output.
	 */
	public List<String> Comparison() {
		
		List<String> rList = new ArrayList<String>();
		for (List<Integer> subList : cList) {			
			ArrayIterator<Integer> ai = new ArrayIterator<Integer>(vList.size(), subList);	//Create an iterator
			Iterator<List<Integer>> it = ai.iterator();
			while (it.hasNext()) {
				List<Integer> s = it.next();												//Generate a permutation
				for (int i = 0; i < s.size(); i++) {
					vList.get(i).store(new Double(s.get(i).toString()));
					}
				if (result.get(0).eval() == result.get(1).eval() && s.size() != 0) {		//If the permutation makes the equation correct
					String solv = "{";
					for (Variable j : vList) {
						solv += j.name() + "=" + (int) j.eval() + ", ";
					}
				solv = solv.substring(0, solv.length() - 2);
				solv += "}";
				rList.add(solv);
				}
			}
		}
		return rList;
	}
}
