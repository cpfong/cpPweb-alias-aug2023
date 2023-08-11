
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DisplayAnItem extends JFrame implements ActionListener {

    private JButton button;
    private JTextArea textArea;
    private JTextField indexTextField, value;

    private ArrayList <String> list = new ArrayList <String>();

    public static void main(String[] args) {
        DisplayAnItem frame = new DisplayAnItem();
        frame.setSize(400,200);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textArea = new JTextArea(6, 6);
        window.add(textArea);

        button = new JButton("display item number");
        window.add(button);
        button.addActionListener(this);

        indexTextField = new JTextField(2);
        window.add(indexTextField);

        value = new JTextField(5);
        window.add(value);

        list.add("eggs");
        list.add("milk");
        list.add("butter");
        list.add("coffee");
        list.add("tea");

        display(list);

    }

    public void actionPerformed(ActionEvent event) {
        displayItem(list);
    }

    private void display(ArrayList <String> list) {
        String newLine = "\r\n";
        textArea.setText("");
        for (String string : list) {
            textArea.append(string + newLine);
        }
    }


    private void displayItem(ArrayList <String> list) {

        int index; 

        index = Integer.parseInt(indexTextField.getText());
        value.setText(list.get(index));
    }

}
