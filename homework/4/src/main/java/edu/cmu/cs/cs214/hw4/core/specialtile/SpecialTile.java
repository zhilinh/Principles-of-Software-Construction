package edu.cmu.cs.cs214.hw4.core.specialtile;

import edu.cmu.cs.cs214.hw4.core.Location;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Scrabble;

/**
 * Interface to generate special tiles.
 * @author zhilinh
 *
 */
public interface SpecialTile {

	/**
	 * Method to activate special tiles. 
	 */
	public void activateSp(Scrabble scrabble, Location loc);
	
	/**
	 * Method to deactivate special tiles. 
	 */
	public void deactivateSp(Scrabble scrabble, Location loc);
	
	/**
	 * Method to set the owner of the special tile. 
	 */
	public void setOwner(Player player);
	
	/**
	 * Method to get the name of the special tile. 
	 */
	public String getName();
	
	/**
	 * Method to get the owner of the special tile. 
	 */
	public Player getOwner();
	
	/**
	 * Method to get the price of the special tile.
	 */
	public int getPrice();
}
