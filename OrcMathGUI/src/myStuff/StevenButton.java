package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class StevenButton extends Button implements ButtonInterfaceKevin {
	
	private final Color a;
	private boolean highlighted;
	private int x;
	private int y;
	private int serial;
	static int count = 0;
	
	public StevenButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		a=Color.black;
		serial = count;
		count++;
		highlighted=false;
		this.x=x;
		this.y=y;
		
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(highlighted) {
			g.setColor(Color.darkGray);
			g.fillRect(x,y,getWidth(),getHeight());
			g.setColor(Color.darkGray);
		}else {
			if(serial == 0)
				System.out.println(a);
			g.setColor(a);
			//System.out.println(a);
			g.fillRect(x,y,getWidth(),getHeight());
		}
	}
	
	@Override
	public void highlight() {
		highlighted=true;
	}

	@Override
	public void setNewColor(Color color) {
//		a=color;
		if(serial == 0)
		System.out.println(a);
		
	}

	@Override
	public void dim() {
		highlighted=false;

	}

}
