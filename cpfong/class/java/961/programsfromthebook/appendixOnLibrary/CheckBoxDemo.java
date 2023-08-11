//latest template  30 oct
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxDemo extends JFrame implements ItemListener {

    private JCheckBox cola, burger, fries;
    private JTextArea textArea;

    public static void main(String[] args) {
        CheckBoxDemo frame = new CheckBoxDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        cola = new JCheckBox("cola");
        window.add(cola);
        cola.addItemListener(this);

        burger = new JCheckBox("burger");
        window.add(burger);
        burger.addItemListener(this);

        fries = new JCheckBox("fries");
        window.add(fries);
        fries.addItemListener(this);

        textArea = new JTextArea(5,3);
        window.add(textArea);
    }

    public void itemStateChanged(ItemEvent event) {
        String newLine = "\r\n";
        textArea.setText("");
        if (cola.isSelected()) {
            textArea.append("cola selected" + newLine);
        }
        if (burger.isSelected()) {
            textArea.append("burger selected" + newLine);
        }
        if (fries.isSelected()) {
            textArea.append("fries selected" + newLine);
        }
    }
}
