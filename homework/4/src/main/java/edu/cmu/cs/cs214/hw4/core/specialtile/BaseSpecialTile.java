package edu.cmu.cs.cs214.hw4.core.specialtile;

import edu.cmu.cs.cs214.hw4.core.Location;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Scrabble;

/**
 * Abstract class to generate special tiles.
 * @author zhilinh
 *
 */
public abstract class BaseSpecialTile implements SpecialTile {

	private Player owner;
	
	/**
	 * Method to activate the special tile.
	 */
	@Override
	public abstract String activateSp(Scrabble scrabble, Location loc);

	/**
	 * Method to set the owner of the special tile.
	 */
	@Override
	public void setOwner(Player player) {
		owner = player;
	}

	/**
	 * Method to get the name of the special tile.
	 */
	@Override
	public abstract String getName();

	/**
	 * Method to get the owner of the special tile.
	 */
	@Override
	public Player getOwner() {
		return owner;
	}

	/**
	 * Method to get the price of the special tile.
	 */
	@Override
	public abstract int getPrice();
}
