import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo extends JFrame implements ListSelectionListener {

    private JList list;
    private DefaultListModel listModel;
    private JTextField textField;

    public static void main(String[] args) {
        ListDemo frame = new ListDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        listModel = new DefaultListModel();

        listModel.addElement("Mike");
        listModel.addElement("Maggie");
        listModel.addElement("Matthew");
        listModel.addElement("Eleanor");

        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);
        window.add(new JScrollPane(list));

        textField = new JTextField(15);
        window.add(textField);
    }

    public void valueChanged(ListSelectionEvent event) {
        int  index = list.getSelectedIndex();
        String item = (String) list.getSelectedValue();
        textField.setText("item " + Integer.toString(index)
            + " - " + item + " selected");
    }
}
