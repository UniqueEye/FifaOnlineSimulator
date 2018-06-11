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
		return Main.db.getElement(id, 0);
	}
	
	public String getLeague() {
		return Main.db.getElement(id, 4);
	}
	
	public int getOvr() {
		return Integer.parseInt(Main.db.getElement(id, 12));
	}
	
	public Player upgrade(Player p2) {
		new Upgrade(this, p2);
		return this;
	}
}
