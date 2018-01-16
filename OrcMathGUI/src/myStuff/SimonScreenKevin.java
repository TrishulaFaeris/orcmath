package myStuff;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenKevin extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2028781790220195673L;
	
	private TextLabel label;
	private ButtonInterfaceKevin[] buttons;
	private ProgressInterfaceKevin progress;
	private ArrayList<MoveInterfaceKevin> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenKevin(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();

	}

	private void nextRound() {
		acceptingInput=false;
		roundNumber++;	
		sequence.add(randomMove());
		
		//step 4
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		
		changeText("Simon's turn");
		playSequence();
		changeText("Your Turn.");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceKevin b=null;
		for(int i=0;i<sequence.size();i++) {
			if(b!=null) {
				b.dim();
			}
			b=sequence.get(i).getButton();
			b.highlight();
			int sleepTime=1000/roundNumber;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.dim();
		
	}

	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label.setText("");
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceKevin b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(230,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceKevin>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceKevin randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttons.length);
	    }
	    lastSelectedButton=bIndex;
	    return getMove(bIndex);
	}

	private MoveInterfaceKevin getMove(int bIndex) {
		// TODO Auto-generated method stub
		return new StevenMove(buttons[bIndex]);
	}

	private ProgressInterfaceKevin getProgress() {
		// TODO Auto-generated method stub
		return new StevenProgress(230,330,300,40);
	}

	private void addButtons() {
		int numberOfButtons = 4;
		buttons = new ButtonInterfaceKevin[numberOfButtons];
		Color[] colors = new Color[numberOfButtons];
		colors[0] = Color.pink;
		colors[1] = Color.red;
		colors[2] = Color.blue;
		colors[3] = Color.green;
		
		for (int i = 0; i < numberOfButtons; i++)
		{
			final ButtonInterfaceKevin b = getAButton();
			buttons[i] = b;
			b.setColor(colors[i]);
			b.setX(100);
			b.setY((i*100)+100);
			b.setAction(new Action() {
				
				@Override
				public void act() {
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								b.dim();
							}
							

						});
						blink.start();
						if(b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}else {
							progress.gameOver();
						}

						if(sequenceIndex == sequence.size()){ 
						    Thread nextRound = new Thread(SimonScreenKevin.this); 
						    nextRound.start(); 
						}
					}
					
				}
			});
		}
	}

	private ButtonInterfaceKevin getAButton() {
		return new StevenButton(10,10,40,40,"",null);
	}


	

}
