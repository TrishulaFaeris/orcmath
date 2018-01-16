package myStuff;

public class StevenMove implements MoveInterfaceKevin {

	private ButtonInterfaceKevin button;
	
	public StevenMove(ButtonInterfaceKevin button) {
		this.button=button;
	}


	@Override
	public ButtonInterfaceKevin getButton() {
		return button;
	}

}
