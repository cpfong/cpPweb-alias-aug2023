import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SaftyBox extends JFrame implements ActionListener{
	private JButton[] b=new JButton[10];
	private JTextField keying;
	private JLabel res;
	private int count=0;
	private String ans="123456";

	public static void main(String args[]){
		SaftyBox s=new SaftyBox();
		s.setSize(150,300); s.createGUI(); s.setVisible(true);
	}

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

		for (int i=0; i<10; i++){ 
			b[i]=new JButton(""+i);
			window.add(b[i]);
			b[i].addActionListener(this);
		}

		keying=new JTextField(8); window.add(keying);
		res = new JLabel("input 6 digits"); window.add(res);
    }

    public void actionPerformed(ActionEvent e) {
		String s="";
		int i;
		for (i=0; i<10; i++){
			if (e.getSource() == b[i]){ count++; break; }
		}

		if (count != 6){
			s=keying.getText()+i;
			keying.setText(s);
		}
		else {
			s=keying.getText()+i;
			if (s.equals(ans)){ res.setText("Bingo"); }
			else { res.setText("wrong"); }
			keying.setText("");
			count = 0;
		}
    }
}
