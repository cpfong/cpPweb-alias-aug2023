import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*; 

public class Ex65_min_sec_ticking extends JFrame implements
    ActionListener, ChangeListener {

    private JPanel panel;
    private Random random;
    private javax.swing.Timer timer;
    private JSlider slider;
    private JTextField gapField;
    private JLabel gapLabel;

    private int scount=0, mcount=0;
    public static void main (String[] args) {
        Ex65_min_sec_ticking frame = new Ex65_min_sec_ticking();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );
        random = new Random();

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        gapLabel = new JLabel("Time Gap:  ");
        window.add(gapLabel);
        gapField = new JTextField(10);
        window.add(gapField);

        slider = new JSlider(JSlider.HORIZONTAL, 20, 200, 100);
        window.add(slider);
        slider.addChangeListener(this);
        gapField.setText(Integer.toString(slider.getValue()));
        timer = new javax.swing.Timer(100, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent event) {
        int x, y, size;

	scount++;
        Graphics paper = panel.getGraphics();

	if (scount%60 != 0){
		paper.setColor(Color.green);
		paper.fillRect(0,50,scount,10);
	}
	else {
		paper.setColor(Color.white);
		paper.fillRect(0,50,scount,10);
		scount=0;
		mcount++;
		paper.setColor(Color.red);
		paper.fillRect(0,100,mcount,10);
	}

    }

    public void stateChanged(ChangeEvent e) {
        int timeGap = slider.getValue();
        gapField.setText(Integer.toString(timeGap));
        timer.setDelay(timeGap);
    }
}



