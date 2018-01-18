package test;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TestScreen2 extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TextLabel displayTimer;
	private TextLabel displayText;
	private Button press;
	private int startTime;
	private int gameTime;
	private int count;
	private Timer timer;
	
	public TestScreen2(int width, int height) {
		super(width, height);
		count = 0;
		startTime = 4;
		gameTime = 6;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		displayText = new TextLabel(100, 100, 100, 100, "Counter = 0"); 
		displayTimer = new TextLabel(100, 200, 100, 100, "Timer: ");
		timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				startTime --;
				if(startTime == 0) {
					displayText.setText("GO");
				}else if(startTime > 0) {
					displayTimer.setText("Time left: "+startTime);
					press.setEnabled(false);
					
				}
				if(startTime <= 0) {
					press.setEnabled(true);
					gameTime --;
					displayTimer.setText("Time left: " +gameTime);
					if(gameTime ==0) {
						press.setText("Done");
						press.setEnabled(false);
						timer.cancel();
					}
				}
				
			}
		};
		press = new Button(100, 300, 100, 100, "Press", new Action() {
			
			@Override
			public void act() {
				if(startTime <=0) {
					count++;
					displayText.setText("Counter :"+count);
				}else {
					timer.schedule(task, 0, 1000);
				}
				
			}
		});
		
		viewObjects.add(press);
		viewObjects.add(displayTimer);
		viewObjects.add(displayText);

	}

}
