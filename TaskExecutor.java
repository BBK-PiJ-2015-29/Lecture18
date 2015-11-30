import java.util.concurrent.*;
public class TaskExecutor implements Executor {
	
	public void execute(Runnable r) {
		Thread t = new Thread(r);
		t.start();
	}
	
	
	
}