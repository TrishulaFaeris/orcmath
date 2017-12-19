package kevinPackage;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {

	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);	
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		CatalogScreen screen = new CatalogScreen(getWidth(),getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		CatalogMakerGUI sample = new CatalogMakerGUI(800,550);
		Thread go = new Thread(sample);
		go.start();
		
	}

}
