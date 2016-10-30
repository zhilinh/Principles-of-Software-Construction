package edu.cmu.cs.cs214.hw4.core.specialtile;

import edu.cmu.cs.cs214.hw4.core.Location;
import edu.cmu.cs.cs214.hw4.core.Scrabble;
import edu.cmu.cs.cs214.hw4.core.Word;

/**
 * Class to generate the Boom special tile.
 * @author zhilinh
 *
 */
public class Boom extends BaseSpecialTile {

	private final int boomRange = 3;
	private final int price = 15;
	private final String name = "Boom";
	
	/**
	 * Method to activate Boom and remove all tiles within 3 squares from where the Boom is.
	 */
	@Override
	public String activateSp(Scrabble scrabble, Location loc) {
		Location setNull;
		for (int i = -boomRange; i < boomRange + 1; i++) {
			for (int j = -boomRange; j < boomRange + 1; j++) {
				if ((loc.getX() + i >= 0) && (loc.getX() + i <= 14)
						&& (loc.getY() + j >= 0) && (loc.getY() + j <= 14)) {
					setNull = scrabble.getBoard().getLocation(loc.getX() + i, loc.getY() + j);
					scrabble.addBoomArea(setNull);
					for (Word k : scrabble.getCurrentPlayer().getMove().getWordList()) {
						if (k.getLocations().contains(setNull)) {
							int multiplier = 1;
							if (setNull.getMultiplier() != null) {
								if (setNull.getMultiplier().getName().equals("2L")) {
									multiplier = 2;
								} else if (setNull.getMultiplier().getName().equals("3L")) {
									multiplier = 3;
								}
							}
							scrabble.getCurrentPlayer().updateScore(-(k.getMultipleTimes() * setNull.getTile().getValue() * multiplier));
						}
					}
					setNull.removeTile();
					setNull.removeSpecialTile();
				}				
			}
		}
		return "BOOM! by " + this.getOwner().getName();
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
