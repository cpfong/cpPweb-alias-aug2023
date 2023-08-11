import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// class
public class test extends JFrame{
	private char cc;
	private int digit, radix;

	private JLabel p1, p2;
	private JTextField in,rf;
	private JButton b1, b2, b3;

	// start of constructor
	public test(){
		super("Char Conv Method");

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		p1 = new JLabel("Enter a digit or character ");c.add(p1); 
		in = new JTextField(5);c.add(in);
		
		p2 = new JLabel("Enter a radix "); c.add(p2);
		rf = new JTextField(5); c.add(rf);

		b1 = new JButton("Conv digit to char");
		b1.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					digit = Integer.parseInt(in.getText());
					radix = Integer.parseInt(rf.getText());
					JOptionPane.showMessageDialog(null, "Conv digit to char: " + Character.forDigit(digit, radix));
				}
			}
		);
		c.add(b1);

		b3 = new JButton("Conv char to digit");
		b3.addActionListener(
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
					String s = in.getText();
					cc = s.charAt(0);
					radix = Integer.parseInt(rf.getText());
					JOptionPane.showMessageDialog(null, "Conv ch to digit: " + Character.digit(cc,radix));
				}
			}
		);
		c.add(b3);
		setSize(275,150);
		show();
	} // end constructor end test

	// main program here
	public static void main(String args[]){
		test app = new test();

		app.addWindowListener(
			new WindowAdapter(){ public void windowClosing(WindowEvent e){ System.exit(0); } }
		);
	} // end main
} // end class
