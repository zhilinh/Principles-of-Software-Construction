package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.cs.cs214.hw4.core.specialtile.SpecialTile;

/**
 * Class to generate moves made by players.
 * @author zhilinh
 *
 */
public class Move {
	
	private Location startLocation;
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<SpecialTile> specialTiles = new ArrayList<SpecialTile>();
	private List<Location> locs = new ArrayList<Location>();
	private List<Location> spLocs = new ArrayList<Location>();
	private List<Word> wordList = new ArrayList<Word>();
	private boolean firstMove;
	
	public Move(List<Tile> tiles, List<Location> locs) {
		this.tiles = tiles;
		this.locs = locs;
		startLocation = locs.get(0);
	}
	
	/**
	 * Method to check if it is the first move.
	 * @return true if it is and vice versa.
	 */
	public boolean isFirstMove() {
		return firstMove;
	}
	
	/**
	 * Method to remove the tile on the location.
	 */
	public void removeTile() {
		for (Location loc : locs) {
			loc.removeTile();
		}
	}
	
	/**
	 * Method to remove the special tile on the location.
	 */
	public void removeSpecialTile() {
		for (Location loc : spLocs) {
			loc.removeSpecialTile();
		}
	}
	
	/**
	 * Method to place tiles on many locations of the move.
	 */
	public void placeTile() {
		for (int i = 0; i < locs.size(); i++) {
			locs.get(i).placeTile(tiles.get(i));
		}
	}
	
	/**
	 * Method to place special tiles of the move.
	 */
	public void placeSpecialTile() {
		for (int i = 0; i < spLocs.size(); i++) {
			spLocs.get(i).placeSpecialTile(specialTiles.get(i));
		}
	}
	
	/**
	 * Method to get the number of tiles of the move.
	 * @return the number of tiles
	 */
	public int getTileNumber() {
		return tiles.size();
	}
	
	/**
	 * Method to get the start location of the move.
	 * @return the start location
	 */
	public Location getStartLocation() {
		return startLocation;
	}
	
	/**
	 * Method to get tiles of the move.
	 * @return
	 */
	public List<Tile> getTiles() {
		return tiles;
	}
	
	/**
	 * Method to get a list of locations of the move.
	 * @return a list of locations
	 */
	public List<Location> getLocations() {
		return locs;
	}
	
	/**
	 * Method to get the list of words in the move.
	 * @return
	 */
	public List<Word> getWordList() {
		return wordList;
	}
	
	/**
	 * Method to get a list of words by the move and update the value of words by multipliers.
	 * @param board of the game
	 * @param locs locations of the move
	 * @return a list of words made by the move
	 */
	public void getWords(Board board, List<Location> locs) {
		Word word = new Word();
		wordList = new ArrayList<Word>();
		
		for (Location i : locs) {
			word.addBaseValue(i.getTile().getValue());
			word.addLetter(i.getTile().getLetter());
			word.addLocation(i);
			if (i.getMultiplier() != null) {
				i.getMultiplier().updateWord(word, i.getTile());
			}
		}
		word.multiplyBaseValue();
		wordList.add(word);
		
		if (locs.size() == 1) {
			wordList.addAll(makeWords(board, true));
			wordList.addAll(makeWords(board, false));
		} else {
			if (locs.get(0).getX() == locs.get(1).getX()) {
				wordList.addAll(makeWords(board, true));
			} else {
				wordList.addAll(makeWords(board, false));
			}
		}
	}
	
	/**
	 * Method to get the extra words horizontally and vertically made by the move.
	 * @param board of the game
	 * @param pointer to indicate which direction to extend
	 * @return a list of extra words
	 */
	private List<Word> makeWords(Board board, boolean pointer) {
		Word word;
		List<Word> wordList = new ArrayList<Word>();
		
		for (Location i : locs) {
			word = new Word();
			int x = i.getX();
			int y = i.getY();
			while (board.getLocation(x, y).isOnNormalTile()) {
				if (pointer) {
					if (y == 0) {
						break;
					}
					y--;
				} else {
					if (x == 0) {
						break;
					}
					x--;	
				}				
			}
			while (board.getLocation(x, y).isOnNormalTile()) {
				word.addBaseValue(board.getLocation(x, y).getTile().getValue());
				word.addLetter(board.getLocation(x, y).getTile().getLetter());
				word.addLocation(i);
				if (pointer) {
					y++;
				} else {
					x++;
				}
			}
			if (i.getMultiplier() != null) {
				i.getMultiplier().updateWord(word, i.getTile());
			}
			wordList.add(word);
		}
		return wordList;
	}
}
