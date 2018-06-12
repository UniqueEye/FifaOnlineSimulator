package card;

import java.util.Random;

public class Upgrade {
	private int[][] arr = { {100, 100, 100, 100, 100, 100, 100, 100,100, 100},
							{100, 82, 54, 36, 24, 16, 11, 7, 5, 3},
							{100, 54, 67, 44, 30, 20, 13, 9, 6, 4},
							{100, 36, 44, 54, 36, 24, 16, 11, 7, 5},
							{100, 24, 30, 36, 44, 30, 20, 13, 9, 6},
							{100, 16, 20, 24, 30, 36, 24, 16, 11, 7},
							{100, 11, 13, 16, 20, 24, 30, 20, 13, 9},
							{100, 7, 9, 11, 13, 16, 20, 24, 16, 11},
							{100, 5, 6, 7, 9, 11, 13, 16, 20, 13},
							{100, 3, 4, 5, 6, 7, 9, 11, 13, 16} };
	public boolean complete;
	public boolean success;
	public boolean fail;
	public Upgrade(Player p1, Player p2) {
		complete = false;
		if (p1.getId() != p2.getId()) {
			return;
		}
		
		if (p1.getGrade()==0||p2.getGrade()==0) {
			int setLevel;
			if (p1.getGrade()>=p2.getGrade())
				setLevel = p1.getGrade();
			else
				setLevel = p2.getGrade();
			success=true;
			complete = true;
			p1.setGrade(setLevel);
		}
		else if (p1.getGrade() >= p2.getGrade()) {
			p1 = proceed(p1, p2);
			complete = true;
		}
		else {
			p1 = proceed(p2, p1);
			complete = true;
		}
	}
	
	public Player proceed(Player p1, Player p2) {
		success = false;
		fail = false;
		Random rand = new Random();
		if (rand.nextInt(100) < arr[p1.getGrade()][p2.getGrade()]) {
			p1.setGrade(p1.getGrade() + 1);
			success=true;
		}
		else {
			p2.setGrade(0);
			fail = true;
		}
		return p1;
	}
}
