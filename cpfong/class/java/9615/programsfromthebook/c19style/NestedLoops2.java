//latest template  30 oct
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NestedLoops2 extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;
    Graphics paper;

    public static void main(String[] args) {
        NestedLoops2 frame = new NestedLoops2();
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

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        paper = panel.getGraphics();
        drawApartments(3,4);
    }

    private void drawApartments(int floors, int apartments) {
        int yCoord = 10;
        for (int count = 0; count < floors; count++) {
            drawFloor(yCoord, apartments);
            yCoord = yCoord + 25;
        }
    }

    private void drawFloor(int yCoord, int apartments) {
        int xCoord = 10;
        for (int count = 0; count < apartments; count++) {
            paper.drawRect(xCoord, yCoord, 20, 20);
            xCoord = xCoord + 25;
        }
    }

}
