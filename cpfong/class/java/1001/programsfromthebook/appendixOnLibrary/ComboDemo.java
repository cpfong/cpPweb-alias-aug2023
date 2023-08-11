//latest template  30 oct
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboDemo extends JFrame implements ActionListener {

    private JComboBox combo;
    private JTextField textField;

    public static void main(String[] args) {
        ComboDemo frame = new ComboDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        combo = new JComboBox();

        combo.addItem("red");
        combo.addItem("blue");
        combo.addItem("yellow");

        combo.addActionListener(this);
        window.add(combo);

        textField = new JTextField(15);
        window.add(textField);
    }

    public void actionPerformed(ActionEvent event) {
        int  index = combo.getSelectedIndex();
        String item = (String) combo.getSelectedItem();
        textField.setText("item " + Integer.toString(index)
            + ", " + item + " selected");
    }
}
