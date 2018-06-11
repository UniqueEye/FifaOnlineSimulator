package db;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.Main;
import main.Main;

public class Search {
	protected ArrayList<Integer> indexList = new ArrayList<>();
	public ArrayList<Integer> getList() {return this.indexList;}
	
	private String name;
	private boolean fw, mf, df, gk;
	private int ovrMin, ovrMax;
	
	public Search() {};
	
	public Search(String name, boolean fw, boolean mf, boolean df, boolean gk, int ovrMin, int ovrMax) {
		this.name = name;
		this.fw = fw;
		this.mf = mf;
		this.df = df;
		this.gk = gk;
		this.ovrMin = ovrMin;
		this.ovrMax = ovrMax;
		
		proceed();
	}
	
	private void proceed() {
		boolean nameFound, posFound, ovrFound;
		
		for (int i = 0; i < 17994; i++) {
			nameFound = false;
			posFound = false;
			ovrFound = false;
			
			// SEARCH NAME
			if (name == null) {
				nameFound = true;
			}
			else {
				if (Main.db.getElement(i, 0).toLowerCase().contains(name.toLowerCase()) == true)
					nameFound = true;
			}
			
			// SEARCH OVR
			if (Integer.parseInt(Main.db.getElement(i, 12)) >= ovrMin && Integer.parseInt(Main.db.getElement(i, 12)) <= ovrMax)
				ovrFound = true;
			
			if (nameFound && ovrFound)
				indexList.add(i);
		}
	}
	
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
