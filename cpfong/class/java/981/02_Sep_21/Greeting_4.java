import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Greeting_4 extends JFrame{
	public static void main(String[] args){
		Greeting_4 f = new Greeting_4();
		f.createGUI();
		f.setSize(300,200);
		f.setVisible(true);
	} // end main

	private void createGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container w = getContentPane();
		w.setLayout(new FlowLayout());
		JTextField t = new JTextField("Hello");
		JLabel l = new JLabel("input name");
		w.add(l); w.add(t);
	} // end createGUI
}
