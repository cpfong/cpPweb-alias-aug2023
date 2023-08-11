
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class UseBalloon extends JFrame
             implements ActionListener, ChangeListener {

    private JSlider slider;
    private JTextField textField;
    private JButton upButton, downButton;
    private JPanel panel;

    private Balloon balloon;

    public static void main(String[] args) {
        UseBalloon frame = new UseBalloon();
        frame.setSize(250,260);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        slider = new JSlider();
        slider.addChangeListener(this);

        window.add(slider);

        textField = new JTextField(7);
        window.add(textField);

        upButton = new JButton("up");
        window.add(upButton);
        upButton.addActionListener(this);

        downButton = new JButton("down");
        window.add(downButton );
        downButton.addActionListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 150));
        panel.setBackground(Color.white);
        window.add(panel);

        balloon = new Balloon();
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
        draw();
    }

    private void draw() {
        balloon.display(panel);
    }
}


