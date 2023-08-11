import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 

public class Max extends JFrame implements ChangeListener, ActionListener {

    private JSlider slider;
    private JTextField textField;
    private JButton button;

    private int max = 0;

    public static void main(String[] args) {
        Max demo = new Max();
        demo.setSize(200,300);
        demo.createGUI();
        demo.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        slider = new JSlider(JSlider.VERTICAL, 0, 100, 0);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.addChangeListener(this);
        window.add(slider);

        textField = new JTextField(12);
        window.add(textField);

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
        display();
    }

    public void actionPerformed(ActionEvent event) {
        textField.setText("");
        max = 0;
    }

    private void display() {
        textField.setText("maximum value is " + max);
    }
}
