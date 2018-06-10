package card;

import java.util.Random;

public class Trade {
	private int avg;
	
	Trade(Player p1, Player p2, Player p3, Player p4, Player p5, Player p6, Player p7, Player p8, Player p9, Player p10) {
		avg = (p1.getOvr() + p2.getOvr() + p3.getOvr() + p4.getOvr() + p5.getOvr() + p6.getOvr() + p7.getOvr() + p8.getOvr() + p9.getOvr() + p10.getOvr()) / 10;
		
		p1 = proceed(avg);
	}
	
	Player proceed(int avg) {
		Player p1;
		int id = 0;
		 
		Random rand = new Random();
		int num = rand.nextInt(100);
		
		if (num < 20) {
			p1 = new Player(id);
		}
		else if (num < 50) {
			p1 = new Player(id);
		}
		else {
			p1 = new Player(id);
		}
		
		return p1;
	}
}
