package db;

import main.Main;

public class SearchLeague extends Search {
	private String leagueName;
	
	public SearchLeague(String name) {
		this.leagueName = name;
		
		proceed();
	}
	
	public void proceed() {
		for (int i=0;i<17994;i++) {
			if (Main.db.getElement(i, 4).equals(leagueName))
				this.indexList.add(i);
		}
	}
}
