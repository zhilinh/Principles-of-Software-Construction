package edu.cmu.cs.cs214.rec08.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import edu.cmu.cs.cs214.rec08.core.GameChangeListener;
import edu.cmu.cs.cs214.rec08.core.TicTacToe;
import edu.cmu.cs.cs214.rec08.core.TicTacToe.Player;

public class TicTacToeGui extends JFrame implements GameChangeListener{
	
	private final TicTacToe game;
	private final JButton[][] squares;
	private final JLabel currentPlayerLabel;
	
	public TicTacToeGui (TicTacToe game) {
		this.game = game;
		game.addGameChangeListener(this);
		currentPlayerLabel = new JLabel();
		squares = new JButton[TicTacToe.GRID_SIZE][TicTacToe.GRID_SIZE];
		
		setLayout(new BorderLayout());
		add(currentPlayerLabel, BorderLayout.NORTH);
		add(createGrid(), BorderLayout.CENTER);
		pack();
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private JPanel createGrid() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(game.GRID_SIZE, game.GRID_SIZE));
		
		for (int i = 0; i < game.GRID_SIZE; i++){
			for (int j = 0; j < game.GRID_SIZE; j++) {
				JButton button = new JButton();
				button.setText(i + "," + j);
				int row = i;
				int col = j;
				button.addActionListener(e -> game.playMove(row, col));
				panel.add(button);
				squares[i][j] = button;
			}
		}
		return panel;
	}
	
	@Override
	public void squareChanged(int row, int col) {
		// TODO Auto-generated method stub
		squares[row][col].setText(game.getCurrentPlayer().name());
	}

	@Override
	public void currentPlayerChanged(Player player) {
		// TODO Auto-generated method stub
		currentPlayerLabel.setText(player.name());
	}

	@Override
	public void gameEnded(Player winner) {
		// TODO Auto-generated method stub
		currentPlayerLabel.setText("Winner is:" + winner.name());
	}

}
