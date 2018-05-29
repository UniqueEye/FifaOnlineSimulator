package card;

public class Player {
	private String name;
	private String position;
	private int ovr, grade;
	private int height, weight;
	private int left, right;
	private int pac, sho, pas, dri, def, phy;
	private int div, han, kic, ref, spd, pos;
	
	public Player(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int n) {
		grade = n;
	}
	
	public Player upgrade(Player p2) {
		new Upgrade(this, p2);
		return this;
	}
}
