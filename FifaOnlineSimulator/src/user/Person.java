package user;

import java.util.*;

import card.*;

public class Person {
	private String name;
	private int balance = 0;
	public ArrayList<Player> players = new ArrayList<>();
	
	public Person() {
		
	}
	
	public void setName(String name) {
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
	
	public int getBalance() {
		return balance;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
}
