package test;

import guiTeacher.GUIApplication;

public class testGui extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private testscreen test;

	public static void main(String[] args) {
		testGui s = new testGui(960,540);//set the size
		Thread runner = new Thread(s); //set the thread
		runner.start();//allow the start
	}
	public testGui(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		test = new testscreen(getWidth(),getHeight()); //create the screen
		setScreen(test); //see the screen
		
	}

}
