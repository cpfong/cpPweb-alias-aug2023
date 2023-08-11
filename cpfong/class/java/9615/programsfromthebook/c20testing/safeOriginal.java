//latest template  30 oct
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Largest extends JFrame implements ActionListener {

    private JButton button;
    private JTextField textField, result;

private int largest;

    public static void main (String[] args) {
        Largest frame = new Largest();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        textField = new JTextField(5);
        window.add(textField);

        button = new JButton("test");
        window.add(button);
        button.addActionListener(this);

        result = new JTextField(20);
        window.add(result);
    }

    public void actionPerformed(ActionEvent event) {
        int number;
        number = Integer.parseInt(textField.getText());
        if (number > largest) {
            largest = number;
        }
        result.setText("largest so far is " + Integer.toString(largest));
    }
}
