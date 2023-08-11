import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawExample extends JFrame implements ActionListener {
	JPanel  p1;

	public static void main(String args[]){
		DrawExample d = new DrawExample();

		d.createGUI();d.setSize(200,300);d.setVisible(true);
	} // end main

	private void createGUI(){
		p1 = new JPanel ();
		JButton b1 = new JButton("Draw Line");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();c.setLayout(new FlowLayout());
		p1.setPreferredSize(new Dimension(300,200)); p1.setBackground(Color.white);
		c.add(p1); c.add(b1);
		b1.addActionListener(this);
	}// end createGUI

	public void actionPerformed(ActionEvent e){
		Graphics p = p1.getGraphics();
		p.drawLine(0,0,100,100);
	}// end actionPerformed

} // end DrawExample
