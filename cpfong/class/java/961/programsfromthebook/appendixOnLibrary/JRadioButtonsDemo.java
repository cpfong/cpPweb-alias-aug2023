
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonsDemo extends JFrame implements ItemListener {

    private JRadioButton red, yellow, blue;
    private ButtonGroup buttonGroup;  // note: no J

    private JTextField textField;

    public static void main(String[] args) {
        JRadioButtonsDemo frame = new JRadioButtonsDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        buttonGroup = new ButtonGroup();

        red = new JRadioButton("red", true);
        buttonGroup.add(red);
        window.add(red);
        red.addItemListener(this);

        yellow = new JRadioButton("yellow", false);
        buttonGroup.add(yellow);
        window.add(yellow);
        yellow.addItemListener(this);

        blue = new JRadioButton("blue", false);
        buttonGroup.add(blue);
        window.add(blue);
        blue.addItemListener(this);

        textField = new JTextField(8);
        window.add(textField);
    }

    public void itemStateChanged(ItemEvent event) {
        if (event.getSource() == red) {
            textField.setText("red selected");
        } 
        if (event.getSource() == yellow) {
            textField.setText("yellow selected");
        }   
        if (event.getSource() == blue) {
            textField.setText("blue selected");
        }      
    }
}
