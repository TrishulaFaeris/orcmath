package myStuff;

import java.awt.Color;

import guiTeacher.components.*;
import guiTeacher.interfaces.*;

public interface ButtonInterfaceKevin extends Clickable{

	void highlight();

	void setNewColor(Color color);

	void dim();

}

