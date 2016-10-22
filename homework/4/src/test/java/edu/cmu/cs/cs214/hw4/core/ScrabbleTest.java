package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ScrabbleTest {

	private String[] args = {"Lin", "Jesse"};
	private Scrabble scrabble = new Scrabble(args);
	private Player player = scrabble.getCurrentPlayer();
	private Board board = scrabble.getBoard();
	private Tile tile0 = new Tile('H', 1);
	private Tile tile1 = new Tile('I', 2);
	private Tile tile2 = new Tile('Z', 1);
	private Tile tile3 = new Tile('Z', 2);
	private Location loc0 = new Location(7, 7);
	private Location loc1 = new Location(7, 8);
	private Location loc2 = new Location(6, 7);
	private Location loc3 = new Location(6, 8);
	private List<Player> players = scrabble.getPlayers();
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<Location> locs = new ArrayList<Location>();
	private Move move;
	
	@Test
	public void testMakeMove() {
		tiles.add(tile0);											//Challenge Failed
		tiles.add(tile1);
		locs.add(loc0);
		locs.add(loc1);
		move = new Move(tiles, locs);
		move.setFirstMove();
		player.addTiles(tiles);
		scrabble.giveTiles(1, player);
		players.get(1).makeChallenge(true);
		scrabble.makeMove(move);
		scrabble.runGame(move);
		assertEquals(scrabble.getLastMove(player), move);
		assertEquals(scrabble.getPlayerNum(), 0);
		assertEquals(scrabble.getScore(player), 3);
		assertFalse(scrabble.doesGameStop());
		player = scrabble.getNextPlayer();
		scrabble.reverseCounterNum();
		scrabble.reverseCounterNum();
		
		tiles = new ArrayList<Tile>();
		locs = new ArrayList<Location>();
		tiles.add(tile2);											//Challenge Successed
		tiles.add(tile3);
		locs.add(loc2);
		locs.add(loc3);
		move = new Move(tiles, locs);
		player.addTiles(tiles);
		scrabble.giveTiles(100, player);
		players.get(0).makeChallenge(true);
		scrabble.makeMove(move);
		assertTrue(scrabble.doesGameStop());
		assertEquals(scrabble.getScore(player), 0);
		assertEquals(scrabble.getWinner().get(0), players.get(0));
	}
	
}
