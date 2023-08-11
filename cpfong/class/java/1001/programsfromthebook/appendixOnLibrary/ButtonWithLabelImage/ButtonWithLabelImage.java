// loads an image from a file and
// displays it on a label.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonWithLabelImage extends JFrame implements ActionListener {

    private JButton button;
    private JLabel label;
    private ImageIcon image = new ImageIcon("coffee.gif");

    public static void main(String[] args) {
        ButtonWithLabelImage frame = new ButtonWithLabelImage();
        frame.setSize(340,200);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("display");
        window.add(button);
        button.addActionListener(this);

        label = new JLabel();
        window.add(label);
    }

    public void actionPerformed(ActionEvent event) {
        label.setIcon(image);
    }
}

