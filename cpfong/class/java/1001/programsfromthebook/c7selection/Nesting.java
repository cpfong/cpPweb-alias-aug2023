
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Nesting extends JFrame implements ActionListener {

    private JButton b1, b2, b3;
    private JTextField tf, textField;
    int age;

    public static void main(String[] args) {
        Nesting frame = new Nesting();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        tf = new JTextField(5);
        window.add(tf);

        textField = new JTextField(5);
        window.add(textField );

        b1 = new JButton("b1");
        window.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("b2");
        window.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("b3");
        window.add(b3);
        b3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event) {
        textField.setText("no answer");
        age = Integer.parseInt(tf.getText());
        if (event.getSource() == b1) {
            n1();
        }
        if (event.getSource() == b2) {
            n2();
        }
        if (event.getSource() == b3) {
            n3();
        }    
    }

    void n1() {
        if (age < 6) {
            textField.setText("child rate");
        }
        else {
            if (age < 16) {
                textField.setText("junior rate");
            }
            else {
                textField.setText("adult rate");
            }
        }
    }

    void n2() {
        if (age < 6) {
            textField.setText("child rate");
        }
        else if (age < 16) {
            textField.setText("junior rate");
        }
        else {
            textField.setText("adult rate");
        }
    }

    void n3() {
        if (age < 6) {
            textField.setText("child rate");
        }
        if ((age >= 6) && (age < 16)) {
            textField.setText("junior rate");
        }
        if (age >= 16) {
            textField.setText("adult rate");
        }
    }
}
