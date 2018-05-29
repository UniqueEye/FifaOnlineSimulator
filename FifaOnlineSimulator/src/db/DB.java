package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DB {
	String[][] db = new String[3508][113];
	
	public DB (String path) {
		int i = 0;
		int j = 0;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			
			String line;
			
			while ((line = in.readLine()) != null) {
				String[] values = line.split(",");
				
				for (String str : values) {
					db[i][j] = str;
					j++;
				}
				
				j=0;
				i++;
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getElement(int i, int j) {
		return db[i][j];
	}
}
