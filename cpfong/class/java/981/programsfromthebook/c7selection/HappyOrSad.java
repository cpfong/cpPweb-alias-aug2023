// This program uses 2 graphics files
// These are referred to in the body of the program
// They must be at the root of the C drive
// Suitable files are present in this folder

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HappyOrSad extends JFrame implements ActionListener {

    private JButton happyButton, sadButton;
    private JPanel panel;

    private ImageIcon happyImage, sadImage;

    public static void main(String[] args) {
        HappyOrSad demo = new HappyOrSad();
        demo.setSize(150,180);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.white);
        window.add(panel);

        happyButton = new JButton("happy");
        window.add(happyButton);
        happyButton.addActionListener(this);

        sadButton= new JButton("sad");
        window.add(sadButton);
        sadButton.addActionListener(this);

        happyImage = new ImageIcon("c:\\happy.jpg");
        sadImage = new ImageIcon("c:\\sad.jpg");
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        Object source = event.getSource();
        if (source == happyButton) {
            happyImage.paintIcon(this, paper, 0, 0);
        }
        else {
            sadImage.paintIcon(this, paper, 0, 0);
        }
    }
}
