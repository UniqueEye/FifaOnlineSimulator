package db;
import java.util.ArrayList;

import main.Main;


public class SearchOVR extends Search{
	private int min;
	private int max;
	
	
	public SearchOVR (int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public void ovrSearch() {
		for (int i=0;i<17994;i++) {
			if (Integer.parseInt(Main.db.db[i][15])>=min && Integer.parseInt(Main.db.db[i][15])<=max) {
				indexList.add(i);
			}
			if (Integer.parseInt(Main.db.db[i][15])<min)
				break;
		}
	}
	

}
