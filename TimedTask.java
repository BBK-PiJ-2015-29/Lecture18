/**
 * PiJ - Day 18
 * Exercise 3.2 - Responsive UI that degrades gracefully
 * @author ocouls01
 */

public class TimedTask implements Runnable {
	private final int MAX_SLEEP = 1000;
	private int sleepTime;
	
	public TimedTask(int sleepTime) {
		if (sleepTime < MAX_SLEEP) {
			this.sleepTime = sleepTime;
		} else {
			this.sleepTime = MAX_SLEEP;
		}
	}
	
	public void run() {
		try{
			Thread.sleep(sleepTime);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public int getSleepTime() {
		return sleepTime;
	}
}