package edu.cmu.cs.cs214.hw4.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Class to generate a dictionary to check the validation of words.
 * @author zhilinh
 *
 */
public class Dictionary {
	
	private HashSet<String> dic;
	
	/**
	 * Constructor to introduce the path of dictionary.
	 * @param path of the dictionary
	 */
	public Dictionary(String path) {
		dic = new HashSet<String>();
		this.getValidWords(path);
	}
	
	/**
	 * Method to scan the dictionary get words.
	 * @param path of the dictionary
	 */
	public void getValidWords(String path) {
		try {
			Scanner scanner = new Scanner(new File(path));
			while (scanner.hasNext()) {
				dic.add(scanner.next());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
		}
	}
	
	/**
	 * Method to check if the word is valid in the dictionary
	 */
	public boolean validateWord(String word) {
		String newWord = word.toLowerCase();
		if (! dic.contains(newWord)) {
			return true;
		}
		return false;
	}
}
