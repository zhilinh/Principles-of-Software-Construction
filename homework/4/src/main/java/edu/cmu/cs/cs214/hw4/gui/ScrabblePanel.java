package edu.cmu.cs.cs214.hw4.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.cmu.cs.cs214.hw4.core.Move;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Scrabble;
import edu.cmu.cs.cs214.hw4.core.Tile;
import edu.cmu.cs.cs214.hw4.core.specialtile.Shop;
import edu.cmu.cs.cs214.hw4.core.specialtile.SpecialTile;
import edu.cmu.cs.cs214.hw4.core.Location;

/**
 * Class to set up the whole board GUI of Scrabble Game.
 * @author zhilinh
 *
 */
public class ScrabblePanel extends JPanel implements GameChangeListener{
	
	private static final int BOARD_SIZE = 15;
	private static final int PLAYER_MAX_TILE_NUMBER = 7;
	private static final int PLAYER_MAX_SPTILE_NUMBER = 5;
	
	private Scrabble scrabble;
	private List<Player> players;
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<SpecialTile> spTiles = new ArrayList<SpecialTile>();
	private List<Location> locs = new ArrayList<Location>();
	private List<Location> spLocs = new ArrayList<Location>();
	private List<Location> allLocs = new ArrayList<Location>();
	private List<Tile> exchangedTiles;
	private Hashtable<String, Color> color = new Hashtable<String, Color>();
	private Hashtable<String, Integer> price = new Hashtable<String, Integer>();
	private Hashtable<String, String> name = new Hashtable<String, String>();
	private boolean isSelectedButtonSpecial = false;
	
	private BoardButton[][] grids;
	private JButton[] tileGrids, spTileGrids, shopGrids;
	private JButton[] confirmButtonList, cancelButtonList;
	private JLabel[] playerNames, playerScores;
	
	private JButton selectedButton;
	private JButton exchangeButton;
	
	private JPanel tilePanel, spTilePanel;
	private JPanel boardPanel, downPanel, rightPanel;
	private JPanel shopPanel, playerInfoPanel, commandPanel;
	private JLabel gameMessageLabel;
	
	/**
	 * Constructor to set and initialize all panels and attributes.
	 * @param scrabble the game this GUI builds for
	 */
	public ScrabblePanel(Scrabble scrabble) {
		
		//set up the frame, game and players
		setPreferredSize(new Dimension(1100, 825));
		this.scrabble = scrabble;
		players = scrabble.getPlayers();
		
		//grids for tiles and special tiles on board
		grids = new BoardButton[BOARD_SIZE][BOARD_SIZE];
		tileGrids = new JButton[PLAYER_MAX_TILE_NUMBER];
		spTileGrids = new JButton[PLAYER_MAX_SPTILE_NUMBER];
		
		//player's info
		playerNames = new JLabel[players.size()];
		playerScores = new JLabel[players.size()];

		//three main panels
		boardPanel = new JPanel();
		downPanel = new JPanel();
		rightPanel = new JPanel();
		
		//sub-panels
		selectedButton = new JButton();
		tilePanel = new JPanel();
		spTilePanel = new JPanel();
		playerInfoPanel = new JPanel();
		commandPanel = new JPanel();
		shopPanel = new JPanel();
		gameMessageLabel = new JLabel("Welcome!");
		
		//colors for multipliers
		color.put("2L", Color.MAGENTA);
		color.put("2W", Color.YELLOW);
		color.put("3L", Color.GREEN);
		color.put("3W", Color.RED);
		name.put("Boom", "B");
		name.put("Negative", "N");
		name.put("Reverse", "R");
		name.put("T.Steal", "S");
		name.put("R.Down", "D");
		
		//set border of the panel
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//initialize three main panels
		initBoardPanel();
		initRightPanel();
		initDownPanel();
		add(boardPanel, BorderLayout.WEST);
		add(downPanel, BorderLayout.SOUTH);
		add(rightPanel, BorderLayout.EAST);
		
		updateInventory();
		updateSpecialTile();
	}
	
	/**
	 * Method to initialize the south panel.
	 */
	private void initDownPanel() {
		
		downPanel.add(tilePanel);
		downPanel.add(spTilePanel);
		
		initPanel(tilePanel, "Inventory", PLAYER_MAX_TILE_NUMBER, 50);
		initPanel(spTilePanel, "Special Tiles", PLAYER_MAX_SPTILE_NUMBER, 50);
	}
	
