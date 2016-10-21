package edu.cmu.cs.cs214.hw4.core.multiplier;

import edu.cmu.cs.cs214.hw4.core.Tile;
import edu.cmu.cs.cs214.hw4.core.Word;

/**
 * Class to double the value of the word.
 * @author zhilinh
 *
 */
public class DoubleWord extends BaseMultiplier{
	
	private final String name = "DoubleWord";
	
	/**
	 * Method to get the name of the multiplier.
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Method to update the word by doubling the value.
	 */
	@Override
	public void updateWord(Word word, Tile tile) {
		word.updateMultipleTimes(2);
	}
}
