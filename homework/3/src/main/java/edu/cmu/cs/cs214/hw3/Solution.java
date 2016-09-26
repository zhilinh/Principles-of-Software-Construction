package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.Variable;

public class Solution {
	
	List<List<Integer>> cList = new ArrayList<List<Integer>>();
	List<Variable> vList;
	List<Expression> result;

	public Solution(List<List<Integer>> getcList, List<Variable> vList, List<Expression> result) {
		this.vList = vList;
		this.cList = getcList;
		this.result = result;
	}

	public List<String> Comparison() {
		
		List<String> rList = new ArrayList<String>();
		for (List<Integer> subList : cList) {			
			ArrayIterator ai = new ArrayIterator(vList.size(), subList);
			Iterator<List<Integer>> it = ai.iterator();
			while (it.hasNext()) {
				List<Integer> s = it.next();
				for (int i = 0; i < s.size(); i++) {
					vList.get(i).store(new Double(s.get(i).toString()));
					}
				if (result.get(0).eval() == result.get(1).eval() && s.size() != 0) {
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
