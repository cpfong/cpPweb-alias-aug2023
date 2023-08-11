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

		but = new JButton("請輸入三個數");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		int i,j,k;
		double d;
		String t;

		t=JOptionPane.showInputDialog("請輸入第一個數"); i=Integer.parseInt(t);
		t=JOptionPane.showInputDialog("請輸入第二個數"); j=Integer.parseInt(t);
		t=JOptionPane.showInputDialog("請輸入第三個數"); k=Integer.parseInt(t);

		d = ((double)i+(double)j+(double)k)/3;
		JOptionPane.showMessageDialog(null, "" + i + " " + j + " " + k + " 的平均為: " + d);
	}
}
