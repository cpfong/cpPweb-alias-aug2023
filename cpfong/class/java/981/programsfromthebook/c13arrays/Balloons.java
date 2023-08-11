
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Balloons extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    private Balloon[] party = new Balloon[10];

    public static void main(String[] args) {
        Balloons frame = new Balloons();
        frame.setSize(400,250);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("draw");
        window.add(button);
        button.addActionListener(this);
        party[0] = new Balloon(10, 10, 50);
        party[1] = new Balloon(50, 50, 100);
        party[2] = new Balloon(100, 100, 200);

    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        displayBalloons(paper);
    }

    private void displayBalloons(Graphics paper) {
        for (int b = 0; b <= 2; b++) {
            party[b].display(paper);
        } 
    }

    private void changeSize() {
        for (int b = 0; b <= 2; b++) {
            party[b].changeSize(20);
        }
    }
}
