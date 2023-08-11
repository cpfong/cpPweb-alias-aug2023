
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Lottery extends JFrame implements ActionListener {

    private JButton button;
    private JTextField textField;
    private Random random;

    public static void main(String[] args) {
        Lottery demo = new Lottery();
        demo.setSize(400,50);
        demo.createGUI();
        demo.show();
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textField = new JTextField(20);
        window.add(textField);

        button = new JButton("go");
        window.add(button);
        button.addActionListener(this);

        random = new Random();
    }

    public void actionPerformed(ActionEvent event) {
        int number1, number2;

        number1 = random.nextInt(10) + 1;
        do {
            number2 = random.nextInt(10) + 1;
        }
        while (number1 == number2);
        textField.setText("the numbers are "
            + Integer.toString(number1) + " and "
            + Integer.toString(number2));
    }
}

