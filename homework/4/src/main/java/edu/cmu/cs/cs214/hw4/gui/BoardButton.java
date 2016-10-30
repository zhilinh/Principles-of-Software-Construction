package edu.cmu.cs.cs214.hw4.gui;

import javax.swing.JButton;

public class BoardButton extends JButton{

	private int x, y;
	private boolean isOccupied = false;
	
	public BoardButton(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setOccupied() {
		isOccupied = true;
	}
	
	public void setUnoccupied() {
		isOccupied = false;
	}
	
	public boolean getOccupied() {
		return isOccupied;
	}
	
	public int getXloc() {
		return x;
	}
	
	public int getYloc() {
		return y;
	}
}
