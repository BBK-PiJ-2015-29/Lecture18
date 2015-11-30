/**
 * PiJ - Day 18
 * Exercise 3.2 - Responsive UI that degrades gracefully
 * @author ocouls01
 */

public class TimedTask implements Runnable {
	private int sleepTime;
	
	public TimedTask(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	
	public void run() {
		Thread.sleep(sleepTime);
	}
	
	public int getSleepTime() {
		return sleepTime;
	}
}