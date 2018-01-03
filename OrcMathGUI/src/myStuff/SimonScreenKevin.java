package myStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenKevin extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProgressInterfaceKevin display;
	public ArrayList<MoveInterfaceKevin> list;
	public int roundNum;
	public boolean isUserCorrect;
	public TextField showRound;
	public ButtonInterfaceKevin buttons;
	
	public SimonScreenKevin(int width, int height) {
		super(width, height);
		Thread game = new Thread(this);
		game.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceKevin b: buttons) {
			viewObjects.add(b);
		
	}
	}

}

