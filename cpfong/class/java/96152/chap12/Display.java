import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Display extends JFrame implements ActionListener {

    private JButton button;
    private JTextArea textArea;
    private ArrayList <String> list = new ArrayList <String>();

    public static void main(String[] args) {
        Display frame = new Display();
        frame.setSize(200,150);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textArea = new JTextArea(7, 7);
        window.add(textArea);

        button = new JButton("display");
        window.add(button);
        button.addActionListener(this);

        list.add("bread");
        list.add("milk");
        list.add("coffee");
    }

    public void actionPerformed(ActionEvent event) {
        display(list);
    }

    private void display(ArrayList <String> list) {
        String newLine = "\r\n";
        textArea.setText("");
        for (String string : list) {
            textArea.append(string + newLine);
        }
    }
}
