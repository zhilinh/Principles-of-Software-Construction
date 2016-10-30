package edu.cmu.cs.cs214.hw4.core.multiplier;

import edu.cmu.cs.cs214.hw4.core.Tile;
import edu.cmu.cs.cs214.hw4.core.Word;

/**
 * Class to triple the value of the word.
 * @author zhilinh
 *
 */
public class TripleWord extends BaseMultiplier{

	private final String name = "3W";
	
	/**
	 * Method to get the name of the multiplier.
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Method to update the value of the word by tripling.
	 */
	@Override
	public void updateWord(Word word, Tile tile) {
		word.updateMultipleTimes(3);
	}
}
