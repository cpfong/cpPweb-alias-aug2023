import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UseBalloon extends JFrame implements ActionListener {

    private JButton growButton, moveButton;
    private JPanel panel;

    private Balloon balloon;

    public static void main(String[] args) {
        UseBalloon demo = new UseBalloon();
        demo.setSize(200,220);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 150));
        panel.setBackground(Color.white);
        window.add(panel);

        moveButton = new JButton("move");
        window.add(moveButton);
        moveButton.addActionListener(this);

        growButton = new JButton("grow");
        window.add(growButton);
	growButton.addActionListener(this);

        balloon = new Balloon();
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        if (event.getSource() == moveButton) {
            balloon.moveRight(20);
        }
        else {
            balloon.changeSize(20);

        }
        paper.setColor(Color.white);
        paper.fillRect(0, 0, 150, 150);
        balloon.display(paper);
    }
}
