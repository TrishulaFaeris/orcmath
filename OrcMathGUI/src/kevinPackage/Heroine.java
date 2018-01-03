package kevinPackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Scanner;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Heroine extends AnimatedComponent {

	public  String name;
	public String hairStyle;
	public String eyeColor;
	public static void main(String[] args) {
	}
	public Heroine(String name, String hairstyle, String eyecolor) {
		super(0, 0, 95, 107);
		addSequence("resources/rem sprite.png", 180, 0, 0, 95, 107, 6);
		Thread animation = new Thread(this);
		animation.start();
		update();
		this.name = name;
		this.hairStyle = hairstyle;
		this.eyeColor = eyecolor;
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.pink);
		super.update(g);

	}
	public String toString(){
		return name+","+hairStyle+","+eyeColor;
	}
	
}
