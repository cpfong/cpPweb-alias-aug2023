import java.awt.*;
import java.applet.*;
import java.awt.event.*;

//public class CounterTest extends java.applet.Applet implements Runnable {
public class CounterTest extends Applet implements ActionListener, Runnable {
	final static int NUM= 2;
	final static int SPACING = 23;
	int i=0;

	Counter[] counters = new Counter[NUM];
	Thread updateThread = null;
	boolean[] clicked = new boolean[NUM];
	Button[] buttons = new Button[NUM];

	// called by applet, automatically
	public void init() {
		for (i = 0; i < NUM; i++) {
			counters[i] = new Counter();
			counters[i].setPriority(2);
			clicked[i] = false;
		}

		/* Make updateThread for drawing */
		if (updateThread == null ) {
			//updateThread = new Thread(this, "Count Program");
			updateThread = new Thread("Count Program");
			updateThread.setPriority(NUM+2);
		}

		/* Make on/off buttons for threads */
		for (int i = 0; i< NUM; i++) {
			buttons[i] = new Button("ON/OFF"+i);
			add(buttons[i]);
			buttons[i].addActionListener(this);
		}
	} // end init

	public void actionPerformed(ActionEvent e) {
		if (!updateThread.isAlive()) { updateThread.start(); }
		if (e.getSource() == buttons[0]) { counters[0].start(); }
		if (e.getSource() == buttons[1]) { counters[1].start(); }
		clicked[i] = !clicked[i];
	}

	public void run() {
		while (updateThread == Thread.currentThread()) {
		// Repaint until count > 50
			for (int i = 0; i < NUM; i++) {
				if (counters[i].count <= 50){
					repaint();
					try {
						updateThread.sleep(1000);
					} catch (InterruptedException e) {}
				}  
			}   
		} // end while
	} // end run
} // end CounterTest
