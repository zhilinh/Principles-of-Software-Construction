package edu.cmu.cs.cs214.hw4.core.specialtile;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.cs.cs214.hw4.core.Player;

/**
 * Class to sell the special tile by scores to players.
 * @author zhilinh
 *
 */
public class Shop {
	
	private List<SpecialTile> specialTiles = new ArrayList<SpecialTile>();
	private int num;
	
	/**
	 * Constructor to add different special tiles to the shop.
	 */
	public Shop() {
		specialTiles.add(new Boom());
		specialTiles.add(new NegativePoints());
		specialTiles.add(new ReversePlayerOrder());
		specialTiles.add(new ThoughtSteal());
		specialTiles.add(new UnknownTile());

	}
	
	/**
	 * Method to charge the player and sell the special tile. 
	 */
	public void buySpecialTile(Integer num, Player player) {
		this.num = num;
		if (player.getScore() >= specialTiles.get(num).getPrice()) {
			player.updateScore(-specialTiles.get(num).getPrice());
			player.addSpecialTile(specialTiles.get(num));
		}
		
	}
}
