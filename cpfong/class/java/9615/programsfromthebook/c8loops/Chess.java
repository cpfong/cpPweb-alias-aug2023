//latest template  24/sep
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chess extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        Chess demo = new Chess();
        demo.setSize(400,300);
        demo.createGUI();
        demo.setVisible(true);
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        int x, y, counter;
        x = 10;
        counter = 1;
        while (counter <= 9) {
            paper.drawLine(x, 10, x, 90);
            x = x + 10;
            counter++;
        }

        y = 10;
        counter = 1;
        while (counter <= 9) {
            paper.drawLine(10, y, 90, y);
            y = y + 10;
            counter++;
        }

    }
}
