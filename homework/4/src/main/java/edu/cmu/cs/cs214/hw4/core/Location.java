package edu.cmu.cs.cs214.hw4.core;

import edu.cmu.cs.cs214.hw4.core.multiplier.Multiplier;
import edu.cmu.cs.cs214.hw4.core.specialtile.SpecialTile;

/**
 * Class to include all information needed on a square of the board.
 * @author zhilinh
 *
 */
public class Location {
	
	private int x, y;
	private Tile tile = null;
	private SpecialTile specialTile = null;
	private Multiplier multiplier = null;
	
	/**
	 * Constructor to generate a location with index x and y.
	 * @param x index x
	 * @param y index y
	 */
	public Location(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Method to place a tile on the location.
	 * @param tile to be placed
	 */
	public void placeTile(Tile tile) {
		this.tile = tile;
	}
	
	/**
	 * Method to place special tile on the location.
	 * @param st special tile to be placed
	 */
	public void placeSpecialTile(SpecialTile st) {
		specialTile = st;
	}
	
	/**
	 * Method to set the multiplier on the location.
	 * @param multiplier to be placed
	 */
	public void setMultiplier(Multiplier multiplier) {
		this.multiplier = multiplier;
	}
	
	/**
	 * Method to get the index x.
	 * @return index x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Method to get the index y.  
	 * @return index y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Method to get the tile on the location.
	 * @return tile on the location
	 */
	public Tile getTile() {
		return tile;
	}
	
	/**
	 * Method to get the special tile on the location.
	 * @return special tile on the location
	 */
	public SpecialTile getSpecialTile() {
		return specialTile;
	}
	
	/**
	 * Method to get the multiplier on the location.
	 * @return multiplier on the location
	 */
	public Multiplier getMultiplier() {
		return multiplier;
	}
	
	/**
	 * Method to remove the tile on the location.
	 */
	public void removeTile() {
		tile = null;
	}
	
	/**
	 * Method to remove the special tile on the location.
	 */
	public void removeSpecialTile() {
		specialTile = null;
	}
	
	/**
	 * Method to check if there is a normal tile on the location.
	 * @return true if there is a normal tile and vice versa
	 */
	public boolean isOnNormalTile() {
		if (tile != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check if there is a special tile on the location.
	 * @return true if there is a special tile and vice versa
	 */
	public boolean isOnSpecialTile() {
		if (specialTile != null) {
			return true;
		} else {
			return false;
		}
	}
}
