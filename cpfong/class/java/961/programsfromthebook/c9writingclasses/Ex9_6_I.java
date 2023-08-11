import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 

public class Ex9_6_I extends JFrame implements ActionListener {
	private JTextField textField;
	private JButton button;
	private Ex9_6 ran;
	private int res=1;

	public static void main(String[] args) {
		Ex9_6_I demo = new Ex9_6_I();
		demo.setSize(200,300);
		demo.createGUI();
		demo.setVisible(true);
	}

	private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());

		textField = new JTextField(12);window.add(textField);
		button = new JButton("next");button.addActionListener(this);window.add(button);
		ran = new Ex9_6();
	}

	public void actionPerformed(ActionEvent event) {
		res = ran.getRandom(res);
		textField.setText(""+res);
	}
}
