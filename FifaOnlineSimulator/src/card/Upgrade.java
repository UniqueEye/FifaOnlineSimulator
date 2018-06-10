package card;

import java.util.Random;

public class Upgrade {
	private int[][] arr = { {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 82, 54, 36, 24, 16, 11, 7, 5, 3},
							{0, 54, 67, 44, 30, 20, 13, 9, 6, 4},
							{0, 36, 44, 54, 36, 24, 16, 11, 7, 5},
							{0, 24, 30, 36, 44, 30, 20, 13, 9, 6},
							{0, 16, 20, 24, 30, 36, 24, 16, 11, 7},
							{0, 11, 13, 16, 20, 24, 30, 20, 13, 9},
							{0, 7, 9, 11, 13, 16, 20, 24, 16, 11},
							{0, 5, 6, 7, 9, 11, 13, 16, 20, 13},
							{0, 3, 4, 5, 6, 7, 9, 11, 13, 16} };
	
	Upgrade(Player p1, Player p2) {
		if (p1.getId() != p2.getId()) {
			System.out.println("Select same players.");
			return;
		}
		
		if (p1.getGrade() >= p2.getGrade()) {
			p1 = proceed(p1, p2);
		}
		else {
			p1 = proceed(p2, p1);
		}
	}
	
	Player proceed(Player p1, Player p2) {
		Random rand = new Random();
		
		if (rand.nextInt(100) < arr[p1.getGrade()][p2.getGrade()]) {
			System.out.println("\n----- SUCCESS! -----\n");
			p1.setGrade(p1.getGrade() + 1);
		}
		else {
			System.out.println("\n----- FAIL! -----\n");
			p1.setGrade(0);
		}
		
		return p1;
	}
}
