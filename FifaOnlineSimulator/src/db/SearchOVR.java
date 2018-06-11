package db;

import main.Main;

public class SearchOVR extends Search{
	private int min, max;
	
	public SearchOVR (int min, int max) {
		this.min = min;
		this.max = max;
		
		proceed();
	}
	
	public void proceed() {
		for (int i = 0; i < 17994; i++) {
			if (Integer.parseInt(Main.db.getElement(i, 12)) >= min && Integer.parseInt(Main.db.getElement(i, 12)) <= max)
				indexList.add(i);
			
			if (Integer.parseInt(Main.db.getElement(i, 12)) < min)
				break;
		}
	}
}
