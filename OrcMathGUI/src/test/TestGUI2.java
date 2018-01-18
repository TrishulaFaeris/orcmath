package test;

import guiTeacher.GUIApplication;

public class TestGUI2 extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TestScreen2 screen;
	
	public static void main(String[] args) {
		TestGUI2 newTest2 = new TestGUI2(960,540);
		Thread runner = new Thread(newTest2);
		runner.start();

	}
	public TestGUI2(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen = new TestScreen2(getWidth(),getHeight());
		setScreen(screen);

	}



}
