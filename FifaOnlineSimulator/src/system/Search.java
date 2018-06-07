package system;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import db.DB;

public class Search {
	
	private ArrayList<Integer> indexList = new ArrayList<>();
	
	public Search() {
		DB library = new DB("C:\\Users\\Â÷Çö¹¬\\Desktop\\FifaOnlineSimulator\\DB.csv");
		Scanner scanName = new Scanner(System.in);
	
		System.out.print("Enter name : ");  //Name
		String inputName = scanName.nextLine();
		inputName=inputName.toLowerCase();
		if (inputName.equals("")) {
			inputName = null;
		}
		System.out.println(inputName);
	
		int inputMaxOVR;	//OVR
		int inputMinOVR;
		String inputSMaxOVR = null;
		String inputSMinOVR = null;
		System.out.print("Enter MaxOverall : ");
		while(true) {
				try {
					Scanner scanOVR = new Scanner(System.in);
					inputSMaxOVR = scanOVR.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Must Enter Integer");
					System.out.print("Enter MaxOverall : ");
				}
		}
		System.out.print("Enter MinOverall : ");
		while(true) {
				try {
					Scanner scanOVR = new Scanner(System.in);
					inputSMinOVR = scanOVR.nextLine();
					if (inputSMinOVR.equals("")||inputSMaxOVR.equals("")) {
					}
					else {
						while (Integer.parseInt(inputSMinOVR)>Integer.parseInt(inputSMaxOVR)) {
							System.out.println("MinOverall shoud nor larger than MaxOverall");
							System.out.print("Enter MaxOverall : ");
							scanOVR = new Scanner(System.in);
							inputSMinOVR = scanOVR.nextLine();
						}
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Must Enter Integer");
					System.out.print("Enter MinOverall : ");
				}
		}
		
		if (inputSMaxOVR.equals("")) {
			inputMaxOVR = 999;
		}
		else {
		inputMaxOVR=Integer.parseInt(inputSMaxOVR);}
		
		if (inputSMinOVR.equals("")) {
			inputMinOVR = -1;
		}
		else {
		inputMinOVR=Integer.parseInt(inputSMinOVR);}
		
		System.out.println(inputMaxOVR);
		System.out.println(inputMinOVR);
		
		
		System.out.print("Enter nationality : ");
		Scanner scanNation = new Scanner(System.in);
		String inputNation = scanNation.nextLine();
		inputNation = inputNation.toLowerCase();
		
		if (inputNation.equals("")) {
			inputNation = null;
		}
		
		System.out.println(inputNation);
		
		ArrayList<String> leagueList = new ArrayList<>();
		leagueList.add("Argentinian Superliga");
		leagueList.add("English ChampionShip");
		leagueList.add("English Premier League");
		leagueList.add("Freanch League 1");
		leagueList.add("German BundesLiga");
		leagueList.add("Holland Erevisie");
		leagueList.add("Italian Serie A");
		leagueList.add("Japanese J1 League");
		leagueList.add("Korean K League Classic");
		leagueList.add("Mexican Liga MX");
		leagueList.add("Portuguese Primeira League");
		leagueList.add("Russian Premier League");
		leagueList.add("Spanish Primera Division");
		leagueList.add("Turkish Super Lig");
		leagueList.add("Ukrainian Premier League");
		leagueList.add("USA Major League Soccer");
		
		for (String name : leagueList) {
			System.out.println(leagueList.indexOf(name)+1 +" "+ name);
		}
		
		System.out.print("Choose a league, if you don't Enter 0 : ");
		
		
		int inputLeague=0;
		String inputLiga = null;
		while (true) {
			try {
				Scanner scanLeague = new Scanner(System.in);
				inputLeague = scanLeague.nextInt();
				while (inputLeague>leagueList.size()||inputLeague<0){
					System.out.print("Enter smaller Integer : ");
					scanLeague = new Scanner(System.in);
					inputLeague = scanLeague.nextInt();
				}
				break;
				} catch (InputMismatchException e) {
					System.out.print("Must enter integer : ");
			}
		}
		
		
		if (inputLeague!=0) {
			inputLiga = leagueList.get(inputLeague-1);
		}
		
		System.out.println(inputLiga);
		
		ArrayList<String> positionList = new ArrayList<>();
		positionList.add("FW");
		positionList.add("MF");
		positionList.add("DF");
		positionList.add("GK");
		
		for (String name : positionList) {
			System.out.println(positionList.indexOf(name)+1 +" "+ name);
		}
		
		System.out.print("Choose a position, if you don't Enter 0 : ");
		
		int inputPosition=0;
		while (true) {
			try {
				Scanner scanPosition = new Scanner(System.in);
				inputPosition = scanPosition.nextInt();
				while (inputPosition>positionList.size()||inputPosition<0){
					System.out.print("Enter smaller Integer : ");
					scanPosition = new Scanner(System.in);
					inputPosition = scanPosition.nextInt();
				}
				break;
				} catch (InputMismatchException e) {
					System.out.print("Must enter integer : ");
			}
		}
		
		
		System.out.println(inputPosition);
		//------------------------------------------------------------------------
		this.indexList = new ArrayList<>();
		
		for (int i=0;i<3508;i++) {
			boolean nameFound = false, ovrFound = false, nationFound = false, leagueFound = false, positionFound = false;
			//Search Name --------------------------------------------------------
			if (inputName==null)
				nameFound = true;
			else {
				String pName = library.getElement(i, 1);
				pName=pName.toLowerCase();
				String pNameList1[] = pName.split(" ");
				String pNameList2[] = pName.split(".");
				
				for (int k=0;k<pNameList1.length;k++) {
					if (inputName.equals(pNameList1[k])) {
						nameFound=true;
						break;
					}
				}
				for (int k=0;k<pNameList2.length;k++) {
					if (inputName.equals(pNameList2[k])) {
						nameFound=true;
						break;
					}
				}
			}
			
			
			//Search OVR ---------------------------------------------------------
			if (Integer.parseInt(library.getElement(i, 15))<=inputMaxOVR && Integer.parseInt(library.getElement(i, 15))>=inputMinOVR)
				ovrFound = true;
			//Search Nation ------------------------------------------------------
			if (inputNation==null)
				nationFound = true;
			else {
				String pNation = library.getElement(i, 10);
				pNation=pNation.toLowerCase();
				String pNationList1[] = pNation.split(" ");
				String pNationList2[] = pNation.split(".");
				
				
				for (int k=0;k<pNationList1.length;k++) {
					if (inputNation.equals(pNationList1[k])) {
						nationFound=true;
						break;
					}
				}
				for (int k=0;k<pNationList2.length;k++) {
					if (inputNation.equals(pNationList2[k])) {
						nationFound=true;
						break;
					}
				}
			}
			//Search league ---------------------------------------------------
			if (inputLiga==null)
				leagueFound = true;
			else {
				if (inputLiga.equals(library.getElement(i, 5)))
					leagueFound = true;
			}
			//Search position -------------------------------------------------
			if (inputPosition==0)
				positionFound = true;
			else if (inputPosition==1){
				for (int j=86;j<113;j++) {
					if (library.getElement(i, j).equals("TRUE")&&(j==86||j==87||j==88||j==96||j==97||j==98||j==106||j==107)) {
						positionFound = true;
					}
				}
			}
			else if (inputPosition==2){
				for (int j=86;j<113;j++) {
					if (library.getElement(i, j).equals("TRUE")&&(j==89||j==90||j==91||j==92||j==100||j==101||j==102||j==108||j==109||j==110)) {
						positionFound = true;
					}
				}
			}
			else if (inputPosition==3){
				for (int j=86;j<113;j++) {
					if (library.getElement(i, j).equals("TRUE")&&(j==93||j==94||j==95||j==103||j==104||j==105||j==111)) {
						positionFound = true;
					}
				}
			}
			else if (inputPosition==4){
				for (int j=86;j<113;j++) {
					if (library.getElement(i, j).equals("TRUE")&&j==112) {
						positionFound = true;
					}
				}
			}
			
			if (nameFound && ovrFound && nationFound && leagueFound &&positionFound)
				indexList.add(i);
		}
		
		for (Integer idx : indexList)
			showInfo (library, idx);
			
	}
	
	
	
	public void showInfo(DB library, int index) {
		System.out.println("Name: "+library.getElement(index, 1)+ "  Overall: "+library.getElement(index, 15));
		System.out.println("Height: "+library.getElement(index, 7)+"cm  Weight: "+library.getElement(index, 8)+"kg");
		System.out.println("Nationality: "+library.getElement(index, 10)+"  League: "+library.getElement(index, 5));
		System.out.println("Main foot: "+library.getElement(index, 24));
	}
}
