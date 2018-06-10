package user;

import java.util.*;

import card.*;

public class Person {
	private String name;
	private int balance = 0;
	public ArrayList<Player> players = new ArrayList<>();
	Player[] starting = new Player[11];
	private String[] packName = { "OVR ALL", "OVR OVER 60", "OVR OVER 65", "OVR OVER 70", "OVR OVER 75", "OVR OVER 80" };
	public int[] packs = new int[12];
	
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
	
	public void openPack(int idx) {
		if (packs[idx] < 0)
			System.out.println("You don't have \"" + packName[idx] + "\".");
		else {
			packs[idx]--;
		}
	}
}
