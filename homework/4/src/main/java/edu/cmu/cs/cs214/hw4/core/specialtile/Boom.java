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
	public void activateSp(Scrabble scrabble, Location loc) {
		Location setNull;
		for (int i = -boomRange; i < boomRange + 1; i++) {
			for (int j = -boomRange; j < boomRange + 1; j++) {
				try {
					setNull = scrabble.getBoard().getLocation(loc.getX() + i, loc.getY() + j);					
					for (Word k : scrabble.getCurrentPlayer().getMove().getWordList()) {
						if (k.getLocations().contains(setNull)) {
							int multiplier = 1;
							if (setNull.getMultiplier().getName().equals("DoubleLetter")) {
								multiplier = 2;
							} else if (setNull.getMultiplier().getName().equals("TripleLetter")) {
								multiplier = 3;
							}
							scrabble.getCurrentPlayer().updateScore(-k.getMultipleTimes() * setNull.getTile().getValue() * multiplier);
						}
					}
					
					scrabble.getCurrentPlayer().updateScore(setNull.getTile().getValue());
					setNull.removeTile();
					setNull.removeSpecialTile();
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}					
			}
		}
	}
	
	/**
	 * Method to deactivate the Boom.
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
