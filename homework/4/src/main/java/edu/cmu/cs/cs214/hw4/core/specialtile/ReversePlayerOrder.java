package edu.cmu.cs.cs214.hw4.core.specialtile;

import edu.cmu.cs.cs214.hw4.core.Location;
import edu.cmu.cs.cs214.hw4.core.Scrabble;

/**
 * Class to reverse the play order of the game.
 * @author zhilinh
 *
 */
public class ReversePlayerOrder extends BaseSpecialTile {
	
	private final int price = 10;
	private final String name = "Reverse";
	
	/**
	 * Method to activate the special tile and reserve the play order.
	 */
	@Override
	public String activateSp(Scrabble scrabble, Location loc) {
		scrabble.reverseCounterNum();
		return "Play order reversed by " + this.getOwner().getName() + "!";
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
