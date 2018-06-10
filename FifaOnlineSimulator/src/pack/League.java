package pack;

import java.util.Random;

import card.Player;
import db.SearchLeague;
import main.Main;

public class League {
	private SearchLeague search;
	
	League(String league) {
		Random rand = new Random();
		
		search = new SearchLeague(league);
		
		Player player = new Player(rand.nextInt(search.getList().size()));
		Main.person.addPlayer(player);
	}
}
