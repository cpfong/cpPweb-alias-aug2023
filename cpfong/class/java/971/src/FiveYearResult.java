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
		double am, rate, tot;
		String st;

		st = JOptionPane.showInputDialog("初始投資金:"); am=Double.parseDouble(st);
		tot  = calRes(am , 1.5);
		tot  = calRes(tot, 1.5);
		JOptionPane.showMessageDialog(null, "初始投資金" +  st + "投資\n總金額為 " + tot);
	}

	private double calRes(double a, double interest){
		a = a * (1 + interest/100);
		return (a);
	}
}
