package card;

import java.util.Random;

public class Trade {
	private int avg;
	
	Trade(Player p1, Player p2, Player p3, Player p4, Player p5, Player p6, Player p7, Player p8, Player p9, Player p10) {
		avg = (p1.getOvr() + p2.getOvr() + p3.getOvr() + p4.getOvr() + p5.getOvr() + p6.getOvr() + p7.getOvr() + p8.getOvr() + p9.getOvr() + p10.getOvr()) / 10;
		
		p1.proceed();
	}
	
	Player proceed() {
		Player p1;
		
		Random rand = new Random();
		int num = rand.nextInt(100);
		
		if (num < 20) {
			// ovr > OVR+4
		}
		else if (num < 50) {
			// ovr < OVR-4
		}
		else {
			// OVR-4 <= ovr <= OVR+4
		}
		
		return p1;
	}
}
