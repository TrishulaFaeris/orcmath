package myStuff;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Component;

public class StevenProgress extends Component implements ProgressInterfaceKevin {

	private int round;
	private boolean game;
	private int seq;
	
	public StevenProgress(int x, int y, int w, int h) {
		super(x, y, w, h);
		game=true;
		round=1;
		seq=1;
	}

	@Override
	public void gameOver() {
		game=false;

	}

	@Override
	public void setRound(int a) {
		round=a;

	}

	@Override
	public void setSequenceSize(int a) {
		seq=a;

	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(game) {
			g.drawString(""+round, 30, 20);
			g.drawString(""+seq, 30, 40);
		}else {
			g.drawString("Game over", 30, 20);
		}

	}

}
