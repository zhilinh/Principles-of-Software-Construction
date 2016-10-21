package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate a word made by letters of tiles.
 * @author zhilinh
 *
 */
public class Word {
	
	private String word = "";
	private int value = 0;
	private int multipleTimes = 1;
	private List<Location> locs = new ArrayList<Location>();
	
	/**
	 * Method to add a letter to the word.
	 * @param letter to be added
	 */
	public void addLetter(Character letter) {
		word += letter;
	}
	
	/**
	 * Method to add base values to the value of word.
	 * @param value to be added
	 */
	public void addBaseValue(Integer value) {
		this.value += value;
	}
	
	/**
	 * Method to add the location of tile in the word.
	 * @param loc of added tile
	 */
	public void addLocation(Location loc) {
		locs.add(loc);
	}
	
	/**
	 * Method to get the locations of tiles in the word.
	 * @return a list of locations
	 */
	public List<Location> getLocations() {
		return locs;
	}
	
	/**
	 * Method to get the word.
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Method to get the multiplied times.
	 * @return the multiple times
	 */
	public int getMultipleTimes() {
		return multipleTimes;
	}
	
	/**
	 * Method to get the length of the word.
	 * @return the length of the word
	 */
	public int getWordLength() {
		return word.length();
	}
	
	/**
	 * Method to get the product of the base value and multiplied times.
	 */
	public void multiplyBaseValue() {
		this.value *= multipleTimes;
	}
	
	/**
	 * Method to update the multiplied times.
	 * @param times to be added
	 */
	public void updateMultipleTimes(Integer times) {
		if (multipleTimes == 1) {
			multipleTimes = times;
		} else {
			multipleTimes += times;
		}
	}
	
	/**
	 * Method to get the value of the word.
	 * @return the value of the word.
	 */
	public int getValue() {
		return value;
	}
}
	