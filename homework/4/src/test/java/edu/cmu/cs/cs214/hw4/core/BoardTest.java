package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BoardTest {
	
	private String[] args = {"Lin"};
	private Scrabble scrabble = new Scrabble(args);
	private Move move;
	private Tile tile1 = new Tile('A', 1);
	private Tile tile2 = new Tile('B', 2);
	private Tile tile3 = new Tile('C', 3);
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<Location> locs = new ArrayList<Location>();
	private Location loc1 = new Location(7, 7);
	private Location loc2 = new Location(7, 8);
	private Location loc3 = new Location(8, 7);

	@Test
	public void testisOnStar() {
		tiles.add(tile1);
		locs.add(loc1);
		move = new Move(tiles, locs);
		assertTrue(scrabble.getBoard().isOnStar(move));
		
		locs.remove(loc1);
		locs.add(loc2);
		move = new Move(tiles, locs);
		assertFalse(scrabble.getBoard().isOnStar(move));
	}
	
	@Test
	public void testCheckInLine() {
		tiles.add(tile1);
		locs.add(loc1);
		move = new Move(tiles, locs);
		assertTrue(scrabble.getBoard().checkInLine(move));
		
		tiles.add(tile2);
		locs.add(loc2);
		move = new Move(tiles, locs);
		assertTrue(scrabble.getBoard().checkInLine(move));
		
		tiles.add(tile3);
		locs.add(loc3);
		move = new Move(tiles, locs);
		assertFalse(scrabble.getBoard().checkInLine(move));
		
		tiles.remove(tile2);
		locs.remove(loc2);
		move = new Move(tiles, locs);
		assertTrue(scrabble.getBoard().checkInLine(move));
	}
	
}
