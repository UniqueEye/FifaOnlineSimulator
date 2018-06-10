package pack;

import java.util.Random;

import card.Player;
import db.SearchLeague;
import main.Main;

public class League {
	private SearchLeague search;
	
	public League(String league) {
		Random rand = new Random();
		
		search = new SearchLeague(league);
		
		Player player = new Player(search.getList().get(rand.nextInt(search.getList().size())));
		
		/* FOR TEST */
		System.out.println("Opening " + league + " Pack");
		System.out.println("You've got \"" + player.getName() + "\"");
		
		Main.person.addPlayer(player);
	}
}
