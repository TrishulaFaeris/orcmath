package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class StevenButton extends Button implements ButtonInterfaceKevin {
	
	private Color a;

	public StevenButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(a);
		
	}
	
	@Override
	public void highlight() {
		setColor(Color.darkGray);
	}

	@Override
	public void setColor(Color color) {
		a=color;
	}

	@Override
	public void dim() {
		setColor(a);

	}

}