	/**
	 * Method to initialize the east panel.
	 */
	private void initRightPanel() {
		
		rightPanel.setLayout(new GridLayout(4, 1));
		rightPanel.add(shopPanel);
		rightPanel.add(playerInfoPanel);
		rightPanel.add(commandPanel);
		rightPanel.add(gameMessageLabel);
		
		initShopPanel();
		initPlayerInfoPanel();
		initCommandPanel();
	}

	/**
	 * Method to implement three functions of the command button in different situations.
	 */
	private void initConfirmButton() {
		
		JButton confirmButton;
		confirmButtonList = new JButton[2];
		
		confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(e -> {

			Move move = new Move(tiles, locs);
			move.placeSpecialTile(spTiles, spLocs, scrabble.getBoard());			
			scrabble.runGame(move);
			if (move.getIsValid()) {
				challengeMode(move);
				scrabble.makeMove(move);
				if (scrabble.getChallengeResult()) {
					recoverBoard(locs);
					updateGameMesg("Successful challenge! 10 points bonus!");
				} else if (! scrabble.getChallenger().isEmpty()){
					updateGameMesg("Challenge failed! Turn skiped penalty!");
				} else {
					updateGameMesg("Move Confirmed! Next player!");
				}
				scrabble.getNextPlayer();
				updatePlayerInfoPanel();
				setSpecialTileVisible();
			} else {
				updateGameMesg("Invalid Move! Plz try again!");
				recoverBoard(locs);
			}
			for (Location i : spLocs) {
				grids[i.getX()][i.getY()].setUnoccupied();
			}
			if (scrabble.getBoomArea().size() != 0) {
				recoverBoard(scrabble.getBoomArea());
			}
			
			if (scrabble.getActivatedSp() != "") {
				updateGameMesg(scrabble.getActivatedSp());
			}
			updateInventory();
			updateSpecialTile();
			tiles = new ArrayList<Tile>();
			locs = new ArrayList<Location>();
			spTiles = new ArrayList<SpecialTile>();
			spLocs = new ArrayList<Location>();
			
			if (scrabble.doesGameStop()) {
				Object[] options = { "OK" };
				int choice = JOptionPane.showOptionDialog(null, "Winner: ",
						"Game Over!", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (choice == JOptionPane.OK_OPTION) {
					this.setVisible(false);
				}
			}			
        });
		confirmButtonList[0] = confirmButton;
		
		confirmButton = new JButton("Exchange Confirm");
		confirmButton.addActionListener(e -> {
			if (exchangedTiles.size() != 0) {
				scrabble.exchangeTiles(exchangedTiles, scrabble.getCurrentPlayer());
				recoverPanel(true);
			} else {
				updateGameMesg("Plz choose tiles to exchange!");
			}
		});
		confirmButtonList[1] = confirmButton;
	}
	
	/**
	 * Method to implement three functions of the cancel button in different situations.
	 */
	private void initCancelButton() {
		
		JButton cancelButton;
		cancelButtonList = new JButton[2];
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e -> {
			recoverBoard(locs);
			recoverBoard(spLocs);
			updateInventory();
			updateSpecialTile();
			for (Location i : spLocs) {
				allLocs.remove(i);
			}
			tiles = new ArrayList<Tile>();
			locs = new ArrayList<Location>();
			spTiles = new ArrayList<SpecialTile>();
			spLocs = new ArrayList<Location>();
		});
		cancelButtonList[0] = cancelButton;
		
		cancelButton = new JButton("Exchange Cancel");
		cancelButton.addActionListener(e -> {
			recoverPanel(false);
		});
		cancelButtonList[1] = cancelButton;
	}
	
	/**
	 * Method to initialize the command panel with four command buttons.
	 */
	private void initCommandPanel() {
		
		commandPanel.setLayout(new GridLayout(3, 1));
		initConfirmButton();
		initCancelButton();
		
		exchangeButton = new JButton("Exchange");
		exchangeButton.addActionListener(e -> {
			for (JButton i : spTileGrids) {
				i.setEnabled(false);
			}
			for (JButton i : shopGrids) {
				i.setEnabled(false);
			}
			exchangeButton.setEnabled(false);
			commandPanel.remove(confirmButtonList[0]);
			commandPanel.add(confirmButtonList[1], 1);
			commandPanel.remove(cancelButtonList[0]);
			commandPanel.add(cancelButtonList[1], 2);
			exchangeTile();
			updateUI();
        });
		
		commandPanel.add(exchangeButton);
		commandPanel.add(confirmButtonList[0]);
		commandPanel.add(cancelButtonList[0]);
	}
	
