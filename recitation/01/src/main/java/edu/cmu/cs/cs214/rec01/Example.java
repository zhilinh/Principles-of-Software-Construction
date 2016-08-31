package edu.cmu.cs.cs214.rec01;

import java.util.ArrayList;

/**
 * Class to be completed for this recitation.
 */
public final class Example {

	/**
	 * Creates and prints out an <code>ArrayList</code> of <code>Integer</code>s
	 * from 1..size
	 * 
	 * A value of 5 for size would print out: 1 2 3 4 5
	 * 
	 * @param size
	 *            size of the <code>ArrayList</code> to create and print
	 */
	public void printList(int size) {
		ArrayList<Integer> integerList;
		// TODO: IMPLEMENT ME
		integerList = new ArrayList<Integer> ();
		for (int i = 1; i < size + 1; i++) {
			integerList.add(i);
			System.out.print(String.valueOf(i) + ' ');
		}
		
//		System.out.println(integerList);
	}

}
