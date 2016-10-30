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
	
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<SpecialTile> specialTiles = new ArrayList<SpecialTile>();
	private List<Location> locs = new ArrayList<Location>();
	private List<Location> spLocs = new ArrayList<Location>();
	private List<Word> wordList = new ArrayList<Word>();
	private boolean firstMove = false;
	private boolean isValid = true;
	
	public Move(List<Tile> tiles, List<Location> locs) {
		this.tiles = tiles;
		this.locs = locs;
	}
	
	/**
	 * Class to set the move as the first move of the game.
	 */
	public void setFirstMove() {
		firstMove = true;
	}
	
	/**
	 * Class to set the move as invalid.
	 */
	public void setInvalidMove() {
		isValid = false;
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
	 * Method to place tiles on many locations of the move.
	 * @param board TODO
	 */
	public void placeTile(Board board) {
		for (int i = 0; i < locs.size(); i++) {
			board.getLocation(locs.get(i).getX(), locs.get(i).getY()).placeTile(tiles.get(i));
		}
	}
	
	/**
	 * Method to place special tiles of the move.
	 * @param board TODO
	 */
	public void placeSpecialTile(List<SpecialTile> tiles, List<Location> locs, Board board) {
		specialTiles = tiles;
		spLocs = locs;
		for (int i = 0; i < spLocs.size(); i++) {
			board.getLocation(spLocs.get(i).getX(), spLocs.get(i).getY()).placeSpecialTile(specialTiles.get(i));
		}
	}

	/**
	 * Method to return the validation of the move.
	 * @return true if the move is valid
	 */
	public boolean getIsValid() {
		return isValid;
	}
	
	/**
	 * Method to get tiles of the move.
	 * @return tiles of the move
	 */
	public List<Tile> getTiles() {
		return tiles;
	}
	
	/**
	 * Method to get special tiles of the move.
	 * @return special tiles of the move
	 */
	public List<SpecialTile> getSpecialTiles() {
		return specialTiles;
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

		if (locs.size() == 0) {
			return;
		}
		if (locs.size() == 1) {
			wordList.addAll(makeWords(board, true));
			wordList.addAll(makeWords(board, false));
			if (wordList.size() == 0) {
				word.addLetter(locs.get(0).getTile().getLetter());
				word.addBaseValue(locs.get(0).getTile().getValue());
				makeMultiplier(word, locs.get(0));
				wordList.add(word);
			}
		} else {
			int x = locs.get(0).getX();
			int y = locs.get(0).getY();
			
			if (locs.get(0).getX() == locs.get(1).getX()) {
				while (board.getLocation(x, y).isOnNormalTile()) {
					if (y == 0) {
						break;
					}
					y--;
				}
				y++;
				while (board.getLocation(x, y).isOnNormalTile()) {
					word.addBaseValue(board.getLocation(x, y).getTile().getValue());
					word.addLetter(board.getLocation(x, y).getTile().getLetter());
					word.addLocation(board.getLocation(x, y));
					makeMultiplier(word, board.getLocation(x, y));
					if (y == 14) {
						break;
					}
					y++;
				}
				wordList.add(word);
				wordList.addAll(makeWords(board, false));
			} else {
				while (board.getLocation(x, y).isOnNormalTile()) {
					if (x == 0) {
						break;
					}
					x--;
				}
				x++;
				while (board.getLocation(x, y).isOnNormalTile()) {
					word.addBaseValue(board.getLocation(x, y).getTile().getValue());
					word.addLetter(board.getLocation(x, y).getTile().getLetter());
					word.addLocation(board.getLocation(x, y));
					makeMultiplier(word, board.getLocation(x, y));
					if (x == 14) {
						break;
					}
					x++;
				}
				wordList.add(word);
				wordList.addAll(makeWords(board, true));
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
			if (pointer) {
				y++;
			} else {
				x++;
			}
			while (board.getLocation(x, y).isOnNormalTile()) {
				word.addBaseValue(board.getLocation(x, y).getTile().getValue());
				word.addLetter(board.getLocation(x, y).getTile().getLetter());
				word.addLocation(board.getLocation(x, y));
				makeMultiplier(word, board.getLocation(x, y));
				if (pointer) {
					if (y == 14) {
						break;
					}
					y++;
				} else {
					if (x == 14) {
						break;
					}
					x++;
				}
			}
			if (word.getWordLength() != 1) {
				wordList.add(word);
			}
		}
		return wordList;
	}
	
	/**
	 * Method to times multiplier to the word.
	 * @param word to be multiplied
	 * @param loc as the multiplier is
	 */
	private void makeMultiplier(Word word, Location loc) {
		if (loc.getMultiplier() != null) {
			loc.getMultiplier().updateWord(word, loc.getTile());
		}
	}
}
