package edu.cmu.cs.cs214.hw4.gui;

public interface GameChangeListener {
	
	public void updateInventory();
	
	public void updateSpecialTile();
		
	public void updateBoard();
	
	public void updateGameMesg(String text);
	
	public void updatePlayerInfoPanel();
}
