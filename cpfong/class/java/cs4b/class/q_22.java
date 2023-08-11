import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class q_2 extends JApplet implements ActionListener {

	JTextField a,b,res;
	JButton add,sub;

	public void init(){
		Container c = getContentPane();
		c.setLayout (new FlowLayout());

		a = new JTextField(3); c.add(a);
		b = new JTextField(3); c.add(b);
		add = new JButton("Add"); c.add(add);add.addActionListener(this);
		sub = new JButton("Sub"); c.add(sub);sub.addActionListener(this);
		res = new JTextField(3) ; res.setEditable(false); c.add(res);
	}
	public void actionPerformed(ActionEvent e){

		DecimalFormat two = new DecimalFormat( "00" );
		int cc = 0;
		int aa = Integer.parseInt(a.getText());
		int bb = Integer.parseInt(b.getText());
		String s = "";

		if (e.getSource() == add) { cc = aa + bb ; }
		else { cc = aa - bb; } 
		res.setText(two.format(cc));
	}
}
