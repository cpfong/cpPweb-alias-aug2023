import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelWithMouseDemo extends JFrame implements MouseListener {

    private JPanel panel;
    private JTextField textField;

    public static void main(String[] args) {
        PanelWithMouseDemo frame = new PanelWithMouseDemo();
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
        panel.addMouseListener(this);

        textField = new JTextField(10);
        window.add(textField);
    }

    public void mouseClicked(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        Graphics paper = panel.getGraphics();
        paper.drawOval(x, y, 5, 5);
        textField.setText(" x = " + Integer.toString(x)
            + "    y = " + Integer.toString(y));
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }
}
