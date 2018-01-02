package kevinPackage;

import java.awt.Color;
import java.awt.Graphics2D;
import guiTeacher.components.Button;

public class CustomButton extends Button {

	private String string1;
	private String string2;
	private Color color;
	
	public CustomButton(int x, int y) {
		super(x, y, 50, 50, "", null);
		string1 = "Hello";
		string2 = "Bye";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void drawButton(Graphics2D g, boolean hover) {
		g.setColor(Color.BLACK);
		g.drawString(string1, 40, 80);
		g.drawString(string2, 40, 120);
		g.fillRect(0, 0, 50, 50);
	}
	public void updateString1(String string) {
		
	}
	public void updateString2(String string) {
		
	}
	public void setIconColor(Color color) {
		this.color = color;
	}

}
