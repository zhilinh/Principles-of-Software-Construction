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
	private List<Player> winner = new ArrayList<Player>();
	private Player currentPlayer;
	private TileLog tileLog = new TileLog();
	private Board board = new Board();
	private Dictionary dic;
	private int playerNum = 0;
	private int counterNum = 1;
	private int playerMaxNum;
	
	/**
	 * Main method to start the game and introduce players. 
	 * @param args players' names
	 */
	public static void main(String[] args) {
		Scrabble scrabble = new Scrabble(args);
		scrabble.startGame();
	}
	
	/**
	 * Constructor to generate players.
	 * @param args players' names
	 */
	public Scrabble(String[] args) {
		playerMaxNum = args.length - 1;
		for (String i : args) {
			this.addPlayer(i);
		}
	}
	
	/**
	 * Method to start the game.
	 */
	public void startGame() {
		
	}
	
	/**
	 * Method to end the game.
	 */
	public void endGame() {
		System.out.println(winner);
	}
	
	/**
	 * Method to run the game, decide if the game ends and find the winner.
	 */
	public void runGame() {
		int num;
		while (! (this.doesPlayerStop() || this.doesGameStop())) {
			num = currentPlayer.getMaxNumTile() - currentPlayer.getTiles().size();
			this.giveTiles(num, currentPlayer);
			
			if (currentPlayer.getSkip()) {
				currentPlayer.skipFalse();
			} else {
				makeMove();
			}
			currentPlayer = this.getNextPlayer();
			}
		
		int maxScore = 0;
		List<Player> winner = new ArrayList<Player>();
		for (Player i : players) {
			if (i.getScore() > maxScore) {
				maxScore = i.getScore();
				winner = new ArrayList<Player>();
			} else if (i.getScore() == maxScore) {
				winner.add(i);
			}
		this.winner = winner;
		this.endGame();
		}
	}
	
	/**
	 * Method to introduce the move to players, challenge it and update scores.
	 */
	public void makeMove() {
		List<Tile> tiles = new ArrayList<Tile>();
		List<Location> locs = new ArrayList<Location>();
		Move move = new Move(tiles, locs);
		
		if (checkMoveValidation(move)) {
			currentPlayer.runMove(board, move);
			move.placeTile();
			move.placeSpecialTile();			
			
			List<Player> challenger = getChallenger();
			boolean challengeResult = false;
			if (! challenger.isEmpty()) {
				challengeResult = challengeCurrentPlayer();
				if (challengeResult) {
					System.out.println("Challenge Successed!");
					for (Player i : challenger) {
						i.updateScore(10);
						move.removeTile();
					currentPlayer.updateScore(-currentPlayer.getLastMoveScore());
					}
				} else {
					System.out.println("Challenge Failed");
					for (Player i : challenger) {
						i.skipTrue();
					}
				}
			}
			if (! challengeResult) {
				for (Location loc : move.getLocations()) {
					if (loc.isOnSpecialTile()) {
						loc.getSpecialTile().activateSp(this, loc);
					}
				}
			}
		} else {
			System.out.println("Invalid Move!");
			makeMove();
		}
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
	 * Method to return a list of players.
	 * @return a list of players
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Method to return the board
	 * @return the board of Scrabble Game.
	 */
	public Board getBoard() {
		return board;
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
	public Player getNextPlayer() {
		if ((playerNum == playerMaxNum) && (counterNum == 1)) {
			playerNum = 0;
			return players.get(0);
		} else if ((playerNum == 0) && (counterNum == -1)) {
			return players.get(playerMaxNum);
		} else {
			return players.get(playerNum + counterNum);
		}		
	}
	
	/**
	 * Method to return the number of players.
	 * @return the number of players
	 */
	public int getPlayerNum() {
		return playerNum;
	}

	/**
	 * Method to return the winner of the game.
	 * @return the winner of the game
	 */
	public List<Player> getWinner() {
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
	 * Method to find if any player wants to end the game.
	 * @return true if someone wants to stop and vice versa
	 */
	public boolean doesPlayerStop() {
		return false;
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
	public boolean checkMoveValidation(Move move) {
		
		for (Tile i : move.getTiles()) {
			if (! players.get(playerNum).getTiles().contains(i)) {
				return false;
			}
		}
		
		if (move.isFirstMove() && (board.isOnStar(move))) {
			return false;
		}
		
		if (! board.isAdjacent(move)) {
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
	public boolean challengeCurrentPlayer() {
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
