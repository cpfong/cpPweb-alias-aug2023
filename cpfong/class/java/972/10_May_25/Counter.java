public class Counter extends Thread {
	public int count = 1;
	public void run() {
		while (count < 50) {
			try {
				sleep(1000);
			} catch (InterruptedException e) { }
			count++;
		}
	} // end run
}//end Counter
