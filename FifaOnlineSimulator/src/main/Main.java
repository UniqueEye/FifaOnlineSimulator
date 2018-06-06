package main;

import java.io.*;
import java.util.*;

import card.*;
import db.*;
import user.*;

public class Main {
	public static final DB db = new DB("C:\\DB.csv");
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Person person;
		
		System.out.print("Input your nickname - ");
		person = new Person(s.nextLine());
		
		System.out.println(person.getName());
	}
}
