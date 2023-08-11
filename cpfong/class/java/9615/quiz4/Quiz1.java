import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 

public class Quiz1 extends JFrame implements ChangeListener, ActionListener {

	private JSlider slider;
	private JTextField h,l,c;
	private JButton b;
	private JLabel lh, ll, lc;
	private int init = 50;

	Temperature temp;

	public static void main(String[] args) {
		Quiz1 demo = new Quiz1 ();
		demo.setSize(400,300);
		demo.createGUI();
		demo.setVisible(true);
	}

	private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container w = getContentPane();
		w.setLayout(new FlowLayout());

		slider = new JSlider(JSlider.VERTICAL, 0, init*2, init);
		slider.addChangeListener(this);
		w.add(slider);

		temp=new Temperature();
		lc = new JLabel("瞷放") ;w.add(lc); c = new JTextField(""+init , 5);w.add(c);
		lh = new JLabel("程蔼放") ;w.add(lh); h = new JTextField(""+temp.getHighestValue(), 5);w.add(h);
		ll = new JLabel("程放") ;w.add(ll); l = new JTextField(""+temp.getLowestValue() , 5);w.add(l);
		b  = new JButton("竚い");b.addActionListener(this);w.add(b);
	}

	public void stateChanged(ChangeEvent e) {
		int t=0;
		t = slider.getValue();
		c.setText("" + t);

		if (t>temp.getHighestValue()){ temp.setNewValue(t, 1); h.setText(""+temp.getHighestValue()); }
		if (t<temp.getLowestValue ()){ temp.setNewValue(t, 0); l.setText(""+temp.getLowestValue ()); }
	}

	public void actionPerformed(ActionEvent e){
		temp.setNewValue(init,1);
		temp.setNewValue(init,0);
		slider.setValue(init);
		c.setText("" + init);
		h.setText(""+temp.getHighestValue());
		l.setText(""+temp.getLowestValue ());
	}
} 
