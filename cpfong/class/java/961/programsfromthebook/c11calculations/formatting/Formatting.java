
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat ;


class Formatting extends JFrame implements ActionListener {

    private JButton button;
    private JTextField status, actual, expected;

    public static void main(String[] args) {
        Formatting frame = new Formatting();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        button = new JButton("test");
        window.add(button);
        button.addActionListener(this);

        status = new JTextField(10);
        window.add(status);

        actual = new JTextField(10);
        window.add(actual);

        expected = new JTextField(10);
        window.add(expected );
    }

    public void actionPerformed(ActionEvent event) {
        int i = 123;
        DecimalFormat formatter = new DecimalFormat("###");
        actual.setText(formatter.format(i));

        expected.setText("123");
        test();

        i = 123;
        formatter = new DecimalFormat("00000");
        actual.setText(formatter.format(i));

        expected.setText("00123");
        test();

        // For large numbers, commas can make the number more readable. 

        i = 123456;
        formatter = new DecimalFormat("###,###");
        actual.setText(formatter.format(i));

        expected.setText("123,456");
        test();

        // double values are to be displayed. In this example: 

        double d = 12.34;
        formatter = new DecimalFormat("###.##");
        actual.setText(formatter.format(d));

        expected.setText("12.34");
        test();

        // display floating point numbers in scientific notation, using the letter E within the formatting information:

        double number = 12300000;
        formatter = new DecimalFormat("0.###E0");
        actual.setText(formatter.format(number));

        expected.setText("1.23E7");
        test();

        // Finally, money values can be displayed using the letter $ within the pattern. For example:

        double money = 12.34;
        formatter = new DecimalFormat("$###.##");
        actual.setText(formatter.format(money));

        expected.setText("$12.34");
        test();
    }

    private void test() {
        if (! expected.getText().equals(actual.getText())) {
            status.setText("error");
            JOptionPane.showMessageDialog(null, "");
        }
    }
}
