import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class q_2 extends JApplet implements ActionListener{
	
	JTextField a,b,c,d;				// save 4 number
	JButton bb;

	public void init(){
		Container cc = getContentPane();		// setup layout
		cc.setLayout (new FlowLayout());

		a =  new JTextField(2);	cc.add(a);
		b =  new JTextField(2);	cc.add(b);
		c =  new JTextField(2);	cc.add(c);
		d =  new JTextField(2);	cc.add(d);
			
		bb = new JButton("OK"); cc.add(bb);	// button up
		bb.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		int r[]={0,0,0,0};
		r[0] = Integer.parseInt(a.getText());
		r[1] = Integer.parseInt(b.getText());
		r[2] = Integer.parseInt(c.getText());
		r[3] = Integer.parseInt(d.getText());
		bubble(r);
		for (int i=0; i < 4; i++) System.out.println(r[i]);
	}
	
	public void bubble(int t[]){
		for (int i=1; i<t.length; i++)
			for (int j=0; j < t.length-1; j++)
				if (t[j] > t[j+1]) swap(t,j,j+1);
	}

	public void swap(int t[], int i, int j) {
		int h;
		h = t[i];
		t[i] = t[j];
		t[j]=h;
	}
}
