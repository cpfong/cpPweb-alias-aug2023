import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class UseBalloon extends JFrame implements ActionListener, ChangeListener {

    private JSlider slider;
    private JTextField textfield;
    private JButton upButton, downButton;
    private JPanel panel;

    private Balloon balloon;

    public static void main(String[] args) {
        UseBalloon frame = new UseBalloon();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        slider = new Slider();
        slider.addChangeListener(this);

        window.add(slider);

        textField = new JTextField(3);
        window.add(textField);

        upButton = new JButton("up");
        window.add(upButton);
        upButton.addActionListener(this);

        downButton = new JButton("down");
        window.add(downButton );
        downButton .addActionListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        balloon = new Balloon();
draw();
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == upButton) {
            balloon.moveUp();
        }
        else {
            balloon.moveDown();
        }
draw();
    }

    public void stateChanged(ChangeEvent event) {
int radius = slider.getValue();
        textField.setText("radius = " + radius);
balloon.setRadius(radius);
    }

private void draw() {
    balloon.display(panel);
}


}


public class Balloon {

    private int x = 50;
    private int y = 50;
    private int radius = 20;
    private int yStep = 20;

    public void moveUp() {
        y = y - yStep;
    }

    public void moveDown() {
        y = y + yStep;
    }

    public void display(JPanel panel) {
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.white);
        drawArea.drawRect(0, 0, panel.getHeight(), panel.getWidth());
        paper.setColor(Color.black);
        paper.drawOval(x, y, radius * 2, radius * 2);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int newRadius) {
        radius = newRadius;
    }
}
