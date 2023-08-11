
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Drunk extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;
    private JTextField textField;
    private Random random;

    private int paperWidth = 150, paperHeight = 150;

    public static void main(String[] args) {
        Drunk demo = new Drunk();
        demo.setSize(250,220);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(paperWidth, paperHeight));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("go");
        window.add(button);
        button.addActionListener(this);

        textField = new JTextField(9);
        window.add(textField);

        random = new Random();
    }


    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        int x, y, xStep, yStep, xNew, yNew, steps;
        paper.setColor(Color.white);
        paper.fillRect(0, 0,paperWidth, paperHeight);
        x = paperWidth / 2;
        y = paperHeight / 2;
        for (steps = 0; 
             x < paperWidth  && x > 0
             &&
             y < paperHeight  && y > 0;
             steps++) {
            xStep = random.nextInt(100) - 50;
            yStep = random.nextInt(100) - 50;

            xNew = x + xStep;
            yNew = y + yStep;
            paper.setColor(Color.black);
            paper.drawLine(x, y, xNew, yNew);

            x = xNew;
            y = yNew;
        }
        textField.setText("It took " + steps + " steps");
    }
}
