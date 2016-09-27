package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate combination of numbers.
 * @author zhilinh
 *
 */
public class Combination {

	private int n;
	private List<List<Integer>> cList = new ArrayList<List<Integer>>();
	
	/**
	 * Assign the number of elements to instance.
	 * @param n number of elements.
	 */
	public Combination(int n) {
		this.n = n;
	}
	
	/**
	 * Method to generate ten numbers from 0 to 9.
	 * @return the list of numbers.
	 */
	public List<Integer> onetoTen() {
		
		List<Integer> number = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			number.add(i);
		}		
		return number;
	}
	
	/**
	 * Method to return the combination.
	 * @return a list of all combination.
	 */
	public List<List<Integer>> getcList() {
		return cList;
	}
	
	/**
	 * Method to generate all combination.
	 * @param number list of elements to get combination.
	 * @param newList list of new pairs.
	 */
	public void generator(List<Integer> number, ArrayList<Integer> newList) {
		
		if (newList.size() == n) {
			cList.add(newList);
		} else {
			List<Integer> numberCopy = new ArrayList<Integer>(number);
			for (int i : number) {
				newList.add(i);
				numberCopy.remove(numberCopy.indexOf(i));
				this.generator(numberCopy, new ArrayList<Integer>(newList));
				newList.remove(newList.size() - 1);
			}
		}
		
	}
}
