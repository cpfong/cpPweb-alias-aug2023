import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelImage extends JFrame {

    private JLabel label;
    private ImageIcon image = new ImageIcon("coffee.gif");

    public static void main(String[] args) {
        LabelImage frame = new LabelImage();
        frame.setSize(340,340);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        label = new JLabel(image);
        window.add(label);
    }
}

