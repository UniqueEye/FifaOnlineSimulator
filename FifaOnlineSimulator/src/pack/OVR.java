package pack;

import java.util.Random;

import card.Player;
import db.SearchOVR;
import main.Main;

public class OVR {
	private SearchOVR search;
	
	public OVR(int ovr) {
		Random rand = new Random();
		
		search = new SearchOVR(ovr, 100);
		
		Player player = new Player(search.getList().get(rand.nextInt(search.getList().size())));
		
		/* FOR TEST */
		System.out.println("Opening OVR OVER " + ovr + " Pack");
		System.out.println("You've got \"" + player.getName() + "\"");
		
		Main.person.addPlayer(player);
	}
}
