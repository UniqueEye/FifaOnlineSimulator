package main;

import java.io.*;
import java.util.*;

import card.*;
import db.*;
import user.*;

public class Main {
	public static final DB db = new DB("C:\\DB.csv");
	public static final Person person = new Person();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Input your nickname - ");
		person.setName(s.nextLine());
		
		System.out.println(person.getName());
	}
}
