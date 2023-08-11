
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Voting extends JFrame implements ActionListener {

    private JButton button;
    private JTextField textField, result;

    public static void main(String[] args) {
        Voting frame = new Voting();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textField = new JTextField(4);
        window.add(textField);

        button = new JButton("check");
        window.add(button);
        button.addActionListener(this);

        result = new JTextField(10);
        window.add(result);
    }

    public void actionPerformed(ActionEvent event) {
        int age;
        age = Integer.parseInt(textField.getText());
        if (age >= 18) {
            result.setText("you can vote");
        }
        else {
            result.setText("you cannot vote");
        }
    }
}
