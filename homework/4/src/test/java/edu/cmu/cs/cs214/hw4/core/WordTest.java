package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordTest {

	private Tile tile0 = new Tile('A', 1);
	private Tile tile1 = new Tile('B', 2);
	private Location loc0 = new Location(0, 0);
	private Location loc1 = new Location(0, 1);
	private List<Location> locs = new ArrayList<Location>();
	private Word word = new Word();
	
	@Test
	public void testWord() {
		word.addLetter(tile0.getLetter());
		word.addBaseValue(tile0.getValue());
		word.addLocation(loc0);
		word.addLetter(tile1.getLetter());
		word.addBaseValue(tile1.getValue());
		word.addLocation(loc1);
		word.updateMultipleTimes(2);
		word.updateMultipleTimes(3);
		word.multiplyBaseValue();
		locs.add(loc0);
		locs.add(loc1);
		assertEquals(word.getWordLength(), 2);
		assertEquals(word.getWord(), "AB");
		assertEquals(word.getLocations(), locs);
		assertEquals(word.getValue(), 15);
		assertEquals(word.getMultipleTimes(), 5);
	}
}
