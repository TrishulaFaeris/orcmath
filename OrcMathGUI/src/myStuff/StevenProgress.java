package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Component;

public class StevenProgress extends Component implements ProgressInterfaceKevin {

	private int round;
	private boolean game;
	private int seq;
	private int x;
	private int y;
	
	public StevenProgress(int x, int y, int w, int h) {
		super(x, y, w, h);
		game=true;
		round=1;
		seq=1;
		this.x=x;
		this.y=y;
	}

	@Override
	public void gameOver() {
		game=false;
		update();

	}

	@Override
	public void setRound(int a) {
		round=a;
		update();

	}

	@Override
	public void setSequenceSize(int a) {
		seq=a;
		update();

	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		if(game) {
			g.drawString(""+round, x, y);
			g.drawString(""+seq, x, y);
		}else {
			g.drawString("Game over", x, y);
		}

	}

}
