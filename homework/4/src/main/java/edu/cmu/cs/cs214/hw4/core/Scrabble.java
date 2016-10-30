package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate and control the Scrabble Game.
 * @author zhilinh
 *
 */
public class Scrabble {
	
	private List<Player> players = new ArrayList<Player>();
	private List<Location> boomArea = new ArrayList<Location>();
	private Player currentPlayer;
	private TileLog tileLog = new TileLog();
	private Board board = new Board();
	private Dictionary dic = new Dictionary("src/main/resources/words.txt");
	private int playerNum = 0;
	private int counterNum = 1;
	private int playerMaxNum;
	private boolean hasFirstMove = true;
	private boolean challengeResult;
	private String activatedSp = "";
	
	/**
	 * 
	 */
	public void startGame() {
		playerMaxNum = players.size() - 1;
		currentPlayer = players.get(0);
		for (Player i : players) {
			this.giveTiles(i.getMaxNumTile(), i);
		}
	}
	
	/**
	 * Method to run the game, decide if the game ends and find the winner.
	 */
	public void runGame(Move move) {
		
		activatedSp = "";
		if (currentPlayer.getSkip()) {
			currentPlayer.skipFalse();
		} else {
			if (hasFirstMove) {
				move.setFirstMove();
				hasFirstMove = false;
			}
			if (! checkMoveValidation(move)) {
				if (move.isFirstMove()) {
					hasFirstMove = true;
				}
			move.setInvalidMove();
			}	
		}
	}
	
	/**
	 * Method to introduce the move to players, challenge it and update scores.
	 */
	public void makeMove(Move move) {
		challengeResult = false;
		currentPlayer.runMove(board, move);
		List<Player> challenger = getChallenger();
		boomArea = new ArrayList<Location>();
		if (! challenger.isEmpty()) {
			challengeResult = challengeCurrentPlayer();
			if (challengeResult) {
				for (Player i : challenger) {
					if (move.isFirstMove()) {
						hasFirstMove = true;
					}
					i.updateScore(10);
					move.removeTile();
					currentPlayer.updateScore(-currentPlayer.getLastMoveScore());
				}
			} else {
				for (Player i : challenger) {
					i.skipTrue();
				}
			}
		}
		exchangeTiles(move.getTiles(), currentPlayer);
		if (! challengeResult) {
			for (Location loc : move.getLocations()) {
				if (loc.isOnSpecialTile()) {
					activatedSp = loc.getSpecialTile().activateSp(this, loc);
					loc.removeSpecialTile();
				}
			}
		}
	}
	
	/**
	 * Method to add an exploded location to update the GUI.
	 * @param loc exploded due to the Boom special tile
	 */
	public void addBoomArea(Location loc) {
		boomArea.add(loc);
	}
	
	/**
	 * Method to reverse the play order.
	 */
	public void reverseCounterNum() {
		counterNum = -counterNum;
	}
	
	/**
	 * Method to add players by names.
	 * @param name player's name
	 */
	public void addPlayer(String name) {
		players.add(new Player(name));
	}
	
	/**
	 * Method to get whether a special tile is activated this turn.
	 * @return message from special tiles
	 */
	public String getActivatedSp() {
		return activatedSp;
	}
	
	/**
	 * Method to return a list of players.
	 * @return a list of players
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Method to return the result of the challenge.
	 * @return true if challenge successfully
	 */
	public boolean getChallengeResult() {
		return challengeResult;
	}
	
	/**
	 * Method to return the board.
	 * @return the board of Scrabble Game
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * Method to return the exploded location to update the GUI.
	 * @return a list of exploded location
	 */
	public List<Location> getBoomArea() {
		return boomArea;
	}
	
	/**
	 * Method to return the current player.
	 * @return the current player
	 */
	public Player getCurrentPlayer() {
		return players.get(playerNum);
	}
	
