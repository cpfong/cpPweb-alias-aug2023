import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Scribbler extends JFrame implements MouseMotionListener {

    private JTextField textField;
    private JPanel panel;

    int oldX = 50, oldY = 50;

    public static void main(String[] args) {
        Scribbler frame = new Scribbler();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.white);
        window.add(panel);
        panel.addMouseMotionListener(this);

        textField = new JTextField(8);
        window.add(textField);
    }

    public void mouseDragged(MouseEvent event) {
        int newX = event.getX();
        int newY = event.getY();
        Graphics paper = panel.getGraphics();
        paper.drawLine(oldX, oldY, newX, newY);

        oldX = newX;
        oldY = newY;

        textField.setText("x = " + Integer.toString(event.getX())
            + " y = " + Integer.toString(event.getY()));
    }

    public void mouseMoved(MouseEvent event) {
        int newX = event.getX();
        int newY = event.getY();
        oldX = newX;
        oldY = newY;
    }
}
