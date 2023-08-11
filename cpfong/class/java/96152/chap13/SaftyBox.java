import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SaftyBox extends JFrame implements ActionListener {

    private JButton button = new JButton[10];
    private JPanel panel;
    private Random random;

    public static void main(String[] args) {
        SaftyBox demo = new SaftyBox();
        demo.setSize(400,300);
        demo.createGUI();
        demo.setVisible(true);
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.white);
        window.add(panel);

	int i=0; String s="";
	for (i=0; i< button.lenght; i++){
		s = "" + i;
  		window.add(button[i]);
		button[i].addActionListener(this);
	}
    }
/*
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.black);
        paper.fillRect(0, 0, 200, 200);
        paper.setColor(Color.white);
        for (int count = 0; count < 20; count++) {
            int x, y, radius;
            x = random.nextInt(200);
            y = random.nextInt(200);
            radius = 5;
            paper.fillOval(x, y, radius, radius);
        }
    }
*/
}
