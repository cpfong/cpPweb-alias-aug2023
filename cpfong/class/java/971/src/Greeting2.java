import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Greeting2 extends JFrame{
	private JTextField textField;
	private JButton but;

	public static void main(String[] args){
		Greeting2 frame = new Greeting2();
		frame.setSize(300,200);
		frame.createGUI(frame);
		frame.setVisible(true);
	}
	private void createGUI(Greeting2 xx){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		xx.setLayout(new FlowLayout());
		textField = new JTextField("Hello!");xx.add(textField);
		but       = new JButton   ("OK!"   );xx.add(but      );
	}
}
