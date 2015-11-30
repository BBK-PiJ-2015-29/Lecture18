/**
 * PiJ - Day 18
 * Exercise 2
 * @author ocouls01
 */

/*
 * The without threads mode will always return the same thing, the 10
 * runnable objects with an iteration loop running for each, sequentially
 * However, the with threads mode will return different things, the
 * runnable objects will be run in random order, and althoguh the loop
 * inside each run method will run sequentially, it will be interrupted 
 * by other threads. So for thread 4, it will always have iteration 1
 * before iteration 2, but maybe not immediately before, as other threads
 * can be processed in between. And the order in which threads are processed
 * is random.
 */
import java.util.concurrent.*;
 
public class TextLoop implements Runnable {
	public static final int COUNT = 10;
	private final String name;
	
	public TextLoop(String name) {
		this.name = name;
	}
	
	
	public void run() {
		for (int i = 0; i < COUNT; i++) {
			System.out.println("Loop:" + name + ", iteration:" + i + ".");
		}
	}
	public static void main(String args[]) {
		if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
			System.out.println("USAGE: java TextLoop <mode>");
			System.out.println(" mode 0: without threads");
			System.out.println(" mode 1: with threads");
		} else if (args[0].equals("0")) {
			for (int i = 0; i < 10; i++) {
				Runnable r = new TextLoop("Thread " + i);
				r.run();
			}
		} else {
			Executor temp = new TaskExecutor();
			Executor e = new ExecutorImpl(temp);
			//ExecutorService e = Executors.newFixedThreadPool(1000);
			
			for (int i = 0; i < 10; i++) {
				Runnable r = new TextLoop("Thread " + i);
				
				e.execute(r);
			}
			//e.shutdown();
		}
	}

}
