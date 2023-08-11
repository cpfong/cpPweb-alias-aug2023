
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Stars extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;
    private Random random;

    public static void main(String[] args) {
        Stars demo = new Stars();
        demo.setSize(400,300);
        demo.createGUI();
        demo.show();
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("go");
        window.add(button);
        button.addActionListener(this);

        random = new Random();
    }

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
}
