import java.util.*;

public class Cal extends Thread {
	int secondes, mins, hours;

	public Cal (String s){ super(s); }

	Calendar calendar=Calendar.getInstance();

	public void run(){
		secondes = calendar.get(Calendar.SECOND);
		mins = calendar.get(Calendar.MINUTE);
		hours= calendar.get(Calendar.HOUR);
    		try {
			sleep(100);
		}
		catch (InterruptedException e){}
	}
}
