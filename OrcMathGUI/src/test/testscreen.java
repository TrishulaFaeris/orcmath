package test;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.showCountLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class testscreen extends FullFunctionScreen {
	private int counter;
	private int startTime;
	private int gameTime;
	private Timer timer;
	private Button press;
	private showCountLabel showCount;
	private showCountLabel timerDisplay;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	public testscreen(int width, int height) {
		super(width, height);
		counter = 0;
		startTime = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//to disable a button do the "buttonname".setEnabled(boolean)
		showCount = new showCountLabel(100, 200, 100, 100, "Counter = 0"); //create score board
		timerDisplay = new showCountLabel(100,300,100,100, "Time"); //create display for timer
		timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				startTime--;
				if(startTime==0) {
					showCount.setshowCount("Go!");
					button.setshowCount("Click Me");
				}
				else if(startTime>0)
					showCount.setshowCount(""+startTime);
					
				if(startTime<=0) {
					gameSec--;
					timerPrint.setshowCount("Timer: "+gameSec);
					if(gameSec==0) {
						button.setshowCount("Done");
						button.setEnabled(false);
						timer.cancel();
					}
				}
				
			}
				
			};
				press = new Button(100, 100, 100, 100, "Press", new Action() { //create button
				
				@Override
				public void act() {
					if(startTime <= 0) {
						increaseCount(); //increase counter
						showCount.setshowCount("Counter = " +counter); //show score board as changing
					}else {
						StartTimer();
					}
					
				}

				private void StartTimer() {
					timer.schedule(task,0,1000);
					
				}
			});
			
		viewObjects.add(press);
		viewObjects.add(showCount);
		viewObjects.add(timerDisplay);
	}
	public void increaseCount() {
		counter ++;
	}
		


}
