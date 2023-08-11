
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Rainfall extends JFrame implements ActionListener {

    private JButton button;
    private JTextField day;
    private JLabel label;
    private JTextField amount;
    private JTextArea data;
    private JTextField stats;

    private int[] rain = {
        7, 8, 0, 4, 3, 8, 1                        };

    public static void main (String[] args) {
        Rainfall frame = new Rainfall();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        button = new JButton("change value at");
        window.add(button);
        button.addActionListener(this);

        day = new JTextField(1);
        window.add(day);

        label = new JLabel("to");
        window.add(label);

        amount = new JTextField(2);
        window.add(amount);

        data = new JTextArea(10, 10);
        window.add(data);

        stats = new JTextField(12);
        window.add(stats);

        display();
        largest();
    }

    public void actionPerformed(ActionEvent event) {
        newValue();
    }

    private void display() {
        data.setText("");
data.setTabSize(4);
        for (int dayNumber = 0; dayNumber <= 6; dayNumber++) {
            data.append("day " + Integer.toString(dayNumber)
                + " rain " + Integer.toString(rain[dayNumber])
                + "\r\n");
        }
    }

    private void newValue() {
        int index; 
        int data; 
        index = Integer.parseInt(day.getText());
        data = Integer.parseInt(amount.getText());
        rain[index] = data;
        display();
        largest();
    }

    private void largest() {
        int highest; 

        highest = rain[0];
        for (int index = 0; index <= 6; index++) {
            if (highest < rain[index]) {
                highest = rain[index];
            }
        }
        stats.setText("largest value is " + Integer.toString(highest));
    }


    private void weekTotal() {
        int total = 0;

        for (int index = 0; index <= 6; index++) {
            total = total + rain[index];
        }
        stats.setText("total is " + Integer.toString(total));
    }


}
