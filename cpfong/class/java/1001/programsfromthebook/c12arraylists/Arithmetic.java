import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Arithmetic extends JFrame implements ActionListener {

    private JButton newButton, sumButton, largestButton;
    private JTextArea textArea;
    private JTextField newField, sumField, largestField;

    private ArrayList numbers = new ArrayList();

    public static void main(String[] args) {
        Arithmetic frame = new Arithmetic ();
        frame.setSize(200,350);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        newButton = new JButton("new");
        window.add(newButton);
        newButton.addActionListener(this);

        newField = new JTextField(2);
        window.add(newField);

        textArea = new JTextArea(12, 5);
        window.add(textArea);

        sumButton = new JButton("sum");
        window.add(sumButton);
        sumButton.addActionListener(this);

        sumField = new JTextField(6);
        window.add(sumField);

        largestButton = new JButton("largest");
        window.add(largestButton);
        largestButton.addActionListener(this);

        largestField = new JTextField(6);
        window.add(largestField);


        numbers.add("34");
        numbers.add("67");
        numbers.add("54");
        numbers.add("5");
        numbers.add("99");
        numbers.add("32");
        numbers.add("45");
        numbers.add("67");
        numbers.add("12");
        numbers.add("39");
        numbers.add("73");
        numbers.add("52");

        display(numbers);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == sumButton) {
            getSum(numbers);
        }
        if (event.getSource() == largestButton) {
            getLargest(numbers);
        }
    }

    private void getSum(ArrayList numbers) {

        int sum = 0;

        for (int index = 0; index < numbers.size(); index ++) {
            int number = Integer.parseInt((String) (numbers.get(index)));
            sum = sum + number;
        } 
        sumField.setText(Integer.toString(sum));
    }

    private void display(ArrayList numbers) {
        String newLine = "\r\n";
        textArea.setText("");
        for (int index = 0; index < numbers.size(); index ++) {
            textArea.append(numbers.get(index) + newLine);
        }
    }

    private void getLargest(ArrayList numbers) {
        int largest;

        largest = Integer.parseInt((String) (numbers.get(0)));
        for (int index = 0; index < numbers.size(); index++) {
            int number = Integer.parseInt((String) (numbers.get(index)));
            if (number > largest) {
                largest = number;
            }
        } 
        largestField.setText(Integer.toString(largest));
    }
}
