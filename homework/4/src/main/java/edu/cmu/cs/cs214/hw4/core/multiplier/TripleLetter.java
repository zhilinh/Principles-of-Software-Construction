package edu.cmu.cs.cs214.hw4.core.multiplier;

import edu.cmu.cs.cs214.hw4.core.Tile;
import edu.cmu.cs.cs214.hw4.core.Word;

/**
 * Class to triple the value of the word.
 * @author zhilinh
 *
 */
public class TripleLetter extends BaseMultiplier{
	
	private final String name = "TripleLetter";
	
	/**
	 * Method to get the name of the multiplier.
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Method to update the value of word by triping the value of the tile.
	 */
	@Override
	public void updateWord(Word word, Tile tile) {
		int value = tile.getValue() * 2;
		word.addBaseValue(value);		
	}
}
