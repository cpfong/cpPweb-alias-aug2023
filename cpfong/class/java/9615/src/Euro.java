import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Euro extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		Euro frame=new Euro();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(Euro mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("Euro Change");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		int your, buying, left, r50, r20, r10, r5, r2, r1;
		String st;

		st = JOptionPane.showInputDialog("投入金額: "     ); your   = Integer.parseInt(st);
		st = JOptionPane.showInputDialog("要買東西金額為 "); buying = Integer.parseInt(st);

		left = your - buying;
		r50 = left/50; left %= 50; st  = "50 的 " + r50 + "\n";
		r20 = left/20; left %= 20; st += "20 的 " + r20 + "\n";
		r10 = left/10; left %= 10; st += "10 的 " + r10 + "\n";
		r5  = left/5 ; left %=  5; st += "5 的 "  +  r5 + "\n";
		r2  = left/2 ; left %=  2; st += "2 的 "  +  r2 + "\n";
		r1  = left               ; st += "1 的 "  +  r1 + "\n";

		JOptionPane.showMessageDialog(null, "投入" +  your + "要買 " + buying + "\n要找: " + st);
	}
}
