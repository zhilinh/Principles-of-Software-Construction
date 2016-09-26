package edu.cmu.cs.cs214.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayIterator<E> implements Iterable<List<E>> {
	
	int n;
	List<Integer> c = new ArrayList<Integer>();
	List<E> A = new ArrayList<E>();
	
	public ArrayIterator(int n, List<E> A) {
		this.n = n;
		this.A = A;
		for (int i = 0; i < n; i++) {
			c.add(0);
		}
	}
	
	@Override
	public Iterator<List<E>> iterator() {
		return new Permutation();
	}
	
	private class Permutation implements Iterator<List<E>> {
		
		int index = 1;
		
		private void swap(int a, int b) {
			E k = A.get(a);
			A.set(a, A.get(b));
			A.set(b, k);
		}
		
		@Override
		public boolean hasNext() {
			if (index < n) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public List<E> next() {
			if (this.hasNext()) {
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