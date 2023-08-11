import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*; 

public class Time2 extends JFrame implements
    ActionListener {

    private JPanel panel;
    private Random random;
    private javax.swing.Timer timer;
    private JSlider slider;
    private JTextField gapField;
    private JLabel gapLabel;

    private int ticks = 0;
    public static void main (String[] args) {
        Time2 frame = new Time2();
        frame.setSize(1000, 500);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 400));
        panel.setBackground(Color.white);
        window.add(panel);

        timer = new javax.swing.Timer(1000, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent event) {
        int x, y, size;

        Graphics paper = panel.getGraphics();
        paper.fillRect(0, 50, ticks%10, 50);
        if ((ticks % 10) == 0){
		paper.setColor(Color.white);
		paper.fillRect(0,50,60,50);
		paper.setColor(Color.black);
		paper.fillRect(0,300, ticks/10, 50);
	}
	ticks++;
    }
}



