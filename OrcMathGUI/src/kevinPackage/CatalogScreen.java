package kevinPackage;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField descriptionField;
	private TextField nameField;
	private TextField ageField;
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

			descriptionField = new TextField(40,40,200,30, "Waifu", "Husbando");
			viewObjects.add(descriptionField);
			nameField = new TextField(40,40,200,30, "AJ santa lily", "Ug who?");
			viewObjects.add(nameField);
			ageField = new TextField(40,40,200,30, "loli", "he dun exist");
			viewObjects.add(ageField);
		
	}

}
