import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 

public class Max extends JFrame implements ChangeListener, ActionListener {

    private JSlider slider;
    private JTextField textField,textField2;
    private JButton button;

    private int max = 50;
    private int min = 50;

    public static void main(String[] args) {
        Max demo = new Max();
        demo.setSize(200,300);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        slider = new JSlider(JSlider.VERTICAL, 0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.addChangeListener(this);
        window.add(slider);

        textField = new JTextField(12);
        window.add(textField);

        textField2= new JTextField(12);
        window.add(textField2);

        button = new JButton("reset");
        button.addActionListener(this);
        window.add(button);
    }

    public void stateChanged(ChangeEvent e) {
        int temp;    
        temp = slider.getValue();
        if (temp > max) {
            max = temp;
        }
        if (temp < min) {
            min = temp;
        }
        display();
    }

    public void actionPerformed(ActionEvent event) {
        textField.setText("50");
        max = 50;
        textField2.setText("50");
        min = 50;
    }

    private void display() {
        textField.setText ("maximum value is " + max);
        textField2.setText("minimum value is " + min);
    }
}
