
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Apartments extends JFrame implements ChangeListener {

    private JSlider slider1, slider2;
    private JPanel panel;

    public static void main(String[] args) {
        Apartments demo = new Apartments();
        demo.setSize(400,300);
        demo.createGUI();
        demo.show();
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        slider1 = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        window.add(slider1);
        slider1.addChangeListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        slider2 = new JSlider(JSlider.VERTICAL, 1, 10,1);
        window.add(slider2);
        slider2.addChangeListener(this);
    }


    public void stateChanged(ChangeEvent e) {
        Graphics paper = panel.getGraphics();
        int floors, apartments;
        int x, y;
        y = 10;
        paper.setColor(Color.white);
        paper.fillRect(0, 0, 200, 200);

        apartments = slider1.getValue();
        floors = slider2.getValue();
        for (int floor = 0; floor <= floors; floor++) {
            x = 10;
            for (int count = 0; count <= apartments; count++) {
                paper.setColor(Color.black);
                paper.drawRect(x, y, 10, 5);
                x = x + 15;
            }
            y = y + 15;
        }

    }
}
