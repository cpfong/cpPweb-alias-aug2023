import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AddAnItem extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton button;
    private JTextArea textArea;
    private ArrayList <String> list = new ArrayList <String>();

    public static void main(String[] args) {
        AddAnItem frame = new AddAnItem();
        frame.setSize(350,150);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textField = new JTextField(5);
        window.add(textField);

        button = new JButton("add an item");
        window.add(button);
        button.addActionListener(this);

        textArea = new JTextArea(7, 7);
        window.add(textArea);

        list.add("bread");
        list.add("milk");
        list.add("coffee");

        display(list);
    }

    public void actionPerformed(ActionEvent event) {
        addAnItem(list);
        display(list);
    }

    private void display(ArrayList <String> list) {
        String newLine = "\r\n";
        textArea.setText("");
        for (String string : list) {
            textArea.append(string + newLine);
        }
    }

    private void addAnItem(ArrayList <String> list) {
        list.add(textField.getText());
    }
}
