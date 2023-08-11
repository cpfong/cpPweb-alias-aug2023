/*
22.  RandomLines
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RandomLines extends JFrame implements ActionListener {
	JPanel  p1;
	private Random randomPositions = new Random();

	public static void main(String args[]){
		RandomLines d = new RandomLines();
		d.createGUI();d.setSize(300,400);d.setVisible(true);
	} // end main

	private void createGUI(){
		p1 = new JPanel ();
		JButton b1 = new JButton("Draw 9");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();c.setLayout(new FlowLayout());
		p1.setPreferredSize(new Dimension(200,300)); p1.setBackground(Color.white);
		c.add(p1); c.add(b1);
		b1.addActionListener(this);
	}// end createGUI

	public void actionPerformed(ActionEvent e){
		Graphics p = p1.getGraphics();
		int xEnd = randomPositions.nextInt(100);
		int yEnd = randomPositions.nextInt(100);
		p.drawLine(0, 0, xEnd, yEnd);
	}// end actionPerformed
} // end RandomLines
