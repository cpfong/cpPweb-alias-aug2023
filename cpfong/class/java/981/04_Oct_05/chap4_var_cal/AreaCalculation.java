import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AreaCalculation extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		AreaCalculation frame=new AreaCalculation();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(AreaCalculation mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("Press me");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		int area, per, length=20, width=10;
		area=length * width;
		per = 2 * (length + width);
		JOptionPane.showMessageDialog(null, "length=20, width=10 Area is: " + area + "periphal is: " + per);
	}
}
