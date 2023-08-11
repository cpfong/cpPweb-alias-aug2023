import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawExample extends JFrame implements ActionListener {
	public static void main(String args[]){
		DrawExample d = new DrawExample();

		d.createGUI();d.setSize(200,300);d.setVisible(true);
	} // end main

	private void createGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();c.setLayout(new FlowLayout());
	}// end createGUI

	public void actionPerformed(ActionEvent e){
	}// end actionPerformed
} // end DrawExample
