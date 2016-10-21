package edu.cmu.cs.cs214.hw4.core;

/**
 * Class to generate a tile with a letter and value.
 * @author zhilinh
 *
 */
public class Tile {
	
	private char letter;
	private int value;
	
	/**
	 * Constructor to generate a tile with a letter and value.
	 * @param letter on the tile
	 * @param value of the tile
	 */
	public Tile(Character letter, Integer value) {
		this.letter = letter;
		this.value = value;		
	}
	
	/**
	 * Method to get the letter on the tile.
	 * @return the letter on the tile
	 */
	public char getLetter() {
		return letter;
	}
	
	/**
	 * Method to get the value of the tile.
	 * @return the value of the tile
	 */
	public int getValue() {
		return value;
	}

}
