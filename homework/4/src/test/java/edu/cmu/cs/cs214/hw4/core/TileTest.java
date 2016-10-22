package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class to test the tile of the game.
 * @author zhilinh
 *
 */
public class TileTest {

	private Tile tile = new Tile('A', 1);
	
	/**
	 * Test for getting the letter of the tile.
	 */
	@Test
	public void testGetLetter() {
		assertEquals('A', tile.getLetter());
	}
	
	/**
	 * Test for getting the value of the tile.
	 */
	@Test
	public void testGetValue() {
		assertEquals(1, tile.getValue());
	}
	
}
