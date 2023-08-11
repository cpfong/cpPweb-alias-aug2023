import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class menu_test extends JFrame{

	private JMenuItem ai;
	private JMenuItem ei;

	public menu_test(){

		MyHandler h = new MyHandler();

		JMenuBar mb = new JMenuBar()   ; setJMenuBar(mb);
		JMenu    fm = new JMenu("File"); mb.add(fm); fm.setMnemonic('F');
		ai = new JMenuItem("About..."); fm.add(ai); ai.addActionListener(h);
		ei = new JMenuItem("Exit"); fm.add(ei); ei.addActionListener(h);
		
		setSize(200,100); show();
	}

	private class MyHandler implements ActionListener{
		public void actionPerformed( ActionEvent e ){
			if (e.getSource() == ai) { System.out.println("about"); }
			else { System.exit(0); }
		}
	}

	public static void main(String args[]){
		menu_test t = new menu_test();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
