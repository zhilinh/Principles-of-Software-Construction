package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import edu.cmu.cs.cs214.hw2.expression.*;

public class Parsing {
	
	private String[] args;
	
	public Parsing(String[] args) {
		this.args = args;
	}
	
	public List<Variable> doParsing() {
		
		List<Variable> vList = new ArrayList<Variable>();
		
		Set<Character> hasWord = new HashSet<Character>();		
		for (String i : args) {
			char[] word = i.toCharArray();
			for (char j : word) {
				if (Character.isAlphabetic(j) && ! hasWord.contains(j)) {
					vList.add(new Variable(Character.toString(j)));
					hasWord.add(j);
				}
			}
		}
		return vList;
	}
}