	/**
	 * Method to move to the next player in order.
	 * @return the next player to move
	 */
	public void getNextPlayer() {
		if ((playerNum == playerMaxNum) && (counterNum == 1)) {
			playerNum = 0;
			currentPlayer = players.get(0);
		} else if ((playerNum == 0) && (counterNum == -1)) {
			playerNum = playerMaxNum;
			currentPlayer = players.get(playerMaxNum);
		} else {
			playerNum += counterNum;
			currentPlayer = players.get(playerNum);
		}
		if (currentPlayer.getSkip()) {
			currentPlayer.skipFalse();
			getNextPlayer();
		}
	}
	
	/**
	 * Method to return the index of the current player.
	 * @return the number of the current players
	 */
	public int getPlayerNum() {
		return playerNum;
	}

	/**
	 * Method to return the winner of the game.
	 * @return the winner of the game
	 */
	public List<Player> getWinner() {
		int maxScore = 0;
		List<Player> winner = new ArrayList<Player>();
		for (Player i : players) {
			if (i.getScore() > maxScore) {
				maxScore = i.getScore();
				winner = new ArrayList<Player>();
				winner.add(i);
			} else if (i.getScore() == maxScore) {
				winner.add(i);
			}
		}
		return winner;		
	}
	
	/**
	 * Method to return one player's score.
	 * @param player whose score is returned
	 * @return the score of the player
	 */
	public int getScore(Player player) {
		return player.getScore();		
	}
	
	/**
	 * Method to return the last move of one player.
	 * @param player whose last move is returned
	 * @return the last move of the player
	 */
	public Move getLastMove(Player player) {
		return player.getMove();		
	}
	
	/**
	 * Method to return a list of players who want to challenge the current player.
	 * @return a list of challengers
	 */
	public List<Player> getChallenger() {
		List<Player> challenger = new ArrayList<Player>();
		
		for (Player i : players) {
			if (! i.equals(this.getCurrentPlayer())) {
				if (i.getChallenge()) {
					challenger.add(i);
				}
			}
		}
		return challenger;
	}
	
	/**
	 * Method to give new tiles from Tile Log to one player.
	 * @param num the number of tiles the player needs
	 * @param player who will receive new tiles to refill the inventory
	 */
	public void giveTiles(Integer num, Player player) {
		if (tileLog.getLeftTilesNumber() < num) {
			player.addTiles(tileLog.getTiles(tileLog.getLeftTilesNumber()));
		} else {
			player.addTiles(tileLog.getTiles(num));
		}
	}
	
	/**
	 * Method to change tiles from one player's inventory to get some new tiles.
	 * @param tiles to be exchanged from the player's inventory
	 * @param player who wants to change tiles
	 */
	public void exchangeTiles(List<Tile> tiles, Player player) {
		if (tileLog.getLeftTilesNumber() < tiles.size()) {
			System.out.println("Not enough tiles left.");
		} else {
			player.exchangeTile(tiles, tileLog.getTiles(tiles.size()));
		}
	}
	
	/**
	 * Method to find if the game should stop because the Tile Log runs out of tiles.
	 * @return true if the Tile Log has no tile left and vice versa
	 */
	public boolean doesGameStop() {
		if (tileLog.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check if a new move is valid based on rules.
	 * @param move to be checked validation
	 * @return true if the move is valid and vice versa
	 */
	private boolean checkMoveValidation(Move move) {
		
		if (((move.getTiles().size() == 0) && (move.getSpecialTiles().size() == 0))) {
			return false;
		}
		
		for (Tile i : move.getTiles()) {
			if (! players.get(playerNum).getTiles().contains(i)) {
				return false;
			}
		}
		
		if (move.isFirstMove()){
			if (! board.isOnStar(move)) {
				return false;
			}
		} else if (! board.isAdjacent(move)) {
			return false;
		}
		
		if (! board.checkInLine(move)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Method to check if words made by the move of current player are validated
	 * according to the dictionary.
	 * @return true if the dictionary contains all words made by the move and false if one word is invalid
	 */
	private boolean challengeCurrentPlayer() {
		Move move = currentPlayer.getMove();
		String word;
		for (Word i : move.getWordList()) {
			word = i.getWord();
			if (! dic.validateWord(word)) {
				return false;
			}
		}
		return true;
	}
}
