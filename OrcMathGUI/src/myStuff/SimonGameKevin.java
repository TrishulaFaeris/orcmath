package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameKevin extends GUIApplication  {

	public static void main(String[] args) {
		SimonGameKevin a = new SimonGameKevin(500,800);
		Thread r = new Thread(a);
		r.start();
	}
	
	public SimonGameKevin(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		SimonScreenKevin screen = new SimonScreenKevin(getWidth(), getHeight());
		setScreen(screen);
	}
	
}