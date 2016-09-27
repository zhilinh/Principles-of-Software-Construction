package edu.cmu.cs.cs214.hw3;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CombinationTest {

	private Combination test;
	private List<Integer> array = new ArrayList<Integer>();
	
	@Before
	public void setup() {
		int n = 1;
		this.test = new Combination(n);
		array.add(0);array.add(1);array.add(2);
		array.add(3);array.add(4);array.add(5);
		array.add(6);array.add(7);array.add(8);
		array.add(9);
	}
	
	@Test
	public void testonetoTen() {
		assertEquals(test.onetoTen(), array);
	}
	
	@Test
	public void testGenerator() {
		test.generator(array, new ArrayList<Integer>());
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i : array) {
			List<Integer> sList = new ArrayList<Integer>();
			sList.add(i);
			list.add(sList);
		}
		assertEquals(list, test.getcList());
	}
}
