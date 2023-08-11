import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class box_test extends JFrame{

	JTextArea t ;
	JTextArea tt;
	JButton copy;
	
	public box_test(){

		String s="this is a test";
		Box b = Box.createHorizontalBox();
		Container c = getContentPane();
		MyHandler h = new MyHandler();

		t = new JTextArea(s, 10,15); b.add(t);b.add(new JScrollPane(t));
		copy = new JButton("Copy >>"); b.add(copy); copy.addActionListener(h);
		tt = new JTextArea(10,15)  ; b.add(tt); tt.setEditable(false);

		c.add(b);setSize(200,100); show();
	}

	private class MyHandler implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			tt.setText(t.getSelectedText());
		}
	}

	public static void main(String args[]){
		box_test t = new box_test();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