	/**
	 * Method to initialize the tile and special tile panels.
	 * @param panel to be initialized
	 * @param label to be the title of the panel
	 * @param num of how many tiles to set
	 * @param buttonSize of each button
	 */
	private void initPanel(JPanel panel, String label, int num, int buttonSize) {
		
		JLabel inventoryTitle = new JLabel(label);
		panel.add(inventoryTitle);
		
		JPanel tiles = new JPanel();
		for (int i = 0; i < num; i++) {
			JButton buttons = new JButton();					
			buttons.setPreferredSize(new Dimension(buttonSize, buttonSize));
			buttons.addActionListener(e -> {
				Object source = e.getSource();
				if (source instanceof JButton) {
					if (! ((JButton)source).equals(selectedButton)) {
						((JButton)source).setBackground(Color.CYAN);
						selectedButton.setBackground(null);
						selectedButton = (JButton) source;
						findSelectedButton();
					}
				}
			});
			if (label.equals("Inventory")) {
				tileGrids[i] = buttons;
				tiles.add(tileGrids[i]);
			} else {
				spTileGrids[i] = buttons;
				tiles.add(spTileGrids[i]);
			}	
		}
		panel.add(tiles);
   	}
	
	/**
	 * Method to initialize the shop panel with four types of special tiles selling.
	 */
	private void initShopPanel() {
		
		String[] names = {"Boom", "Negative", "Reverse", "T.Steal", "R.Down"};
		price.put("Boom", 15);
		price.put("Negative", 20);
		price.put("Reverse", 10);
		price.put("T.Steal", 25);
		price.put("R.Down", 15);
		Shop shop = new Shop();
		shopGrids = new JButton[PLAYER_MAX_SPTILE_NUMBER];
		JLabel inventoryTitle = new JLabel("Shop");
		shopPanel.add(inventoryTitle);
		
		JPanel tiles = new JPanel();
		tiles.setLayout(new GridLayout(3, 2));
		for (int i = 0; i < PLAYER_MAX_SPTILE_NUMBER; i++) {
			JButton buttons = new JButton(names[i]);
			shopGrids[i] = buttons;
			buttons.setPreferredSize(new Dimension(90, 59));
			buttons.addActionListener(e -> {
				Object source = e.getSource();
				String text = ((JButton)source).getText();
				updateGameMesg(text + ": " + price.get(text).toString());
				Object[] options = { "Yes", "No" };
				int choice = JOptionPane.showOptionDialog(null, "Are you sure you are going to buy "
						+ text + " ? You cannot withdraw it if clicked yes.", "Confirm",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, options, options[0]);
				if (choice == JOptionPane.YES_OPTION) {
					if (scrabble.getCurrentPlayer().getSpecialTiles().size() < PLAYER_MAX_SPTILE_NUMBER) {
						if (shop.buySpecialTile(text, scrabble.getCurrentPlayer())) {
							spTileGrids[scrabble.getCurrentPlayer().getSpecialTiles().size() - 1].setText(name.get(text));
							updatePlayerInfoPanel();
						} else {
							updateGameMesg("Not enough score to buy it!");
						}
					} else {
						updateGameMesg("Your special tile inventory is full!");
					}
				}
			});
			tiles.add(buttons);
		}
		shopPanel.add(tiles);
	}
	
	/**
	 * Method to initialize the player information panel with players' names and scores.
	 * Also it can show which player is now playing.
	 */
	private void initPlayerInfoPanel() {
		
		playerInfoPanel.setLayout(new GridLayout(players.size(), 1));		
		for (int i = 0; i < players.size(); i++) {
			JPanel playerInfo = new JPanel(new GridLayout(2, 1));
			playerInfo.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
			playerNames[i] = new JLabel("Player: " + players.get(i).getName());
			playerScores[i] = new JLabel("Score: " + players.get(i).getScore());
			playerInfo.add(playerNames[i]);
			playerInfo.add(playerScores[i]);
			if (players.get(i).equals(scrabble.getCurrentPlayer())) {
				playerInfo.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
			}
			playerInfoPanel.add(playerInfo);
		}
	}
	
