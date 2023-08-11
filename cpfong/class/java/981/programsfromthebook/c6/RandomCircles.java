import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;    // for Random class

public class RandomCircles extends JFrame implements ActionListener {
    private Random random = new Random();
    private JButton button;
    private JPanel panel;
    private JTextField tf;
    public static void main (String[] args) {
        RandomCircles frame = new RandomCircles();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        tf = new JTextField("mmmmmmmmmmmmmmmmmmm");
        window.add(tf);


        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int number;
        Graphics paper = panel.getGraphics();
        int max=10, min = 7;
        number = min + random.nextInt(max-min+1);
        tf.setText("r 7 to 10 " + number);

    }
}

