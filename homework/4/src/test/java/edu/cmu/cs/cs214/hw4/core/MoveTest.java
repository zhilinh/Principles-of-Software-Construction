package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.cmu.cs.cs214.hw4.core.specialtile.Boom;
import edu.cmu.cs.cs214.hw4.core.specialtile.SpecialTile;

/**
 * Class to test the move in the game.
 * @author zhilinh
 *
 */
public class MoveTest {

	private Board board = new Board();
	private Move move;
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
	private List<Word> wordList = new ArrayList<Word>();
	private Location loc0 = board.getLocation(7, 6);
	private Location loc1 = board.getLocation(7, 7);
	private Location loc2 = board.getLocation(7, 8);
	private Location loc3 = board.getLocation(5, 7);
	private Location loc4 = board.getLocation(6, 7);
	private Location loc5 = board.getLocation(6, 8);
	private Location loc6 = board.getLocation(6, 6);
	private Location loc7 = board.getLocation(4, 7);

	/**
	 * Method to check the scores of words in the word list to be correct. 
	 * @param ans
	 */
	private void makeWord(int ans) {
		move = new Move(tiles, locs);
		move.placeTile(board);
		move.getWords(board, locs);
		wordList = move.getWordList();
		int sum = 0;
		for (Word i : wordList) {
			sum += i.getValue();
		}
		assertEquals(sum, ans);
	}
	
	/**
	 * Test for different positions of tiles to get words.
	 */
	@Test
	public void testTile() {
		spTiles.add(sp);										//add special tile Boom and no tile
		spLocs.add(loc0);
		move = new Move(tiles, locs);
		move.placeSpecialTile(spTiles, spLocs, board);
		move.removeSpecialTile();
		assertEquals(move.getStartLocation(), null);
		
		tiles.add(tile0);										//add a line of tiles to the move
		locs.add(loc0);
		tiles.add(tile1);
		locs.add(loc1);
		tiles.add(tile2);
		locs.add(loc2);
		
		move = new Move(tiles, locs);							//test the basic functions of move
		move.setFirstMove();									//for tiles and locations
		assertTrue(move.isFirstMove());
		move.placeTile(board);
		assertEquals(move.getTileNumber(), 3);
		assertEquals(move.getStartLocation(), loc0);
		assertEquals(move.getTiles(), tiles);
		assertEquals(move.getLocations(), locs);		
		
		tiles = new ArrayList<Tile>();							//test the word function to get 
		locs = new ArrayList<Location>();						//the correct word list with two
		tiles.add(tile4);										//tiles in the same col
		locs.add(loc4);
		tiles.add(tile5);
		locs.add(loc5);
		makeWord(21);
		
		tiles = new ArrayList<Tile>();							//test the word function with one tile 
		locs = new ArrayList<Location>();
		tiles.add(tile6);
		locs.add(loc6);
		makeWord(21);
		
		tiles = new ArrayList<Tile>();							//test the word function with two tiles 
		locs = new ArrayList<Location>();						//in the same row
		tiles.add(tile3);
		locs.add(loc3);
		tiles.add(tile7);
		locs.add(loc7);
		makeWord(15);		
		move.removeTile();
	}
}
