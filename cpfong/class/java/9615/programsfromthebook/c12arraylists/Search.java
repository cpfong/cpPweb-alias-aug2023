import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Search extends JFrame implements ActionListener {

    private JButton button;
    private JTextArea textArea;
    private JTextField textField;

    private ArrayList <String> list = new ArrayList <String>();

    public static void main(String[] args) {
        Search frame = new Search ();
        frame.setSize(300,200);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textArea = new JTextArea(6, 6);
        window.add(textArea);

        button = new JButton("find item");
        window.add(button);
        button.addActionListener(this);

        textField = new JTextField(6);
        window.add(textField);

        list.add("eggs");
        list.add("sugar");
        list.add("milk");
        list.add("butter");
        list.add("coffee");
        list.add("tea");

        display(list);

    }

    public void actionPerformed(ActionEvent event) {
        search(list);
    }

    private void display(ArrayList <String> list) {
        String newLine = "\r\n";
        textArea.setText("");
        for (String string : list) {
            textArea.append(string + newLine);
        }
    }


    private void search(ArrayList <String> list) {

        int length; 
        int index;
        boolean found; 
        String itemWanted; 

        length = list.size();

        itemWanted = textField.getText();

        found = false;
        index = 0;
        while ((found == false) && (index < length)) {        
            if ((list.get(index)).equals(itemWanted)) {
                found = true;
                JOptionPane.showMessageDialog(null, "Item found");
            }
            else {
                index++;
            }
        }
    }


}
