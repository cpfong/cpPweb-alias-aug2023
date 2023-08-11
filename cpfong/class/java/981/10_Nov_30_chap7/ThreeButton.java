// This program uses 2 graphics files
// These are referred to in the body of the program
// They must be at the root of the C drive
// Suitable files are present in this folder

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ThreeButton extends JFrame implements ActionListener {

    private JButton Button1, Button2, Button3 ;
    private JPanel panel;   

    public static void main(String[] args) {
        ThreeButton demo = new ThreeButton();
        demo.setSize(150,180);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        Button1 = new JButton("1");
        window.add(Button1);
        Button1.addActionListener(this);

        Button2 = new JButton("2");
        window.add(Button2);
        Button2.addActionListener(this);

        Button3 = new JButton("3");
        window.add(Button3);
        Button3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        Object source = event.getSource();
/*
        if (source == happyButton) {
            happyImage.paintIcon(this, paper, 0, 0);
        }
        else {
            sadImage.paintIcon(this, paper, 0, 0);
        }
*/
    }
}
