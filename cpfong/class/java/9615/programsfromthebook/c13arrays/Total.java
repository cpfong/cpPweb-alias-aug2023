
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Total extends JFrame implements ActionListener {

    private JButton button;
    private JTextField sumField;
    private JLabel label;
    private JTextField amount;
    private JTextArea data;
    private JTextField stats;

    private int[] table = {
        7, 8, 0, 4, 3, 8, 1};

    public static void main(String[] args) {
        Total frame = new Total();
        frame.setSize(250,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("sum");
        window.add(button);
        button.addActionListener(this);

        sumField = new JTextField(1);
        window.add(sumField);

        data = new JTextArea(10,10);
        window.add(data);
  
        display();
      }

    public void actionPerformed(ActionEvent event) {
        sumField.setText(Integer.toString(sum(table)));

        display();
    }

    private void display() {
        data.setText("");
        for (int dayNumber = 0; dayNumber <= 6; dayNumber++) {
            data.append("index " + Integer.toString(dayNumber)
                + " value " + Integer.toString(table[dayNumber])
                + "\r\n");
        }
    }

    private int sum(int[] array) {
        int total = 0;
        for (int integer : array) {
            total = total + integer;
        }
        return total;
    }
}
