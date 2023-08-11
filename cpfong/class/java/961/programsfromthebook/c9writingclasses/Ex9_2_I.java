import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 

public class Ex9_2_I extends JFrame implements ChangeListener, ActionListener {

    private JSlider slider;
    private JTextField textField;
    private JButton button;
    private Ex9_2 temp;

    public static void main(String[] args) {
        Ex9_2_I demo = new Ex9_2_I();
        demo.setSize(200,300);
        demo.createGUI();
        demo.setVisible(true);
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
        int tem;    
        tem = slider.getValue();
        if (tem > temp.getHValue()) {
            temp.setHVal(tem);
        }
        display();
    }

    public void actionPerformed(ActionEvent event) {
        textField.setText("");
        temp.setHVal(0);
    }

    private void display() {
        textField.setText("maximum value is " + temp.getHValue());
    }
}
