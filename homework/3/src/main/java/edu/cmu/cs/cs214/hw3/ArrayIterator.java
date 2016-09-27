package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class to run an iterator.
 * @author zhilinh
 *
 * @param <E> any type of data could get permutation.
 */
public class ArrayIterator<E> implements Iterable<List<E>> {
	
	int n;
	private List<Integer> c = new ArrayList<Integer>();
	private List<E> A = new ArrayList<E>();
	
	/**
	 * Construct an array and numbers of elements.
	 * @param n numbers of elements to get permutation.
	 * @param A a list with all elements.
	 */
	public ArrayIterator(int n, List<E> A) {
		this.n = n;
		this.A = A;
		for (int i = 0; i < n; i++) {
			c.add(0);
		}
	}
	
	/**
	 * Method to generate a Permutation class.
	 */
	@Override
	public Iterator<List<E>> iterator() {
		return new Permutation();
	}
	
	/**
	 * Private class to do permutation.
	 * @author zhilinh
	 *
	 */
	private class Permutation implements Iterator<List<E>> {
		
		int index = 1;
		int pointer = 0;
		
		/**
		 * Method to switch two elements in list A.
		 * @param a index of the first element.
		 * @param b index of the second element.
		 */
		private void swap(int a, int b) {
			E k = A.get(a);
			A.set(a, A.get(b));
			A.set(b, k);
		}
		
		/**
		 * Method to determine whether go iteration.
		 * When the index gets the end of the list, it stops.
		 */
		@Override
		public boolean hasNext() {
			if (index < n) {
				return true;
			} else {
				return false;
			}
		}
		
		/**
		 * Method to generate the next permutation and move the index.
		 */
		@Override
		public List<E> next() {
			if (this.hasNext()) {
				if (pointer == 0) {
					pointer++;
					return A;
				}
				while (index < n) {
					if (c.get(index) < index) {
						if (index % 2 == 0) {
							swap(0, index);
						} else {
							swap(c.get(index), index);
						}
						c.set(index, c.get(index) + 1);
						index = 1;
						return A;
					} else {
						c.set(index, 0);
						index++;
					}
				}
			}
			return new ArrayList<E>();
		}
	}
}