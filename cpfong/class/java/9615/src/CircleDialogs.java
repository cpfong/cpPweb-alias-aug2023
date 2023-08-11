import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CircleDialogs extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		CircleDialogs frame=new CircleDialogs();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(CircleDialogs mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("按我計算圓的面積和體積");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		double radius, area, vol;
		String radiusString;

		radiusString=JOptionPane.showInputDialog("半徑:"); radius=Double.parseDouble(radiusString);
		area = Math.PI * radius * radius;
		vol  = (4 * Math.PI)/3 * radius * radius * radius;
		JOptionPane.showMessageDialog(null, "半徑為" +  radiusString + "的圓,\n面積為 " + area + "\n體積 = " + vol);
	}
}
