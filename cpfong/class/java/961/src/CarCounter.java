import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarCounter extends JFrame implements ActionListener {
	private JButton but;
	private int carCount=0;

	public static void main(String[] args){
		int global_var=0;
		CarCounter frame=new CarCounter();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}
	private void createGUI(CarCounter mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("Car Entering");
		mw.add(but);
		but.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		carCount += 1;
		JOptionPane.showMessageDialog(null,"Cars: " + carCount);
	}
}
