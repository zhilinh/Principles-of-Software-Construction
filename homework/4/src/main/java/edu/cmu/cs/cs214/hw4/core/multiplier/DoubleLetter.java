package edu.cmu.cs.cs214.hw4.core.multiplier;

import edu.cmu.cs.cs214.hw4.core.Tile;
import edu.cmu.cs.cs214.hw4.core.Word;

/**
 * Class to double the value of the tile.
 * @author zhilinh
 *
 */
public class DoubleLetter extends BaseMultiplier{

	private final String name = "2L";
	
	/**
	 * Method to get the name of the multiplier.
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Method to update the value of word by doubling the value of the tile.
	 */
	@Override
	public void updateWord(Word word, Tile tile) {
		int value = tile.getValue();
		word.addBaseValue(value);
	}
}
