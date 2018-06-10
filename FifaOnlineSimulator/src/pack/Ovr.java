package pack;

import java.util.Random;

import card.Player;
import main.Main;

public class Ovr {
	private int startId, endId, returnId;
	
	Ovr() {
		Random rand = new Random();
		returnId = startId + rand.nextInt(endId - startId + 1);
		
		Player player = new Player(returnId);
		Main.person.addPlayer(player);
	}
}
