import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*; 

public class Quiz151 extends JFrame implements ActionListener{
    private JPanel panel;
    private JButton button1, button2;
    private JLabel gapLabel;

    private int ex=80, ey=280;
    private int ypos=280;

    public static void main (String[] args) {
        Quiz151 frame = new Quiz151();
        frame.setSize(200, 400);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(ex, ey));
        panel.setBackground(Color.white);
        window.add(panel);

        gapLabel = new JLabel("Elevator");window.add(gapLabel);

	button1 = new JButton("¤Wª@");window.add(button1);button1.addActionListener(this);
	button2 = new JButton("¤U­°");window.add(button2);button2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int x, y, size;
	Object o=event.getSource();

        Graphics paper = panel.getGraphics();
	
	if (o == button1){
		if (ypos < 0) { ypos=0; }
		else { ypos -= 20; }
	}
	else {
		if (ypos > ey) { ypos=ey-5; }
		else { ypos += 20; }
	}
	paper.setColor(Color.white);
	paper.fillRect(0,0,ex,ey);

	paper.setColor(Color.red);
	paper.fillRect(50,ypos,10,10);
    }
}
