package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * Class to test the board of the game.
 * @author zhilinh
 *
 */
public class BoardTest {
	
	private Scrabble scrabble = new Scrabble();
	private Board board = scrabble.getBoard();
	private Move move;
	private Tile tile0 = new Tile('S', 0);
	private Tile tile1 = new Tile('A', 1);
	private Tile tile2 = new Tile('B', 2);
	private Tile tile3 = new Tile('C', 3);
	private Tile tile4 = new Tile('D', 4);
	private Tile tile5 = new Tile('E', 5);
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<Location> locs = new ArrayList<Location>();
	private Location loc0 = new Location(7, 6);
	private Location loc1 = new Location(7, 7);
	private Location loc2 = new Location(7, 8);
	private Location loc3 = new Location(5, 7);
	private Location loc4 = new Location(6, 7);
	private Location loc5 = new Location(6, 8);

	/**
	 * Test to check whether the first move is on the star.
	 */
	@Test
	public void testisOnStar() {
		tiles.add(tile1);
		locs.add(loc1);
		move = new Move(tiles, locs);
		move.setFirstMove();
		assertTrue(board.isOnStar(move));
		
		locs.remove(loc1);
		locs.add(loc2);
		move = new Move(tiles, locs);
		assertFalse(board.isOnStar(move));
	}
	
	/**
	 * Test to check whether the tiles placed by the move is in a straight line
	 * without vacant tiles between them.
	 */
	@Test
	public void testCheckInLine() {
		
		tiles.add(tile0);										//only tile0
		locs.add(loc0);
		move = new Move(tiles, locs);
		assertTrue(board.checkInLine(move));
		
		tiles.add(tile2);										//tile0, tile2 in the same line
		locs.add(loc2);											//with one vacant tile between them
		move = new Move(tiles, locs);
		assertFalse(board.checkInLine(move));
		
		tiles.add(tile1);										//tile0, tile1, tile2 in the same line
		locs.add(loc1);
		move = new Move(tiles, locs);
		assertTrue(board.checkInLine(move));
		
		tiles.add(tile3);										//tile0, 1, 2 and tile3
		locs.add(loc3);											//not in the same row
		move = new Move(tiles, locs);
		assertFalse(board.checkInLine(move));
		
		tiles.remove(tile0); tiles.remove(tile2); 				//tile1, tile3 in the same col
		locs.remove(loc0); locs.remove(loc2);					//with one vacant tile between them
		move = new Move(tiles, locs);
		assertFalse(board.checkInLine(move));
		
		tiles.add(tile4);										//tile1, tile3, tile4 in the same col
		locs.add(loc4);
		move = new Move(tiles, locs);
		assertTrue(board.checkInLine(move));
		
		tiles.add(tile5);										//tile1, 3, 4 tiles and tile5
		locs.add(loc5);											//not in the same col
		move = new Move(tiles, locs);
		assertFalse(board.checkInLine(move));
		
		tiles.remove(tile3); tiles.remove(tile4); 				//tile1 and tile5 not in the same row or col
		locs.remove(loc3); locs.remove(loc4);
		move = new Move(tiles, locs);
		assertFalse(board.checkInLine(move));
	}
	
	/**
	 * Test to check whether the placed tiles by the move is adjacent to the existed tiles.
	 */
	@Test
	public void testIsAdjacent() {
		move = new Move(tiles, locs);							//no tile placed
		assertTrue(board.isAdjacent(move));
		
		tiles.add(tile0);										//center placed tile
		locs.add(board.getLocation(7, 6));
		move = new Move(tiles, locs);
		move.placeTile(board);
		
		tiles.remove(0); tiles.add(tile1);						//down
		locs.remove(0); locs.add(board.getLocation(7, 7));
		move = new Move(tiles, locs);
		assertTrue(board.isAdjacent(move));
		
		tiles.remove(0); tiles.add(tile1);						//up
		locs.remove(0); locs.add(board.getLocation(7, 5));
		move = new Move(tiles, locs);
		assertTrue(board.isAdjacent(move));
		
		tiles.remove(0); tiles.add(tile1);						//left
		locs.remove(0); locs.add(board.getLocation(6, 6));
		move = new Move(tiles, locs);
		assertTrue(board.isAdjacent(move));
		
		tiles.remove(0); tiles.add(tile1);						//right
		locs.remove(0); locs.add(board.getLocation(8, 6));
		move = new Move(tiles, locs);
		assertTrue(board.isAdjacent(move));
		
		tiles.remove(0); tiles.add(tile1);						//not adjacent
		locs.remove(0); locs.add(board.getLocation(6, 7));
		move = new Move(tiles, locs);
		assertFalse(board.isAdjacent(move));
	}
	
}
