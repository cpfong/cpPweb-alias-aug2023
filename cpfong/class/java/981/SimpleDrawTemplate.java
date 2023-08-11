import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleDrawTemplate extends JFrame implements ActionListener {
	private JButton button;
	private JPanel panel;

	public static void main(String[] args) {
		SimpleDrawTemplate demo = new SimpleDrawTemplate();
		demo.setSize(400,300);
		demo.createGUI();
		demo.setVisible(true);
	}

	private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 200));
		panel.setBackground(Color.white);
		window.add(panel);

		button = new JButton("go");
		window.add(button);
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
	}
}
