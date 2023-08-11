
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderDemo extends JFrame implements ChangeListener{

    private JSlider slider;

    private JTextField textField;

    public static void main(String[] args) {
        SliderDemo frame = new SliderDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
        slider.addChangeListener(this);
        window.add(slider);

        textField = new JTextField(10);
        window.add(textField);
    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == slider) {
            textField.setText("slider moved to " + 
                slider.getValue());
        }
    }

}
