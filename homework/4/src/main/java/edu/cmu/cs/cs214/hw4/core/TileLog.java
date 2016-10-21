package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to generate a Tile Log to store all tiles of the game.
 * @author zhilinh
 *
 */
public class TileLog {
	
	private List<Tile> tiles = new ArrayList<Tile>();
	private final char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final int[] values = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private final int[] freqs = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
	
	/**
	 * Constructor to generate all shuffled tiles in the Tile Log.
	 */
	public TileLog() {
		for (int i = 0; i < 26; i++) {
			this.addTiles(new Tile(letters[i], values[i]), freqs[i]);
		}
		Collections.shuffle(tiles);
	}
	
	/**
	 * Method to get the number of left tiles in the Tile Log.
	 * @return the number of left tiles
	 */
	public Integer getLeftTilesNumber() {
		return tiles.size();
	}
	
	/**
	 * Method to get random tiles from the Tile Log.
	 * @param num the number of random tiles given
	 * @return a list of given tiles
	 */
	public List<Tile> getTiles(Integer num) {
		List<Tile> newTiles = new ArrayList<Tile>(tiles.subList(0, num));
		tiles = tiles.subList(num, tiles.size());
		return newTiles;
	}
	
	/**
	 * Method to indicate whether the Tile Log is empty.
	 * @return true if the Tile Log is empty
	 */
	public boolean isEmpty() {
		return tiles.isEmpty();
	}
	
	/**
	 * Method to add random tiles to the Tile Log.
	 * @param tile to be added
	 * @param freq is how many tiles would be added
	 */
	public void addTiles(Tile tile, int freq) {
		for (int i = 0; i < freq; i++) {
			tiles.add(new Tile(tile.getLetter(), tile.getValue()));
		}
	}
}
