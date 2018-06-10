package pack;

import java.util.Random;

import card.Player;
import db.SearchOVR;
import main.Main;

public class OVR {
	private SearchOVR search;
	
	OVR(int ovr) {
		Random rand = new Random();
		
		search = new SearchOVR(ovr, 100);
		
		Player player = new Player(rand.nextInt(search.getList().size()));
		Main.person.addPlayer(player);
	}
}
