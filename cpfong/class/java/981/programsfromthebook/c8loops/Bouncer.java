import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bouncer extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        Bouncer frame = new Bouncer();
        frame.setSize(200,150);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("go");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        Ball ball = new Ball(paper);
        ball.animate();
    }
}

class Ball {

    private Graphics paper;
    private int x = 7, xChange = 7;
    private int y = 0, yChange = 2;
    private int diameter = 10;
    private int width = 100, height = 100;

    public Ball(Graphics graphics) {
        paper = graphics;
    }

    public void animate() {
        for (int n = 1; n < 100; n++) {
            move();
            test();
            draw(); 
            delay();
            delete(); 
        }
    }

    private void move() {
        x = x + xChange;
        y = y + yChange;
    }

    private void test() {
        if (x <= 0 || x  >= width) 
            xChange = -xChange;
       
        if (y <= 0 || y >= height)
            yChange = -yChange;
       }

    private void delay() {
        try {
            Thread.sleep(50);
        }
        catch (InterruptedException e) {
            return;
        }
    }

    private void draw() {
        paper.setColor(Color.red);
        paper.fillOval(x, y, diameter, diameter);
    }

    private void delete() {
        paper.setColor(Color.white);
        paper.fillOval (x, y, diameter, diameter);
    }
}

