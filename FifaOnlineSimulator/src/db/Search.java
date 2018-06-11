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
		boolean nameFound, fwFound, mfFound, dfFound, gkFound, ovrFound;
		
		for (int i = 0; i < 17994; i++) {
			nameFound = false;
			fwFound = false;
			mfFound = false;
			dfFound = false;
			gkFound = false;
			ovrFound = false;
			
			// SEARCH NAME
			if (name == null) {
				nameFound = true;
			}
			else {
				if (Main.db.getElement(i, 0).toLowerCase().contains(name.toLowerCase()) == true)
					nameFound = true;
			}
			
			// SEARCH FW
			if (fw == false) {
				fwFound = true;
			}
			else {
				for (int j = 85; j < 107; j++) {
					if (Main.db.getElement(i, j).equals("TRUE") && (j == 85 || j == 86 || j == 87 || j == 95 || j == 96 || j == 97 || j == 105 || j == 106)) {
						fwFound = true;
						break;
					}
				}
			}
			
			// SEARCH MF
			if (mf == false) {
				mfFound = true;
			}
			else {
				for (int j = 88; j < 110; j++) {
					if (Main.db.getElement(i, j).equals("TRUE") && (j == 88 || j == 89 || j == 90 || j == 91 || j == 98 || j == 99 || j == 100 || j == 101 || j == 107 || j == 108 || j == 109)) {
						mfFound = true;
						break;
					}
				}
			}
			
			// SEARCH DF
			if (df == false) {
				dfFound = true;
			}
			else {
				for (int j = 92; j < 111; j++) {
					if (Main.db.getElement(i, j).equals("TRUE") && (j == 92 || j == 93 || j == 94 || j == 102 || j == 103 || j == 104 || j == 110)) {
						dfFound = true;
						break;
					}
				}
			}
			
			// SEARCH GK
			if (gk == false) {
				gkFound = true;
			}
			else {
				if (Main.db.getElement(i, 111).equals("TRUE")) {
					gkFound = true;
				}
			}
			
			// SEARCH OVR
			if (Integer.parseInt(Main.db.getElement(i, 12)) >= ovrMin && Integer.parseInt(Main.db.getElement(i, 12)) <= ovrMax)
				ovrFound = true;
			
			if (nameFound && fwFound && mfFound && dfFound && gkFound && ovrFound)
				indexList.add(i);
		}
	}
}
