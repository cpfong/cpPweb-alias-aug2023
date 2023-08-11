import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class q_3 extends JApplet implements ActionListener {
	JTextField a;
	JButton b;
	JTextArea tt;
	public void init(){
		Container c = getContentPane();
		c.setLayout (new FlowLayout());

		a = new JTextField(3); c.add(a);
		b = new JButton("OK"); c.add(b);b.addActionListener(this);
		tt= new JTextArea(); c.add(tt);
	}
	public void actionPerformed(ActionEvent e){
		int arr[]={0,0,0,0,0,0,0,0,0,0}; int i, j;
		int c = Integer.parseInt(a.getText());
		String o="Element\tValue\tHistogram";

		for (i = 0; i < c; i++){
			arr[i] = (int)(Math.random() * 20);
		}

		for (i =0; i < c; i++){
			o += "\n" + i + "\t" + arr[i] + "\t";
			for (j = 0; j < arr[i]; j++) o += "*";
		}
		tt.setText(o);
	}
}
