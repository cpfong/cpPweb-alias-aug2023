import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mouse_button_demo extends JFrame{

	private String s; private int x, y;
	public mouse_button_demo(){
		
		MyHandler h = new MyHandler();		// my own handler
		addMouseListener(h);			// add to listening array

		setSize(200,100); show();
	}

	public static void main(String args[]){
		mouse_button_demo t = new mouse_button_demo();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class MyHandler extends MouseAdapter{
		public void mouseClicked (MouseEvent e){

			x = e.getX(); y = e.getY(); 	// get x and y location

			if (e.getModifiers() == InputEvent.BUTTON1_MASK){ s = "left"; }
			else if( e.getModifiers() == InputEvent.BUTTON2_MASK ) { s = "middle";}
			else if( e.getModifiers() == InputEvent.BUTTON3_MASK ) { s = "right"; }

			repaint();			// ask paint to repaint 	
		}
	}

	public void paint (Graphics g) {
		g.drawString("@" + x + "," + y + " " + s , x, y);
	}
}
