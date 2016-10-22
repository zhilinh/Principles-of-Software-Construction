package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Class to generate the Tile Log of the game.
 * @author zhilinh
 *
 */
public class TileLogTest {

	private TileLog tileLog = new TileLog();
	
	@Test
	public void testTileNumber () {
		assertEquals(tileLog.getLeftTilesNumber(), (Integer) 98);
	}
	
	@Test
	public void testGetTiles() {
		assertEquals(tileLog.getTiles(1).size(), 1);
	}
	
	@Test
	public void testIsEmptyAndAdd() {
		Tile tile = new Tile('A', 1);
		assertFalse(tileLog.isEmpty());
		List<Tile> tiles = tileLog.getTiles(98);
		assertTrue(tileLog.isEmpty());
		tileLog.addTiles(tile, 1);
		assertEquals(tileLog.getLeftTilesNumber(), (Integer) 1);
	}
}
