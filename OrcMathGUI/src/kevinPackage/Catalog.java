package kevinPackage;

import java.util.ArrayList;

public class Catalog {
	public static ArrayList<DisplayImage> createHeroine;
	private static Catalog maker;
	public Catalog() {
		createHeroine = new ArrayList<DisplayImage>();
		createHeroine.add(new DisplayImage("Aisha", "ponytail", "blue"));
		createHeroine.add(new DisplayImage("Ram", "bobcut", "red"));
		createHeroine.add(new DisplayImage("Mia", "twin-tail", "silver"));
	}
	public static void main(String[] args) {
		maker = new Catalog();
		System.out.println(maker.getCSVConetent());
	}
	public String getCSVConetent() {
		String data = "";
		for(DisplayImage t: createHeroine) {
			data += t+"\n";
		}
		return data;
	}

}
