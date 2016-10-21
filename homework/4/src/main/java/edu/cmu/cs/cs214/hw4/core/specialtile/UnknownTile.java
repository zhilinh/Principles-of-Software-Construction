package edu.cmu.cs.cs214.hw4.core.specialtile;

import edu.cmu.cs.cs214.hw4.core.Location;
import edu.cmu.cs.cs214.hw4.core.Scrabble;

/**
 * Class to generate the unknown special tile.
 * @author zhilinh
 *
 */
public class UnknownTile extends BaseSpecialTile {
	
	private final int price = 30;
	private final String name = "UnknownTile";
	
	/**
	 * Method to activate the special tile. 
	 */
	@Override
	public void activateSp(Scrabble scrabble, Location loc) {
	}

	/**
	 * Method to deactivate the special tile. 
	 */
	@Override
	public void deactivateSp(Scrabble scrabble, Location loc) {
	}

	/**
	 * Method to get the name of the special tile. 
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Method to get the price of the special tile. 
	 */
	@Override
	public int getPrice() {
		return price;
	}

}
