import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActTemplate extends Applet implements ActionListener {
	public void init(){
		//JButton b = new JButton("press");
		Button b = new Button("press");
		add(b);
		b.addActionListener(this);
	}
	//public void actionPerformed(){;}
	public void actionPerformed(ActionEvent e) {;}
}
