package myStuff;

public class StevenMove implements MoveInterfaceKevin {

	private StevenButton button;
	
	public StevenMove(StevenButton button) {
		this.button=button;
	}

	@Override
	public MoveInterfaceKevin getMove(int bIndex) {
		return null;
	}

	@Override
	public ButtonInterfaceKevin getButton() {
		return button;
	}

}
