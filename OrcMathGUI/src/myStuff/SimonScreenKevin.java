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
	public ButtonInterfaceKevin button;
	
	public SimonScreenKevin(int width, int height) {
		super(width, height);
		Thread game = new Thread(this);
		game.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceKevin b: button) {
			viewObjects.add(b);
		}
		display = getProcess();
		
		
	}
	private ProgressInterfaceKevin getProcess() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}

