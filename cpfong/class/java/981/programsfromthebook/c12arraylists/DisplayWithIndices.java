import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DisplayWithIndices extends JFrame implements ActionListener {

    private JButton button;
    private JTextArea textArea;
    private ArrayList <String> list = new ArrayList <String>();

    public static void main(String[] args) {
        DisplayWithIndices frame = new DisplayWithIndices ();
        frame.setSize(250,150);
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
        displayWithIndices(list);
    }

    private void displayWithIndices(ArrayList <String> list) {
        String newLine = "\r\n";
        String tab = "\t";
        textArea.setTabSize(3);
        textArea.setText("");
        for (int index = 0; index < list.size(); index ++) {
            textArea.append(Integer.toString(index)
                            + tab
                            + list.get(index) + newLine);
        }
    }

}
