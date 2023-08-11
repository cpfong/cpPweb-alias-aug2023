import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class q_33 extends JApplet implements ActionListener {

	JTextField y,m,d,res;

	public void init(){
		Container c = getContentPane();
		c.setLayout (new FlowLayout());

		y   = new JTextField(4)  ; c.add(y); y.addActionListener(this);
		m   = new JTextField(2)  ; c.add(m); m.addActionListener(this);
		d   = new JTextField(2)  ; c.add(d); d.addActionListener(this);
		res = new JTextField(15) ; res.setEditable(false); c.add(res);
	}
	public void actionPerformed(ActionEvent e){
		res.setText(y.getText() + " ¦~ " + m.getText() + " ¤ë "  + d.getText() + " ¤é");
	}
}
