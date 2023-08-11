import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz3 extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		Quiz3 frame=new Quiz3();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(Quiz3 mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("按我計算總合");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		int i=0,sum=0,c,ii;
		String t;

		t=JOptionPane.showInputDialog("要多少個數?"); c=Integer.parseInt(t);
		while (i < c){
			t=JOptionPane.showInputDialog("請輸入:"); ii=Integer.parseInt(t);
			sum = sum + ii;
			i = i + 1;
		}
		JOptionPane.showMessageDialog(null, "你輸入了 " + c + " 個數的總合為 " + sum);
	}
}
