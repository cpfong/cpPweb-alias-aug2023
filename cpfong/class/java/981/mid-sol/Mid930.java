/*
21. 利用 drawLine 來劃一個像 8 的字.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mid930 extends JFrame implements ActionListener {
	JPanel  p1;

	public static void main(String args[]){
		Mid930 d = new Mid930();
		d.createGUI();d.setSize(300,400);d.setVisible(true);
	} // end main

	private void createGUI(){
		p1 = new JPanel ();
		JButton b1 = new JButton("Draw 8");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();c.setLayout(new FlowLayout());
		p1.setPreferredSize(new Dimension(200,300)); p1.setBackground(Color.white);
		c.add(p1); c.add(b1);
		b1.addActionListener(this);
	}// end createGUI

	public void actionPerformed(ActionEvent e){
		Graphics p = p1.getGraphics();
		p.drawLine(50,50, 150, 50);
		p.drawLine(50,150,150,150);
		p.drawLine(50,250,150,250);
		p.drawLine(50,50,50,250);
		p.drawLine(150,50,150,250);
	}// end actionPerformed
} // end Mid930
