/**
 * PiJ Day 8 - Exe 3.3
 * @author ocouls01
 */
public class ResponsiveUI{
	
	private static final int LIMIT = 10;
	private Runnable[] taskList = new Task[LIMIT];
	
	public static void main(String[] args) {
		ResponsiveUI myRui = new ResponsiveUI();
		myRui.launch();
	}
	
	public void launch() {
		int time = 0;
		
		for (int i = 0; i < LIMIT; i++) {
			System.out.println("Enter the duration (in ms) of task " + i + ":");
			try {
				time = Integer.parseInt(System.console().readLine());
			} catch (NumberFormatException ex) {
				System.out.println("Illegal input: must be an int");
				ex.printStackTrace();
			}
			Runnable r = new Task(time, i);
			Thread t = new Thread(r);
			taskList[i] = r;
			t.start();
			String output = "Finished Task: ";
			boolean flag = false;
			for(int j = 0; j < i; j++) {
				Task temp = (Task) taskList[j];
				if (!temp.isRunning()) {
					flag = true;
					output += temp.getId() + ", ";
					temp.setRunning();
				}
			}
			if (flag) {
				System.out.println(output.substring(0, output.length()-2));
				
			}
			
		}
		
	}
}