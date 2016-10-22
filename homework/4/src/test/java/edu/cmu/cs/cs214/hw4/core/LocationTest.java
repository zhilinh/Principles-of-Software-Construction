package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.cmu.cs.cs214.hw4.core.multiplier.DoubleLetter;
import edu.cmu.cs.cs214.hw4.core.multiplier.Multiplier;
import edu.cmu.cs.cs214.hw4.core.specialtile.Boom;
import edu.cmu.cs.cs214.hw4.core.specialtile.SpecialTile;

/**
 * Class to test the Location class.
 * @author zhilinh
 *
 */
public class LocationTest {
	
	private Move move;
	private Location loc = new Location(7, 7);
	private Tile tile = new Tile('A', 1);
	private SpecialTile st = new Boom();
	private Multiplier m = new DoubleLetter();

	/**
	 * Test to check the location setting.
	 */
	@Test
	public void testTile() {
		loc.placeTile(tile);
		loc.placeSpecialTile(st);
		assertEquals(loc.getX(), 7);
		assertEquals(loc.getY(), 7);
		assertEquals(loc.getTile(), tile);
		assertEquals(loc.getSpecialTile(), st);
		assertTrue(loc.isOnNormalTile());
		assertTrue(loc.isOnSpecialTile());
		loc.removeSpecialTile();
		loc.removeTile();
		assertEquals(loc.getTile(), null);
		assertEquals(loc.getSpecialTile(), null);
		assertFalse(loc.isOnNormalTile());
		assertFalse(loc.isOnSpecialTile());
		loc.setMultiplier(m);
		assertEquals(loc.getMultiplier(), m);
	}
	
}
