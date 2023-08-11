
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prison extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        Prison demo = new Prison();
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
        int x, counter, numberOfBars;
        numberOfBars = 5;
        x = 10;
        counter = 1;
        while (counter <= numberOfBars)  {
            paper.drawLine(x, 10, x, 100);
            x = x + 15;
            counter++;
        }
    }
}
