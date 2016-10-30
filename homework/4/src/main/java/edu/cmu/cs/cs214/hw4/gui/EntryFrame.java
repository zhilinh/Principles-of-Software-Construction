package edu.cmu.cs.cs214.hw4.gui;

import javax.swing.*;

import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Scrabble;

public class EntryFrame extends JFrame {
	    
	//Class constants
	private static final String TITLE = "Scrabble Game";

	//GUI components
	private InputPanel inputPanel;
	private JTextArea feedbackArea;
	private Scrabble scrabble;
	private JButton startButton;
	private static final String START_BUTTON_TEXT = "Start Game";

    public EntryFrame(Scrabble scrabble) {
    	
    	super(TITLE);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.scrabble = scrabble;
    	inputPanel = new InputPanel();
    	feedbackArea = new JTextArea();
		startButton = new JButton(START_BUTTON_TEXT);
		
		//Functions of the start button
    	startButton.addActionListener(e -> {
    		if (scrabble.getPlayers().size() != 0) {
        		this.scrabble.startGame();
    			JFrame gameFrame = new JFrame(TITLE);
    			ScrabblePanel gamePanel = null;
    			gamePanel = new ScrabblePanel(this.scrabble);
        		gameFrame.add(gamePanel);
        		gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        		gameFrame.pack();
        		gameFrame.setVisible(true);
        		super.dispose();
    		}    		
    	});

    	setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
    	add(inputPanel);
    	add(feedbackArea);
    	add(startButton);
    	super.pack();
    	super.setVisible(true);
    }

	private class InputPanel extends JPanel {
		
		private static final String ADD_BUTTON_TEXT = "Create Player";
		private static final int INPUT_FIELD_WIDTH = 40;
		private JButton addButton;
		private JTextField input;
		private boolean sameName = false;
		
		InputPanel() {
			addButton = new JButton(ADD_BUTTON_TEXT);
			input = new JTextField("", INPUT_FIELD_WIDTH);
			
			//Functions of the add button
        	addButton.addActionListener(e -> {
        		if (input.getText().toString().length() != 0) {
        			for (Player i : scrabble.getPlayers()) {
        				if (i.getName().equals(input.getText().toString())) {
        					sameName = true;
        				}
        			}
        			if (! sameName) {
        				scrabble.addPlayer(input.getText().toString());
            			feedbackArea.append("Player: " + input.getText().toString() + " / ");
            			input.setText("");
        			}
        			sameName = false;
        		}
        	});
			add(new JLabel("Please input a name of player!"));
			add(input);
			add(addButton);
	    }
	}
}
