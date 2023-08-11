import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConvertFC extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		ConvertFC frame=new ConvertFC();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(ConvertFC mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("convert F --> C");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		int c, f;
		String st;

		st = JOptionPane.showInputDialog("華式溫度為"); f=Integer.parseInt(st);
		c = (f-32) * 5 / 9;
		JOptionPane.showMessageDialog(null, "華式 " +  st + "攝式為 " + c);
	}
}
