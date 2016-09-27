package edu.cmu.cs.cs214.hw3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class IteratorTest {
	
	private ArrayIterator<Integer> ai;
	
	@Before
	public void setup() {
		List<Integer> array = new ArrayList<Integer>();
		int n = 2;
		array.add(0);
		array.add(1);
		this.ai = new ArrayIterator<Integer>(n, array);
	}

	@Test
	public void testIterator() {
		Iterator<List<Integer>> permutationTest = ai.iterator();
		List<Integer> array1 = new ArrayList<Integer>();
		List<Integer> array2 = new ArrayList<Integer>();
		List<Integer> array3 = new ArrayList<Integer>();
		List<List<Integer>> array4 = new ArrayList<List<Integer>>();
		List<List<Integer>> array5 = new ArrayList<List<Integer>>();
		array1.add(0);array1.add(1);
		array2.add(1);array2.add(0);
		array4.add(array1);array4.add(array2);array4.add(array3);
		while (permutationTest.hasNext()) {			
			List<Integer> s = permutationTest.next();
			array5.add(new ArrayList<Integer>(s));
		}
		assertEquals(array4, array5);		
	}

}
