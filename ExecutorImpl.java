/**
 * PiJ - Day 18
 * Exercise 3 - Responsive UI that degrades gracefully
 * @author ocouls01
 */

import java.util.concurrent.*;
import java.util.Queue;
import java.util.LinkedList;

public class ExecutorImpl implements Executor {
	private Queue<Runnable> tasks = new LinkedList<Runnable>();
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
		if((active = tasks.remove()) != null) {
			ex.execute(active);
		}
	}
	
	public int getMaxPendingTime() {
		return tasks.size() * 1000;
	}
}