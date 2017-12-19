package kevinPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
	public static ArrayList<DisplayImage> createHeroine;
	private static Catalog maker;
	private Scanner input;

	public Catalog() {
		createHeroine = new ArrayList<DisplayImage>();
		createHeroine.add(new DisplayImage("Aisha", "ponytail", "blue"));
		createHeroine.add(new DisplayImage("Ram", "bobcut", "red"));
		createHeroine.add(new DisplayImage("Mia", "twin-tail", "silver"));
		input = new Scanner(System.in);
	}
	public static void main(String[] args) {
		maker = new Catalog();
		while(!maker.wantToAdd()) {
		createHeroine.add(new DisplayImage(maker.getName(), maker.getHairColor(), maker.getEyeColor()));
		System.out.println(maker.getCSVConetent());
		}
		System.out.println(maker.getCSVConetent());
	}
	public String getCSVConetent() {
		String data = "";
		for(DisplayImage t: createHeroine) {
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
		System.out.println("Please input the hairstyle of your waifu/husbando:");
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

}
