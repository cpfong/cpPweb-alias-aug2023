import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class combo extends JFrame {

	private JLabel l;
	private JCheckBox b, i;
	private JComboBox co1, co2, co3;
	
	public combo(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		l = new JLabel("enter something");	c.add(l);
		b = new JCheckBox("bold");		c.add(b);
		i = new JCheckBox("italic");		c.add(i);

		CheckBoxHandler h = new CheckBoxHandler();
		b.addItemListener(h); i.addItemListener(h);

		co1 = new JComboBox(); // co2 = new JComboBox("a", "b", "c");
		String na[] = {"d", "e", "f" }; co3 = new JComboBox(na);
		co3.addItem("g");
		c.add(co1); c.add(co3); co3.addItemListener(h);
		
		setSize(200,100); show();
	}

	private class CheckBoxHandler implements ItemListener{
		private int vb, vi;
		public void itemStateChanged(ItemEvent e){

			if (e.getSource() == b || e.getSource() == i) {
				vb = b.isSelected() ? Font.BOLD : Font.PLAIN;
				vi = i.isSelected() ? Font.ITALIC : Font.PLAIN;
				l.setFont(new Font("Serif", vb+vi, 14));
			}
			if (e.getSource() == co3) {
				l.setText("idx: " + co3.getSelectedIndex() + " val: " + co3.getSelectedItem());
			}
		}
	}

	public static void main(String args[]){
		combo t = new combo();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
