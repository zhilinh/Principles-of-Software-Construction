package edu.cmu.cs.cs214.hw4.core.specialtile;

import edu.cmu.cs.cs214.hw4.core.Location;
import edu.cmu.cs.cs214.hw4.core.Scrabble;

/**
 * Class to generate the unknown special tile.
 * @author zhilinh
 *
 */
public class RotateDown extends BaseSpecialTile {
	
	private final int price = 15;
	private final String name = "R.Down";
	
	/**
	 * Method to activate the special tile. 
	 */
	@Override
	public String activateSp(Scrabble scrabble, Location loc) {
		return "Whole board rotated down by " + this.getOwner().getName() + "!";
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
