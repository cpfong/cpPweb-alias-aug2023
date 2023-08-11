import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Quiz15 extends JFrame implements ActionListener {

    private JButton button1, button2, button3;
    private Random random;
    private JLabel l;

    public static void main(String[] args) {
        Quiz15 demo = new Quiz15();
        demo.setSize(200,100);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button1 = new JButton("剪刀");window.add(button1);button1.addActionListener(this);
        button2 = new JButton("石頭");window.add(button2);button2.addActionListener(this);
        button3 = new JButton("布"  );window.add(button3);button3.addActionListener(this);
	l = new JLabel("結果為 ..."); window.add(l);
        
        random = new Random();
    }

    public void actionPerformed(ActionEvent event) {
	Object s=event.getSource();
	int comp = random.nextInt(3);
	int me;
	String res="";

	if (s == button1) { me=0; res = winOrlost(comp,me); l.setText("你出0剪刀, " + res); }
	else if (s == button2) { me=1; res = winOrlost(comp,me); l.setText("你出1石頭, " + res); }
	else { me=2; res = winOrlost(comp,me); l.setText("你出2布, " + res); }

    }

    private String winOrlost(int c, int m){
	if (c == m) { return "電腦 " + c + " -> 平手" ; }
	else if ( (c-m) == 1 || (m-c) == 1 ) { if (c>m) {return "電腦" + c + " -> 你輸";} else {return "電腦" + c + " -> 你贏"; } }
	else { if (c>m) {return "電腦" + c + " -> 你贏"; } else {return "電腦" + c + " -> 你輸";} }
    }	
}
