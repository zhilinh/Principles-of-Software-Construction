package edu.cmu.cs.cs214.hw4.core.specialtile;

import edu.cmu.cs.cs214.hw4.core.Location;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Scrabble;

/**
 * Class to generate the NegativePoints special tile.
 * @author zhilinh
 *
 */
public class NegativePoints extends BaseSpecialTile {

	private final int price = 20;
	private final String name = "Negative";
	private Player currentPlayer;
	
	/**
	 * Method to activate the special tile and update the score of the current player. 
	 */
	@Override
	public String activateSp(Scrabble scrabble, Location loc) {
		currentPlayer = scrabble.getCurrentPlayer();
		currentPlayer.updateScore(-2 * currentPlayer.getLastMoveScore());
		return "Negative Points by " + this.getOwner().getName() + "!";
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
