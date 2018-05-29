package user;

import java.util.*;

import card.*;

public class Person {
	private String name;
	private int team;
	private int balance;
	ArrayList<Player> list = new ArrayList<>();
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	void addPlayer(Player player) {
		list.add(player);
	}
}
