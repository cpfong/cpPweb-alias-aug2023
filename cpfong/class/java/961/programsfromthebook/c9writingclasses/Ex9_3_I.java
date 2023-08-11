import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 

public class Ex9_3_I extends JFrame implements ActionListener {

    private JTextField a, s;
    private JButton w,d;
    private Ex9_3 account;

    public static void main(String[] args) {
        Ex9_3_I demo = new Ex9_3_I();
        demo.setSize(200,300);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        a = new JTextField(12);window.add(a);
        s = new JTextField(12);window.add(s);

        w=new JButton("withdraw");w.addActionListener(this);window.add(w);
        d=new JButton("deposit ");d.addActionListener(this);window.add(d);
	account = new Ex9_3();
    }

    public void actionPerformed(ActionEvent e) {
	int t;
	String ss;

        if (e.getSource() == w){
        	ss = a.getText();
        	account.withdraw(Integer.parseInt(ss));
	}
	else {
        	ss = a.getText();
        	account.deposit(Integer.parseInt(ss));
	}

	t = account.getCurrentBalance();
	if (t >= 0) {
		ss = "Balance = " + t + " OK";
	}
	else {
		ss = "Balance = " + t + " Minus";
	}
	s.setText(ss);
    }
}
