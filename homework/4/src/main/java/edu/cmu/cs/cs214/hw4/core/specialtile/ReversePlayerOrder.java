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
	private final String name = "ReverseScoreOrder";
	
	/**
	 * Method to activate the special tile and reserve the play order.
	 */
	@Override
	public void activateSp(Scrabble scrabble, Location loc) {
		scrabble.reverseCounterNum();
	}

	/**
	 * Method to deactivate the special tile. 
	 */
	@Override
	public void deactivateSp(Scrabble scrabble, Location loc) {
		scrabble.reverseCounterNum();
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
