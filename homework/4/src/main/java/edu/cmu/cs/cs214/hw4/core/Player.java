package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.cs.cs214.hw4.core.specialtile.SpecialTile;

/**
 * Class to generate a player of the game.
 * @author zhilinh
 *
 */
public class Player {
	
	private String name;
	private int score, maxNumTile, lastMoveScore;
	private List<Tile> inventory = new ArrayList<Tile>();
	private List<SpecialTile> spInventory = new ArrayList<SpecialTile>();
	private Move move;
	private boolean decision = false;
	private boolean skip = false;
	
	/**
	 * Constructor to generate a player with a name.
	 * @param name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.maxNumTile = 5;
	}
	
	/**
	 * Method to add tiles to the inventory of the player.
	 * @param tiles added to the inventory
	 */
	public void addTiles(List<Tile> tiles) {
		inventory.addAll(tiles);
	}
	
	/**
	 * Method to add special tiles to the player.
	 * @param sp special tiles added
	 */
	public void addSpecialTile(SpecialTile sp) {
		spInventory.add(sp);
	}
	
	/**
	 * Method to get the status of skipping. 
	 * @return the status of skipping
	 */
	public boolean getSkip() {
		return skip;
	}
	
	/**
	 * Method to get the name of the player.
	 * @return name of the player.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method to get the score of the last move of the player.
	 * @return the score of the last move
	 */
	public int getLastMoveScore() {
		return lastMoveScore;
	}
	
	/**
	 * Method to get the max number of tiles the player can take
	 * @return the maximum number of tiles
	 */
	public int getMaxNumTile() {
		return maxNumTile;
	}
	
	/**
	 * Method to get the inventory of tiles of the player.
	 * @return the inventory of tiles of the player
	 */
	public List<Tile> getTiles() {
		return inventory;
	}
	
	/**
	 * Method to get the inventory of special tiles of the player.
	 * @return the inventory of special tiles of the player
	 */
	public List<SpecialTile> getSpecialTileInventory() {
		return spInventory;
	}
	
	/**
	 * Method to get the score of the player.
	 * @return the score of the player
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Method to get the last move of the player
	 * @return the move
	 */
	public Move getMove() {
		return move;
	}
	
	/**
	 * Method to get the decision whether a player would challenge
	 * @return true if the player would challenge
	 */
	public boolean getChallenge() {
		return decision;
	}
	
	/**
	 * Method to update the score of the player
	 * @param score to be added
	 */
	public void updateScore(Integer score) {
		this.score += score;
	}
	
	/**
	 * Method to update the inventory after the move
	 * @param move that used tiles to be removed from the inventory
	 * @return the updated inventory
	 */
	public List<Tile> updateTiles(Move move) {
		inventory.removeAll(move.getTiles());
		return inventory;
	}
	
	/**
	 * Method to make a decision on whether the player would challenge
	 * @param decision made by the player
	 */
	public void makeChallenge(boolean decision) {
		this.decision = decision;
	}
	
	/**
	 * Method to indicate that the player would skip this round
	 */
	public void skipTrue() {
		skip = true;
	}
	
	/**
	 * Method to indicate that the player would keep on this round
	 */
	public void skipFalse() {
		skip = false;
	}
	
	/**
	 * Method to exchange old tiles to new tiles of the player.
	 * @param oldTiles to be exchanged
	 * @param newTiles to be added to the inventory
	 */
	public void exchangeTile(List<Tile> oldTiles, List<Tile> newTiles) {
		inventory.removeAll(oldTiles);
		inventory.addAll(newTiles);
	}
	
	/**
	 * Method to do the move and update the basic score of the player.
	 * @param board of the game
	 * @param move to be done
	 */
	public void runMove(Board board, Move move) {
		List<Word> wordList = new ArrayList<Word>();
		this.lastMoveScore = 0;
		this.move = move;
		this.updateTiles(move);
		move.placeTile(board);
		move.getWords(board, move.getLocations());
		wordList = move.getWordList();
		for (Word i : wordList) {
			this.updateScore(i.getValue());
			this.lastMoveScore += i.getValue();
		}
	}
}