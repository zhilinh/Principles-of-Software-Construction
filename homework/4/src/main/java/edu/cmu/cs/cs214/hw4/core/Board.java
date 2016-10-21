package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.cs.cs214.hw4.core.multiplier.DoubleLetter;
import edu.cmu.cs.cs214.hw4.core.multiplier.DoubleWord;
import edu.cmu.cs.cs214.hw4.core.multiplier.TripleLetter;
import edu.cmu.cs.cs214.hw4.core.multiplier.TripleWord;

/**
 * Class to build the board for the game.
 * @author zhilinh
 *
 */
public class Board {
	
	private final Location star = new Location(7, 7);
	private Location[][] locs;
	
	/**
	 * Constructor to build the board with multipliers.
	 */
	public Board() {
		locs = new Location[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				locs[i][j] = new Location(i, j);
				if ((i == j) || (i == 14 - j)) {
					if (i == 0 || i == 14) {
						locs[i][j].setMultiplier(new TripleWord());
					} else if (i < 5 || i > 9) {
						locs[i][j].setMultiplier(new DoubleWord());
					} else if (i == 5 || i == 9) {
						locs[i][j].setMultiplier(new TripleLetter());
					} else {
						locs[i][j].setMultiplier(new DoubleLetter());
					}
				}
			}
		}

		locs[0][3].setMultiplier(new DoubleLetter());
		locs[0][7].setMultiplier(new TripleWord());
		locs[0][11].setMultiplier(new DoubleLetter());

		locs[1][5].setMultiplier(new TripleLetter());
		locs[1][9].setMultiplier(new TripleLetter());

		locs[2][6].setMultiplier(new DoubleLetter());
		locs[2][8].setMultiplier(new DoubleLetter());

		locs[3][0].setMultiplier(new DoubleLetter());
		locs[3][7].setMultiplier(new DoubleLetter());
		locs[3][14].setMultiplier(new DoubleLetter());

		locs[5][1].setMultiplier(new TripleLetter());
		locs[5][13].setMultiplier(new TripleLetter());

		locs[6][2].setMultiplier(new DoubleLetter());
		locs[6][12].setMultiplier(new DoubleLetter());

		locs[7][0].setMultiplier(new TripleWord());
		locs[7][3].setMultiplier(new DoubleLetter());
		locs[7][11].setMultiplier(new DoubleLetter());
		locs[7][14].setMultiplier(new TripleWord());

		locs[8][2].setMultiplier(new DoubleLetter());
		locs[8][12].setMultiplier(new DoubleLetter());

		locs[9][1].setMultiplier(new TripleLetter());
		locs[9][13].setMultiplier(new TripleLetter());

		locs[11][0].setMultiplier(new DoubleLetter());
		locs[11][7].setMultiplier(new DoubleLetter());
		locs[11][14].setMultiplier(new DoubleLetter());

		locs[12][6].setMultiplier(new DoubleLetter());
		locs[12][8].setMultiplier(new DoubleLetter());

		locs[13][5].setMultiplier(new TripleLetter());
		locs[13][9].setMultiplier(new TripleLetter());

		locs[14][3].setMultiplier(new DoubleLetter());
		locs[14][7].setMultiplier(new TripleWord());
		locs[14][11].setMultiplier(new DoubleLetter());
	}
	
	/**
	 * Method to find if the first move is on the star.
	 * @param move the first move 
	 * @return true if the first move placed a tile on the star
	 */
	public boolean isOnStar(Move move) {
		if ((move.getStartLocation().getX() == star.getX()) && (move.getStartLocation().getY() == star.getY())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to find if the move placed tiles adjacent to existed tiles.
	 * @param move to be checked
	 * @return true if the move is valid
	 */
	public boolean isAdjacent(Move move) {
		if (move.getLocations().isEmpty()) {
			return true;
		}
		for (Location i : move.getLocations()) {
			if (locs[i.getX() - 1][i.getY()].isOnNormalTile()) {
				return true;
			}
			if (locs[i.getX() + 1][i.getY()].isOnNormalTile()) {
				return true;
			}
			if (locs[i.getX()][i.getY() - 1].isOnNormalTile()) {
				return true;
			}
			if (locs[i.getX()][i.getY() + 1].isOnNormalTile()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to check if the move placed tiles in a straight line.
	 * @param move to be checked
	 * @return true if 
	 */
	public boolean checkInLine(Move move) {
		if (move.getTileNumber() == 1 || move.getTileNumber() == 0) {
			return true;
		} else {
			if (move.getLocations().get(1).getX() == move.getLocations().get(0).getX()) {
				int max = move.getLocations().get(0).getY();
				int min = move.getLocations().get(0).getY();
				List<Integer> yList = new ArrayList<Integer>();
				for (int i = 1; i < move.getTileNumber(); i++) {
					if (! (move.getLocations().get(i).getX() == move.getLocations().get(0).getX())) {
						return false;
					}
					this.makeComparison(move.getLocations().get(i).getY(), max, min);
					yList.add(move.getLocations().get(i).getY());
				}
				for (int i = min; i < max; i++) {
					if (! locs[move.getLocations().get(i).getX()][i].isOnNormalTile()) {
						if (! yList.contains(i)) {
							return false;
						}
					}
				}
				
			} else if (move.getLocations().get(1).getY() == move.getLocations().get(0).getY()) {
				int max = move.getLocations().get(0).getX();
				int min = move.getLocations().get(0).getX();
				List<Integer> xList = new ArrayList<Integer>();
				for (int i = 1; i < move.getTileNumber(); i++) {
					if (! (move.getLocations().get(i).getY() == move.getLocations().get(0).getY())) {
						return false;
					}
					this.makeComparison(move.getLocations().get(i).getX(), max, min);
					xList.add(move.getLocations().get(i).getX());
				}
				for (int i = min; i < max; i++) {
					if (! locs[i][move.getLocations().get(i).getY()].isOnNormalTile()) {
						if (! xList.contains(i)) {
							return false;
						}
					}
				}				
			} else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method to compare the index to find the maximum and minimum.
	 * @param i the index
	 * @param max maximum index
	 * @param min minimum index
	 */
	private void makeComparison(Integer i, Integer max, Integer min) {
		if (i > max) {
			max = i;
		}
		if (i < min) {
			min = i;
		}
	}
	
	/**
	 * Method to get the location with index x and y.
	 * @param x index x
	 * @param y index y
	 * @return location with index x and y on board
	 */
	public Location getLocation(int x, int y) {
		return locs[x][y];
	}
}