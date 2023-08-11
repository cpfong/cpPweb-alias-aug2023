//latest template  30 oct
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NestedLoops1 extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;
    Graphics paper;

    public static void main(String[] args) {
        NestedLoops1 frame = new NestedLoops1();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 150));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("draw");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        paper = panel.getGraphics();
        drawApartments(3,4);
    }

    private void drawApartments(int floors, int apartments) {

        int xCoord, yCoord;

        yCoord = 10;
        for (int floor = 0; floor < floors; floor++) {
            xCoord = 10;
            for (int count = 0; count < apartments; count++) {
                paper.drawRect(xCoord, yCoord, 20, 20);
                xCoord = xCoord + 25;
            }
            yCoord = yCoord + 25;
        }
    }

}
