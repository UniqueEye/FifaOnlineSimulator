package db;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.Main;
import main.Main;

public class Search {
	
	protected ArrayList<Integer> indexList = new ArrayList<>();
	protected ArrayList<Integer> getList() {return this.indexList;}
	
	public void showInfo(DB library) {
		for (int i=0;i<indexList.size();i++) {
		int index = indexList.get(i);
		System.out.println("Name: "+library.getElement(index, 1)+ "  Overall: "+library.getElement(index, 15));
		System.out.println("Height: "+library.getElement(index, 7)+"cm  Weight: "+library.getElement(index, 8)+"kg");
		System.out.println("Nationality: "+library.getElement(index, 10)+"  League: "+library.getElement(index, 5));
		System.out.println("Main foot: "+library.getElement(index, 24));
		}
	}
}
