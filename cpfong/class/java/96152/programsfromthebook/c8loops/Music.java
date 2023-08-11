
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Music extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        Music demo = new Music();
        demo.setSize(400,300);
        demo.createGUI();
        demo.setVisible(true);
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 100));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }


    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        int y;
        paper.setColor(Color.white);
        paper.fillRect(0, 0, 150, 100);

        y = 10;
        for (int staves = 1; staves <= 8; staves++) {
            for (int lines = 1; lines <= 5; lines++) {
                paper.setColor(Color.black);

                paper.drawLine(10, y, 90, y);
                y = y + 2;
            }
            y = y + 5;
        }

    }
}
