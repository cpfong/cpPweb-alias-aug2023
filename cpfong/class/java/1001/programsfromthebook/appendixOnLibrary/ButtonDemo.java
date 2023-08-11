
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo extends JFrame implements ActionListener {

    private JButton button;
    private JTextField textField;

    public static void main(String[] args) {
        ButtonDemo frame = new ButtonDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);

        textField = new JTextField(10);
        window.add(textField);
    }

    public void actionPerformed(ActionEvent event) {
        textField.setText("button clicked");
    }
}
