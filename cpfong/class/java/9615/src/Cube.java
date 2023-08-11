import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FiveYearResult extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		FiveYearResult frame=new FiveYearResult();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(FiveYearResult mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("按我計算本金利息和");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		double radius, area, vol;
		String radiusString;

		radiusString=JOptionPane.showInputDialog("初始投資金:"); radius=Double.parseDouble(radiusString);
		vol  = calVol(radius);
		JOptionPane.showMessageDialog(null, "邊長為" +  radiusString + "的立方體,\n體積為 " + vol);
	}

	private double calVol(double x){
		return (x * x * x);
	}
}