	/**
	 * Method to initialize the main board for the scrabble game.
	 */
	private void initBoardPanel() {
		
		boardPanel.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
		boardPanel.setPreferredSize(new Dimension(800, 800));
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				BoardButton buttons = new BoardButton(i, j);
				buttons.setBackground(Color.LIGHT_GRAY);
				if (scrabble.getBoard().getLocation(i, j).getMultiplier() != null) {
					String name = scrabble.getBoard().getLocation(i, j).getMultiplier().getName();
					buttons.setText(name);
					buttons.setBackground(color.get(name));
				}
				buttons.addActionListener(e -> {
					Object source = e.getSource();
					if ((source instanceof BoardButton)
							&& (selectedButton.getText() != "")
							&& (!((BoardButton) source).getOccupied())) {
						((BoardButton) source).setText(selectedButton.getText());
						Location loc = scrabble.getBoard().getLocation(((BoardButton) source).getXloc(),
								((BoardButton) source).getYloc());
						if (! isSelectedButtonSpecial) {
							((BoardButton) source).setBackground(Color.CYAN);
							locs.add(loc);
						} else {
							((BoardButton) source).setBackground(Color.WHITE);
							spLocs.add(loc);
							allLocs.add(loc);
						}
						((BoardButton) source).setOccupied();
						selectedButton.setBackground(null);
						updateBoard();
						selectedButton = new JButton();
					}
				});
				grids[i][j] = buttons;
				boardPanel.add(grids[i][j]);
			}
		}
	}
	
	/**
	 * Method to recover the panel from exchange mode and to decide if move to the next player.
	 * @param next true if exchange confirmed
	 */
	private void recoverPanel(boolean next) {
		for (JButton i : spTileGrids) {
			i.setEnabled(true);
		}
		for (JButton i : shopGrids) {
			i.setEnabled(true);
		}
		exchangeButton.setEnabled(true);
		commandPanel.remove(confirmButtonList[1]);
		commandPanel.add(confirmButtonList[0], 1);
		commandPanel.remove(cancelButtonList[1]);
		commandPanel.add(cancelButtonList[0], 2);
		downPanel.remove(tilePanel);
		tilePanel = new JPanel();
		initPanel(tilePanel, "Inventory", PLAYER_MAX_TILE_NUMBER, 50);
		downPanel.add(tilePanel, 0);
		if (next) {
			scrabble.getNextPlayer();
			updateGameMesg("Exchange Confirmed! Next player!");
			updatePlayerInfoPanel();
		}
		updateInventory();
		updateUI();
	}

	/**
	 * Method to recover the game status when players cancel the move or it is invalid.
	 */
	private void recoverBoard(List<Location> locs) {
		for (Location i : locs) {
			grids[i.getX()][i.getY()].setBackground(Color.LIGHT_GRAY);
			grids[i.getX()][i.getY()].setText("");
			grids[i.getX()][i.getY()].setUnoccupied();
			if (i.getMultiplier() != null) {
				String name = i.getMultiplier().getName();
				grids[i.getX()][i.getY()].setText(name);
				grids[i.getX()][i.getY()].setBackground(color.get(name));
			}
		}
	}
	
	/**
	 * Method to find which tile is selected and update the game message panel to show the value.
	 */
	private void findSelectedButton() {
		List<Tile> tiles = new ArrayList<Tile>(scrabble.getCurrentPlayer().getTiles());
		for (int i = 0; i < scrabble.getCurrentPlayer().getTiles().size(); i++) {
			if (tileGrids[i].equals(selectedButton) && (selectedButton.getText() != "")) {
				isSelectedButtonSpecial = false;
				String point;
				if (tiles.get(i).getValue() == 1) {
					point = " point";
				} else {
					point = " points";
				}
			updateGameMesg(Character.toString(tiles.get(i).getLetter()) + ": "
				+ Integer.toString(tiles.get(i).getValue()) + point);						
			}
		}
		for (int i = 0; i < scrabble.getCurrentPlayer().getSpecialTiles().size(); i++) {
			if (spTileGrids[i].equals(selectedButton) && (selectedButton.getText() != "")) {
				isSelectedButtonSpecial = true;
			}
		}
	}
	
	/**
	 * Method to change the tile buttons and exchange them for players.
	 */
	private void exchangeTile() {
		exchangedTiles = new ArrayList<Tile>();
		for (int i = 0; i < scrabble.getCurrentPlayer().getTiles().size(); i++) {
			BoardButton buttons = new BoardButton(0, i);
			buttons.setPreferredSize(new Dimension(50, 50));
			buttons.setText(tileGrids[i].getText());
			buttons.addActionListener(e -> {
				Object source = e.getSource();
				if ((source instanceof BoardButton) &&
						(! ((BoardButton)source).getOccupied())){
					((BoardButton)source).setBackground(Color.CYAN);
					((BoardButton)source).setOccupied();
					int y = ((BoardButton)source).getYloc();
					exchangedTiles.add(scrabble.getCurrentPlayer().getTiles().get(y));
				}				
			});
			((JPanel)((JPanel)downPanel.getComponent(0)).getComponent(1)).remove(i);
			((JPanel)((JPanel)downPanel.getComponent(0)).getComponent(1)).add(buttons, i);
		}
	}
	
	/**
	 * Method to set the visibility of special tiles which depends on the current player.
	 */
	private void setSpecialTileVisible() {
		List<Location> removedList = new ArrayList<Location>();
		for (Location i : allLocs) {
			if (i.getSpecialTile() != null) {
				if (scrabble.getCurrentPlayer().equals(i.getSpecialTile().getOwner())) {
					grids[i.getX()][i.getY()].setBackground(Color.WHITE);
					grids[i.getX()][i.getY()].setOccupied();
					grids[i.getX()][i.getY()].setText(name.get(i.getSpecialTile().getName()));
				} else {
					grids[i.getX()][i.getY()].setBackground(Color.LIGHT_GRAY);
					grids[i.getX()][i.getY()].setText("");
					grids[i.getX()][i.getY()].setUnoccupied();
					if (i.getMultiplier() != null) {
						String name = i.getMultiplier().getName();
						grids[i.getX()][i.getY()].setText(name);
						grids[i.getX()][i.getY()].setBackground(color.get(name));
					}
				}
			} else {
				removedList.add(i);
			}
		}
		allLocs.removeAll(removedList);
	}
	
	/**
	 * Method to ask every player whether challenges or not.
	 * @param move if no tile placed then make no challenge
	 */
	public void challengeMode(Move move) {
		
		if (move.getTiles().isEmpty()) {
			for (Player i : scrabble.getPlayers()) {
				i.makeChallenge(false);
			}
		} else {
			for (Player i : scrabble.getPlayers()) {
				if (! scrabble.getCurrentPlayer().equals(i)) {
					Object[] options = { "Yes", "No" };
					int choice = JOptionPane.showOptionDialog(null, i.getName() + ", would you want to "
					+ "challenge the move of the last player ?", "Challenge", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					if (choice == JOptionPane.YES_OPTION) {
						i.makeChallenge(true);
					} else {
						i.makeChallenge(false);
					}
				}
			}
		}
	}
	
	/**
	 * Method to update the tiles every player has on the tile panel when a move is
	 * canceled or it comes a new turn for a player.
	 */
	@Override
	public void updateInventory() {		
		List<Tile> tiles = scrabble.getCurrentPlayer().getTiles();
		for (int i = 0; i < PLAYER_MAX_TILE_NUMBER; i++) {
			tileGrids[i].setText("");
		}
		for (int i = 0; i < tiles.size(); i++) {
			tileGrids[i].setText(Character.toString(tiles.get(i).getLetter()));
		}
	}
	
	/**
	 * Method to update the special tile inventory panel.
	 */
	@Override
	public void updateSpecialTile() {
		
		List<SpecialTile> spTiles = scrabble.getCurrentPlayer().getSpecialTiles();
		for (int i = 0; i < PLAYER_MAX_SPTILE_NUMBER; i++) {
			spTileGrids[i].setText("");
		}
		
		for (int i = 0; i < spTiles.size(); i++) {
			spTileGrids[i].setText(name.get(spTiles.get(i).getName()));
		}
	}

	/**
	 * Method to update the tiles of the move in this turn.
	 */
	@Override
	public void updateBoard() {
		selectedButton.setText("");
		for (int i = 0; i < scrabble.getCurrentPlayer().getTiles().size(); i++) {
			if (tileGrids[i].equals(selectedButton)) {
				tiles.add(scrabble.getCurrentPlayer().getTiles().get(i));
			}
		}
		for (int i = 0; i < scrabble.getCurrentPlayer().getSpecialTiles().size(); i++) {
			if (spTileGrids[i].equals(selectedButton)) {
				spTiles.add(scrabble.getCurrentPlayer().getSpecialTiles().get(i));
			}
		}
	}

	/**
	 * Method to update the game message panel to instruct players what to do.
	 */
	@Override
	public void updateGameMesg(String text) {
		gameMessageLabel.setText(text);
	}

	/**
	 * Method to update the players' scores and show who is at this turn.
	 */
	@Override
	public void updatePlayerInfoPanel() {
		for (int i = 0; i < players.size(); i++) {
			JPanel playerInfo = (JPanel) playerInfoPanel.getComponent(i);
			((JLabel) playerInfo.getComponent(1)).setText("Score: " + players.get(i).getScore());
			if (players.get(i).equals(scrabble.getCurrentPlayer())) {
				playerInfo.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
			} else {
				playerInfo.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
			}
		}
	}
}