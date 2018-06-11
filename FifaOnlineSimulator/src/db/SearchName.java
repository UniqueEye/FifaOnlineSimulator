package db;

import main.Main;

public class SearchName extends Search {
	private String name;
	
	public SearchName(String name) {
		this.name = name;
		
		proceed();
	}
	
	private void proceed() {
		for (int i = 0; i < 17994; i++) {
			if (Main.db.getElement(i, 0).equals(name)) {
				indexList.add(i);
			}
		}
	}

}
