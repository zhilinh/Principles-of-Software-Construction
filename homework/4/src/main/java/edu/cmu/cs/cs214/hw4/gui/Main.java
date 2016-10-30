package edu.cmu.cs.cs214.hw4.gui;

import javax.swing.SwingUtilities;

import edu.cmu.cs.cs214.hw4.core.Scrabble;

public class Main {
	
	private static final Scrabble scrabble = new Scrabble();
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			EntryFrame entryFrame = new EntryFrame(scrabble);
			entryFrame.setVisible(true);
			entryFrame.setResizable(true);
        });
	}
}
