import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Gambling extends JFrame implements ActionListener {

    private JButton button;
    private JTextField valuesTextField, resultTextField;
    private Random random;

    public static void main(String[] args) {
        Gambling demo = new Gambling();
        demo.setSize(200,150);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("throw");
        window.add(button);
        button.addActionListener(this);

        valuesTextField = new JTextField(14);
        window.add(valuesTextField);

        resultTextField = new JTextField(12);
        window.add(resultTextField);

        random = new Random();
    }

    public void actionPerformed(ActionEvent event) {
        int die1, die2;

        die1 = random.nextInt(6) + 1;
        die2 = random.nextInt(6) + 1;

        valuesTextField.setText("the die values are "
            + Integer.toString(die1) + " and "
            + Integer.toString(die2));
        if (die1 == die2) {
            resultTextField.setText("dice equal - a win");
        }
        else {
            resultTextField.setText("dice not equal - lose");
        }
    }
}
