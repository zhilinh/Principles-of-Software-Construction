package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	private int n;
	private List<List<Integer>> cList = new ArrayList<List<Integer>>();
	
	public Combination(int n) {
		this.n = n;
	}
	
	public List<Integer> onetoTen() {
		
		List<Integer> number = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			number.add(i);
		}		
		return number;
	}
	
	public List<List<Integer>> getcList() {
		return cList;
	}
	
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
