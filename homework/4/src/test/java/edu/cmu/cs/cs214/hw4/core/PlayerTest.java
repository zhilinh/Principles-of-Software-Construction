package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.cmu.cs.cs214.hw4.core.specialtile.Boom;
import edu.cmu.cs.cs214.hw4.core.specialtile.SpecialTile;

public class PlayerTest {

	private Board board = new Board();
	private Move move;
	private Player player = new Player("Lin");
	private Tile tile0 = new Tile('S', 0);
	private Tile tile1 = new Tile('A', 1);
	private Tile tile2 = new Tile('B', 2);
	private Tile tile3 = new Tile('C', 3);
	private SpecialTile sp = new Boom();
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<Location> locs = new ArrayList<Location>();
	private List<SpecialTile> spTiles = new ArrayList<SpecialTile>();
	private Location loc1 = board.getLocation(7, 7);
	private Location loc2 = board.getLocation(7, 8);
	
	@Test
	public void testTile() {
		tiles.add(tile0);												//initialize the player
		tiles.add(tile1);
		tiles.add(tile2);
		spTiles.add(sp);
		player.addTiles(tiles);
		player.addSpecialTile(sp);
		player.makeChallenge(true);
		player.skipFalse();
		player.skipTrue();
		assertTrue(player.getSkip());
		assertTrue(player.getChallenge());
		assertEquals(player.getName(), "Lin");
		assertEquals(player.getMaxNumTile(), 7);
		assertEquals(player.getSpecialTiles(), spTiles);
		
		tiles.remove(0);												//the player runs a move
		locs.add(loc1);
		locs.add(loc2);
		move = new Move(tiles, locs);
		player.runMove(board, move);
		assertEquals(player.getMove(), move);
		assertEquals(player.getLastMoveScore(), 4);
		assertEquals(player.getScore(), 4);
		
		tiles = new ArrayList<Tile>();									//test for exchange tiles
		tiles.add(tile3);
		player.exchangeTile(player.getTiles(), tiles);
		assertEquals(player.getTiles(), tiles);
	}
	
}
