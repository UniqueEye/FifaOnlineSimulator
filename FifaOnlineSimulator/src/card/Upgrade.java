package card;

import java.util.Random;

public class Upgrade {
	private int[][] arr = { {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 100, 10, 36, 24, 16, 11, 7, 5, 3},
							{0, 54, 67, 44, 30, 20, 13, 9, 6, 4},
							{0, 36, 44, 54, 36, 24, 16, 11, 7, 5},
							{0, 24, 30, 36, 44, 30, 20, 13, 9, 6},
							{0, 16, 20, 24, 30, 36, 24, 16, 11, 7},
							{0, 11, 13, 16, 20, 24, 30, 20, 13, 9},
							{0, 7, 9, 11, 13, 16, 20, 24, 16, 11},
							{0, 5, 6, 7, 9, 11, 13, 16, 20, 13},
							{0, 3, 4, 5, 6, 7, 9, 11, 13, 16} };
	public boolean complete;
	public boolean success;
	public boolean fail;
	public Upgrade(Player p1, Player p2) {
		complete = false;
		if (p1.getId() != p2.getId()) {
			System.out.println("Select same players.");
			return;
		}
		
		if (p1.getGrade() >= p2.getGrade()) {
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
		System.out.println(p1.getGrade()+" "+p2.getGrade());
		if (rand.nextInt(100) < arr[p1.getGrade()][p2.getGrade()]) {
			System.out.println("\n----- SUCCESS! -----\n");
			p1.setGrade(p1.getGrade() + 1);
			success=true;
		}
		else {
			System.out.println("\n----- FAIL! -----\n");
			p2.setGrade(0);
			fail = true;
		}
		
		System.out.println("proceed "+p1.getGrade());
		return p1;
	}
}
