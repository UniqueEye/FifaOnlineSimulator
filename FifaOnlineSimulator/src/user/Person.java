package user;

import java.util.*;

import card.*;

public class Person {
	private String name;
	private int team;
	private int balance;
	ArrayList<Player> players = new ArrayList<>();
	Player[] starting = new Player[11];
	HashMap<Pack, Integer> items = new HashMap<>();
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addBalance(int amount) {
		balance += amount;
	}
	
	public void subBalance(int amount) {
		balance -= amount;
	}
	
	void addPlayer(Player player) {
		players.add(player);
	}
}
