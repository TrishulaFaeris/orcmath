package kevinPackage;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {

	private TextArea text;
	private TextField nameField;
	private TextField hairField;
	private TextField eyeField;
	private Button addButton;
	private Button saveButton;
	private Button deleteButton;
	private FileOpenButton openButton;
	private Heroine character;
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

			character = new Heroine();
			nameField = new TextField(40,40,200,30, "Name", "");
			hairField = new TextField(40,100,200,30, "Hair Color", "");
			eyeField = new TextField(40,160,200,30, "Eye Color", "");
			text = new TextArea(50,70,500,50,"This is where text goes!");
			viewObjects.add(text);
			addButton = new Button (40,80,40,40, "Add", new Action() {
				
				@Override
				public void act() {
					addClick();
					
				}
			});
			saveButton = new Button(40,120,60,40, "Save", new Action() {
				
				@Override
				public void act() {
					saveClick();
					
				}
			});
			deleteButton = new Button(40, 160, 60 , 40, "Delete", new Action() {
				
				@Override
				public void act() {
					deleteClick();
				}
			});
			openButton = new FileOpenButton(40, 160, 60, 40, null, this);
			viewObjects.add(nameField);
			viewObjects.add(hairField);
			viewObjects.add(eyeField);
			viewObjects.add(addButton);
			viewObjects.add(saveButton);
			viewObjects.add(openButton);
	}
	private void addClick() {
		
	}
	private void saveClick() {
		
	}
	private void deleteClick() {
		
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}
}
