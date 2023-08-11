/*
13. 繪製一長方形, 這個長方形的面積必須佔 panel 的一半
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mid9152 extends JFrame implements ActionListener {
	JPanel  p1;

	public static void main(String args[]){
		Mid9152 d = new Mid9152();

		d.createGUI();d.setSize(400,300);d.setVisible(true);
	} // end main

	private void createGUI(){
		p1 = new JPanel ();
		JButton b1 = new JButton("Draw Half Square");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();c.setLayout(new FlowLayout());
		p1.setPreferredSize(new Dimension(300,200)); p1.setBackground(Color.white);
		c.add(p1); c.add(b1);
		b1.addActionListener(this);
	}// end createGUI

	public void actionPerformed(ActionEvent e){
		Graphics p = p1.getGraphics();
		p.drawLine(0,0, 150,0);
		p.drawLine(0,0, 0,200);
		p.drawLine(0,199, 150,199);
		p.drawLine(150,200, 150,0);
	}// end actionPerformed

} // end Mid9152
