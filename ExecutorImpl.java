/**
 * PiJ - Day 18
 * Exercise 3 - Responsive UI that degrades gracefully
 * @author ocouls01
 */

import java.util.concurrent.*;
import java.util.Queue;
import java.util.ArrayDeque;

public class ExecutorImpl implements Executor {
	private Queue<Runnable> tasks = new ArrayDeque<Runnable>();
	private Executor ex;
	private Runnable active;
	
	public ExecutorImpl(Executor ex) {
		this.ex = ex;
	}
	
	public void execute(Runnable command) {
		tasks.add(new Runnable() {
			public void run() {
				try {
					command.run();
				} finally {
					scheduleNext();
				}
			}
		});
		
		if (active == null) {
			scheduleNext();
		}
		
	}
	public void scheduleNext() {
		if((active = tasks.poll()) != null) {
			ex.execute(active);
		}
	}
	
	public getMaxPendingTime() {}
}