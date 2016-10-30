package edu.cmu.cs.cs214.hw4.core.specialtile;

import java.util.Hashtable;

import edu.cmu.cs.cs214.hw4.core.Player;

/**
 * Class to sell the special tile by scores to players.
 * @author zhilinh
 *
 */
public class Shop {
	
	private Hashtable<String, SpecialTile> price = new Hashtable<String, SpecialTile>();
	
	/**
	 * Constructor to add different special tiles to the shop.
	 */
	public Shop() {
		price.put("Boom", new Boom());
		price.put("Negative", new NegativePoints());
		price.put("Reverse", new ReversePlayerOrder());
		price.put("T.Steal", new ThoughtSteal());
		price.put("R.Down", new RotateDown());
	}
	
	/**
	 * Method to charge the player and sell the special tile. 
	 * @return result of the buying
	 */
	public boolean buySpecialTile(String name, Player player) {
		
		if (player.getScore() >= price.get(name).getPrice()) {
			player.updateScore(-price.get(name).getPrice());			
			if (name == "Boom") {
				SpecialTile a = new Boom();
				a.setOwner(player);
				player.addSpecialTile(a);
			} else if (name == "Negative") {
				SpecialTile a = new NegativePoints();
				a.setOwner(player);
				player.addSpecialTile(a);				
			} else if (name == "Reverse") {
				SpecialTile a = new ReversePlayerOrder();
				a.setOwner(player);
				player.addSpecialTile(a);
			} else if (name == "T.Steal") {
				SpecialTile a = new ThoughtSteal();
				a.setOwner(player);
				player.addSpecialTile(a);
			} else {
				SpecialTile a = new RotateDown();
				a.setOwner(player);
				player.addSpecialTile(a);
			}
			return true;
		} else {
			return false;
		}
	}
}
