package main;

import java.io.*;
import java.util.*;

import card.*;
import db.*;
import user.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		DB db = new DB("C:\\Users\\Yuan\\Desktop\\DB.csv");
		Person person;
		
		System.out.print("Input your nickname - ");
		person = new Person(s.nextLine());
		
		System.out.println(person.getName());
	}
}
