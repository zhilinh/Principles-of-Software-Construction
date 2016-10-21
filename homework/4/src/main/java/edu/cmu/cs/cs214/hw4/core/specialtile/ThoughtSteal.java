package edu.cmu.cs.cs214.hw4.core.specialtile;

import edu.cmu.cs.cs214.hw4.core.Location;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Scrabble;

/**
 * Class to copy the score from the activator to the owner.
 * Inspired by Hearthstone.
 * @author zhilinh
 *
 */
public class ThoughtSteal extends BaseSpecialTile {

	private final int price = 25;
	private final String name = "ThoughtSteal";
	private Player currentPlayer;
	private int originalScore;
	
	/**
	 * Method to activate the special tile and update the score of the owner
	 * copied by the current player.
	 */
	@Override
	public void activateSp(Scrabble scrabble, Location loc) {
		originalScore = this.getOwner().getScore();
		this.getOwner().updateScore(-originalScore);
		currentPlayer = scrabble.getCurrentPlayer();
		this.getOwner().updateScore(currentPlayer.getScore());
	}

	/**
	 * Method to deactivate the special tile.
	 */
	@Override
	public void deactivateSp(Scrabble scrabble, Location loc) {
		this.getOwner().updateScore(-this.getOwner().getScore() + originalScore);
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
