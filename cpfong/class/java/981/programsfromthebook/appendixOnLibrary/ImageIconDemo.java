// This program MUST have image available in file "c:/testimage.jpg"
// A suitable file is provided in the same folder as this file
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageIconDemo extends JFrame implements ActionListener {

    private ImageIcon pic;
    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        ImageIconDemo frame = new ImageIconDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 150));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("display");
        window.add(button);
        button.addActionListener(this);

        pic = new ImageIcon("c:\\testimage.jpg");
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        int x = 10, y = 10;
        pic.paintIcon(this, paper, x, y);
    }
}
