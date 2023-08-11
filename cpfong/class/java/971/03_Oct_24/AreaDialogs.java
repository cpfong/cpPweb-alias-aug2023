import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AreaDialogs extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		AreaDialogs frame=new AreaDialogs();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(AreaDialogs mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("Press me");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		int area, per, length, width;
		String lengthString, widthString;

		lengthString=JOptionPane.showInputDialog("Length:"); length=Integer.parseInt(lengthString);
		 widthString=JOptionPane.showInputDialog("Width :");  width=Integer.parseInt( widthString);

		area = length * width;
		//JOptionPane.showMessageDialog(null, "Area is: " + area);
		JOptionPane.showMessageDialog(null, "Area is: " + (Integer.parseInt(lengthString)*Integer.parseInt(widthString)));
	}
}
