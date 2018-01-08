package myStuff;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.*;

public class SimonScreenKevin extends ClickableScreen implements Runnable{

	TextLabel label;                                    
	ButtonInterfaceKevin[] buttons;                        
	ProgressInterfaceKevin progress;                     
	ArrayList<MoveInterfaceKevin> move;
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;
	
	public SimonScreenKevin(int width, int height) 
	{
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
    public void run()
	{

        label.setText("");

        nextRound();

    }

	private void nextRound()
	{
		acceptingInput = false;
		roundNumber++;
		move.add(randomMove());
		
		// step 4
		progress.setRound(roundNumber);
		progress.setSequenceSize(move.size());
		
		changeText("Simon's Turn.");
		playSequence();
		changeText("Your Turn.");
		
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void changeText(String string) 
	{
		label.setText(string);
		try 
		{	
            Thread.sleep(1000);
        }
		catch (InterruptedException e) 
		{
            e.printStackTrace();
        }	
		label.setText("");
		
		
	}

	private void playSequence() 
	{
		ButtonInterfaceKevin b = null;
		
		for (int i = 0; i < move.size(); i++)
		{
			if (b != null)
			{
				b.dim();			
			}
			b = move.get(i).getButton();
			b.highlight();
			int sleepTime=10000/roundNumber;
			try 
			{	
	            Thread.sleep(sleepTime);
	        }
			catch (InterruptedException e) 
			{
	            e.printStackTrace();
	        }	
		}
		
		b.dim();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects)
	{
		addButtons();
		for(ButtonInterfaceKevin b: buttons)
		{ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		move = new ArrayList<MoveInterfaceKevin>();
		//add 2 moves to start
		lastSelectedButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceKevin randomMove() 
	{
		int bIndex = (int)(Math.random()*buttons.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttons.length);
	    }
	    return getMove(bIndex);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/

	private ProgressInterfaceKevin getProgress() 
	{
		return new StevenProgress(0,0,30,30);
	}

	private void addButtons() 
	{
			int numberOfButtons = 4;
			buttons = new ButtonInterfaceKevin[numberOfButtons];
			Color[] colors = new Color[numberOfButtons];
			colors[0] = Color.black;
			colors[1] = Color.red;
			colors[2] = Color.blue;
			colors[3] = Color.green;
			
			for (int i = 0; i < numberOfButtons; i++)
			{
				final ButtonInterfaceKevin b = getAButton();
				buttons[i] = b;
				b.setColor(colors[i]);
				b.setX(100);
				b.setY(i*100);
				
				b.setAction(new Action()
				{
					public void act(){
						if(acceptingInput)
						{
							Thread blink = new Thread(new Runnable()
							{
							    public void run(){
	
							        b.highlight();
	
							        try {
	
							            Thread.sleep(800);
	
							        } catch (InterruptedException e) {
	
							           
	
							            e.printStackTrace();
	
							        }
	
							        b.dim();
	
							    }
							});
							blink.start();
							
							if (b == move.get(sequenceIndex).getButton())
							{
								sequenceIndex++;
							}
							else
							{
								progress.gameOver();
							}
							
							if(sequenceIndex == move.size()){
							    Thread nextRound = new Thread(SimonScreenKevin.this);
							    nextRound.start();
							}
					}
				}
			});
		}
	}
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	private ButtonInterfaceKevin getAButton() 
	{
		return new StevenButton(40,40,20,20,"",null);
	}

	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceKevin getMove(int bIndex)
	{
	    return new StevenMove((StevenButton) buttons[bIndex]);
	}


}