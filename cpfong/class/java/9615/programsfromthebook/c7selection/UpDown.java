import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpDown extends JFrame implements ActionListener {

    private JButton upButton, downButton;
    private JPanel panel;

    private ImageIcon image;

    private int x = 0, y = 100;

    public static void main(String[] args) {
        UpDown demo = new UpDown ();
        demo.setSize(100,100);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        upButton = new JButton("up");
        window.add(upButton);
        upButton.addActionListener(this);

        downButton = new JButton("down");
        window.add(downButton);
        downButton.addActionListener(this);

        image = new ImageIcon("c:\\happy.jpg");
     }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        paper.clearRect(0, 0, 100, 200);
        Object source = event.getSource();
        if (source == upButton) {
            y = y - 20;
            image.paintIcon(this, paper, x, y);
        }
        else {
            y = y + 20;
            image.paintIcon(this, paper, x, y);
        }
    }
}