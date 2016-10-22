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
	private Tile tile4 = new Tile('D', 4);
	private Tile tile5 = new Tile('E', 5);
	private Tile tile6 = new Tile('F', 6);
	private Tile tile7 = new Tile('G', 7);
	private SpecialTile sp = new Boom();
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<Location> locs = new ArrayList<Location>();
	private List<SpecialTile> spTiles = new ArrayList<SpecialTile>();
	private List<Location> spLocs = new ArrayList<Location>();
	private Location loc0 = board.getLocation(7, 6);
	private Location loc1 = board.getLocation(7, 7);
	private Location loc2 = board.getLocation(7, 8);
	private Location loc3 = board.getLocation(5, 7);
	private Location loc4 = board.getLocation(6, 7);
	private Location loc5 = board.getLocation(6, 8);
	private Location loc6 = board.getLocation(6, 6);
	private Location loc7 = board.getLocation(4, 7);
	
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
		assertEquals(player.getMaxNumTile(), 5);
		assertEquals(player.getSpecialTileInventory(), spTiles);
		
		tiles.remove(0);												//the player runs a move
		locs.add(loc1);
		locs.add(loc2);
		move = new Move(tiles, locs);
		player.runMove(board, move);
		assertEquals(player.getMove(), move);
		assertEquals(player.getLastMoveScore(), 3);
		assertEquals(player.getScore(), 3);
		
		tiles = new ArrayList<Tile>();									//test for exchange tiles
		tiles.add(tile3);
		player.exchangeTile(player.getTiles(), tiles);
		assertEquals(player.getTiles(), tiles);
	}
	
}
