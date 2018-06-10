package main;

import java.io.*;
import java.util.*;

import card.*;
import db.*;
import pack.*;
import user.*;

public class Main {
	public static final DB db = new DB("C:\\DB.csv");
	public static final Person person = new Person();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		person.setName("UniqueEye");
		
		System.out.println("Nickname - " + person.getName());
		System.out.println("Balance - " + person.getBalance() + "\n");
	}
}
