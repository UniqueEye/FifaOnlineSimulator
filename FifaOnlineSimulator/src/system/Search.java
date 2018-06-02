package system;

import java.util.InputMismatchException;
import java.util.Scanner;

import db.DB;

public class Search {
	public Search() {
		DB library = new DB("C:\\Users\\Â÷Çö¹¬\\Desktop\\FifaOnlineSimulator\\DB.csv");
		System.out.print("Search with 1.name    2.overall : ");
		int input;
		while (true) {
				try{
					Scanner scanner = new Scanner(System.in);
					input = scanner.nextInt();
					while(input!=1&&input!=2){
						System.out.println("Enter 1 or 2");
						System.out.print("Search with 1.name    2.overall : ");
						scanner = new Scanner(System.in);
						input = scanner.nextInt();
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Must Enter Integer");
					System.out.print("Search with 1.name    2.overall : ");
				}
		}
		
		if (input==1) {
			Scanner scanName = new Scanner(System.in);
			int i;
			System.out.print("Enter name : ");
			String inputName = scanName.nextLine();
			inputName=inputName.toLowerCase();
			System.out.println(inputName);
			
			for (i=0;i<3508;i++) {
				boolean isFound=false;
				String pName = library.getElement(i, 1);
				pName=pName.toLowerCase();
				String pNameList1[] = pName.split(" ");
				String pNameList2[] = pName.split(".");
				
				for (int k=0;k<pNameList1.length;k++) {
					if (inputName.equals(pNameList1[k])) {
						isFound=true;
						break;
					}
				}
				for (int k=0;k<pNameList2.length;k++) {
					if (inputName.equals(pNameList2[k])) {
						isFound=true;
						break;
					}
				}
				if (isFound)
					break;
			}
			
			if (i==3508){
				System.out.println("Player is not found");
				return;
				}
			System.out.println("--------------------------------------------------");
			showInfo(library, i);
			System.out.println("--------------------------------------------------");
		}
		
		if (input==2) {
			
			int inputMaxOVR;
			int inputMinOVR;
			System.out.print("Enter MaxOverall : ");
			while(true) {
					try {
						Scanner scanOVR = new Scanner(System.in);
						inputMaxOVR = scanOVR.nextInt();
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
						inputMinOVR = scanOVR.nextInt();
						while (inputMinOVR>inputMaxOVR) {
							System.out.println("MinOverall shoud nor larger than MaxOverall");
							System.out.print("Enter MaxOverall : ");
							scanOVR = new Scanner(System.in);
							inputMinOVR = scanOVR.nextInt();
						}
						break;
					} catch (InputMismatchException e) {
						System.out.println("Must Enter Integer");
						System.out.print("Enter MinOverall : ");
					}
			}
			int i;
			
			if (inputMaxOVR<48) {
				System.out.println("Player is not found");
				return;
			}
			
			if (inputMaxOVR>94)
				inputMaxOVR=94;
			
			for (i=0;i<3508;i++) {
				if(inputMaxOVR==Integer.parseInt(library.getElement(i, 15)))
						break;
			}
			
			int showNum=20;
			
			for (int j=0;j<showNum;j++) {
				if(inputMinOVR>Integer.parseInt(library.getElement(i, 15)))
					break;
				System.out.println("--------------------------------------------------");
				showInfo(library, i++);
				System.out.println("--------------------------------------------------");
				if (i==3508)
					break;
			}
			
		}
	}
	
	public void showInfo(DB library, int index) {
		System.out.println("Name: "+library.getElement(index, 1)+ "  Overall: "+library.getElement(index, 15));
		System.out.println("Height: "+library.getElement(index, 7)+"cm  Weight: "+library.getElement(index, 8)+"kg");
		System.out.println("Nationality: "+library.getElement(index, 10)+"  League: "+library.getElement(index, 5));
		System.out.println("Main foot: "+library.getElement(index, 24));
	}
}
