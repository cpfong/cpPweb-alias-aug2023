
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Display extends JFrame implements ActionListener {

    private JButton button;
    private JTextArea textArea;
    private ArrayList list = new ArrayList();

    public static void main(String[] args) {
        Display frame = new Display();
        frame.setSize(200,150);
        frame.createGUI();
        frame.show();
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

    private void display(ArrayList list) {
        String newLine = "\r\n";
        textArea.setText("");
        for (int index = 0; index < list.size(); index ++) {
            textArea.append(list.get(index) + newLine);
        }
    }
}
