package edu.cmu.cs.cs214.hw4.core.multiplier;

import edu.cmu.cs.cs214.hw4.core.Tile;
import edu.cmu.cs.cs214.hw4.core.Word;

/**
 * Interface to generate multipliers.
 * @author zhilinh
 *
 */
public interface Multiplier {
	
	/**
	 * Method to get the name of the multiplier.
	 * @return
	 */
	public String getName();
	
	/**
	 * Method to update the value of the word.
	 * @param word to be updated
	 * @param tile to get the value
	 */
	public void updateWord(Word word, Tile tile);
}
