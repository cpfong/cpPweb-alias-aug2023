import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelImage extends JFrame {

    private Container pane;
    private JLabel label;
    private ImageIcon image = new ImageIcon("hatman.gif");

    public static void main(String[] args) {
        LabelImage frame = new LabelImage();

        frame.setSize(340,340);
fram.createGUI();
        frame.show();

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = getContentPane();
        label = new JLabel(image);
        pane.add(label);
    }
}

