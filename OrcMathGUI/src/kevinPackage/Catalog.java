package kevinPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;

public class Catalog {
	public static ArrayList<Heroine> createHeroine;
	private static Catalog maker;
	private Scanner input;

	public Catalog() {
		createHeroine = new ArrayList<Heroine>();
		createHeroine.add(new Heroine("Aisha", "ponytail", "blue"));
		createHeroine.add(new Heroine("Ram", "bobcut", "red"));
		createHeroine.add(new Heroine("Mia", "twin-tail", "silver"));
		input = new Scanner(System.in);
	}
	public static void main(String[] args) {
		maker = new Catalog();
		while(!maker.wantToAdd()) {
			maker.add();
		System.out.println(maker.getCSVConetent());
		}
		System.out.println(maker.getCSVConetent());
	}
	public String getCSVConetent() {
		String data = "";
		for(Heroine t: createHeroine) {
			data += t+"\n";
		}
		return data;
	}
	public String getInput() {
		String s = input.nextLine();
		return s;
	}
	public String getName() {
		System.out.println("Please input the name of your waifu/husbando:");
		String response = getInput();
		return response;
		
	}
	public String getHairColor() {
		System.out.println("Please input the haircolor of your waifu/husbando:");
		String response = getInput();
		return response;
	}
	public String getEyeColor() {
		System.out.println("Please input the eyecolor of your waifu/husbando:");
		String response = getInput();
		return response;
	}
	public boolean wantToAdd() {
		System.out.println("Do you want to add?");
		String response = getInput();
		return (response.equalsIgnoreCase("no"));
	}
	public void save() {
		try{    
			FileWriter fw=new FileWriter("BookCatalog.csv");
			for(Heroine b: createHeroine){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"BookCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
	private void add() {
		createHeroine.add(new Heroine(maker.getName(), maker.getHairColor(), maker.getEyeColor()));
	}
	

}
