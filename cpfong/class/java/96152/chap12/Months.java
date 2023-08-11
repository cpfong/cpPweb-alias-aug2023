
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Months extends JFrame implements ActionListener {

    private JLabel monthLabel = new JLabel("month");
    private JTextField monthNumberTextField;
    private JButton button;
    private JTextField monthNameTextField;

    ArrayList months = new ArrayList();

    public static void main(String[] args) {
        Months frame = new Months();
        frame.setSize(250,100);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        monthLabel = new JLabel("month");
        window.add(monthLabel);

        monthNumberTextField = new JTextField(2);
        window.add(monthNumberTextField);


        button = new JButton("is");
        window.add(button);
        button.addActionListener(this);

        monthNameTextField = new JTextField(5);
        window.add(monthNameTextField);

        months.add("January");
        months.add("February");
        months.add("March");
    }

    public void actionPerformed(ActionEvent event) {

        int monthNumber; 
        String monthName; 

        monthNumber = Integer.parseInt(monthNumberTextField.getText());
        monthName = (String) months.get(monthNumber - 1);
        monthNameTextField.setText(monthName);
    }
}
