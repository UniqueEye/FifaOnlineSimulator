package card;

import java.util.ArrayList;
import java.util.Random;

import db.SearchOVR;

public class Trade {
	private int avg;
	private Player result;
	private SearchOVR search;
	
	public Player getResult() {return this.result;}
	public Trade(Player p1, Player p2, Player p3, Player p4, Player p5, Player p6, Player p7, Player p8, Player p9, Player p10) {
		avg = (p1.getOvr() + p2.getOvr() + p3.getOvr() + p4.getOvr() + p5.getOvr() + p6.getOvr() + p7.getOvr() + p8.getOvr() + p9.getOvr() + p10.getOvr()) / 10;
		
		result = proceed(avg);
	}
	
	Player proceed(int avg) {
		Player p1;
		int id = 0;
		 
		Random rand = new Random();
		int num = rand.nextInt(100);
		
		if (num < 20) {
			if (avg+4>94) {
				search = new SearchOVR(94, 100);
			}
			else 
				search = new SearchOVR(avg+4,100);
			
			int ranNum = rand.nextInt(search.getList().size());
			
			p1 = new Player(search.getList().get(ranNum));
		}
		else if (num < 50) {
			if (avg-4<46) {
				search = new SearchOVR(0,46);
			}
			else {
				search = new SearchOVR(0,avg-4);
			}
			int ranNum = rand.nextInt(search.getList().size());
			
			p1 = new Player(search.getList().get(ranNum));
		}
		else {
			search = new SearchOVR(avg-4,avg+4);
			int ranNum = rand.nextInt(search.getList().size());
			
			p1 = new Player(search.getList().get(ranNum));
		}
		
		return p1;
	}
}
