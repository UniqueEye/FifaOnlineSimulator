package card;

import main.Main;

public class Player {
	private int id, grade;
	
	public Player(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int n) {
		grade = n;
	}
	
	public String getName() {
		return Main.db.getElement(id, 1);
	}
	
	public int getOvr() {
		return Integer.parseInt(Main.db.getElement(id, 6));
	}
	
	public Player upgrade(Player p2) {
		new Upgrade(this, p2);
		return this;
	}
}
