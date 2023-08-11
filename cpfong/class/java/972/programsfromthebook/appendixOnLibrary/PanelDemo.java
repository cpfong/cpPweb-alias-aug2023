// Clicking on the button
// causes a line to be drawn in the panel.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelDemo extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        PanelDemo frame = new PanelDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        paper.drawLine(0,0,111,113);
    }
}
