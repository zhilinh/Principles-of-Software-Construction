package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import edu.cmu.cs.cs214.hw2.expression.*;

/**
 * Class to parse all characters in all strings.
 * @author zhilinh
 *
 */
public class Parsing {
	
	private String[] args;
	
	/**
	 * Assign a string list to the instance.
	 * @param args a string list to parse.
	 */
	public Parsing(String[] args) {
		this.args = args;
	}
	
	/**
	 * Method to separate every character to determine whether they are
	 * legal or not and assign them to variables.
	 * @return a variable list of all characters.
	 */
	public List<Variable> doParsing() {
		
		List<Character> operatorList = new ArrayList<Character>();
		List<Variable> vList = new ArrayList<Variable>();		
		operatorList.add('+');operatorList.add('-');
		operatorList.add('.');operatorList.add('=');		
		Set<Character> hasWord = new HashSet<Character>();
		
		for (String i : args) {
			char[] word = i.toCharArray();
			for (char j : word) {
				if (! hasWord.contains(j)) {
					if (Character.isAlphabetic(j)) {
						vList.add(new Variable(Character.toString(j)));
						hasWord.add(j);
					} else if (! operatorList.contains(j)) {			//If there is an illegal character.
						throw new IllegalArgumentException("Invalid Input!");
					}
				}
			}
		}
		if (vList.size() > 10) {										//If there are characters more than ten 
			throw new IllegalArgumentException("Invalid Input!");		//to represent by numbers from 0 to 9.
		}
		return vList;
	}
}