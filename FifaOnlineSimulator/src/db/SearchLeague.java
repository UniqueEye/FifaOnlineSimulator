package db;

import main.Main;

public class SearchLeague extends Search {
	private String leagueName;
	
	public SearchLeague(String name) {
		this.leagueName = name;
	}
	
	public void leagueSearch() {
		for (int i=0;i<19774;i++) {
			if (Main.db.db[i][5].equals(leagueName))
				this.indexList.add(i);
		}
	}
}
