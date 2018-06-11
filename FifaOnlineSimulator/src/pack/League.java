package pack;

import java.util.Random;

import javax.swing.JOptionPane;

import card.Player;
import db.SearchLeague;
import main.Main;

public class League {
	private SearchLeague search;
	
	public League(String league) {
		Random rand = new Random();
		
		search = new SearchLeague(league);
		
		Player player = new Player(search.getList().get(rand.nextInt(search.getList().size())));
		
		String image = "<html><p style=\"text-align: center;\"><img src=\"" + player.getImage() + "\"></p>";
		image += "<p style=\"text-align: center;\"><span style=\"font-size: 16px;\">" + player.getName() + "</span></p></html>";
		JOptionPane.showMessageDialog(null, image, null, JOptionPane.PLAIN_MESSAGE);
		
		Main.person.addPlayer(player);
	}
}
