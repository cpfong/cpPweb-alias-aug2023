import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuDemo extends JFrame implements ActionListener {

    JMenuBar wholeMenuBar;
    JMenu fileMenu, editMenu;
    JMenuItem openItem, saveItem, copyItem, pasteItem;
    JButton quitButton;
    JTextField textField;

    public static void main(String args[]) {
        MenuDemo frame = new MenuDemo();
        frame.setSize(250, 200);
        frame.createGUI();
        frame.show();
    }

    public void createGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        wholeMenuBar = new JMenuBar();
        setJMenuBar(wholeMenuBar);

        // file menu, with  Open, save
        fileMenu = new JMenu("File");

        openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        openItem.addActionListener(this);

        saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        saveItem.addActionListener(this);

        wholeMenuBar.add(fileMenu);

        // edit menu, with  copy, paste
        editMenu = new JMenu("Edit");

        copyItem = new JMenuItem("Copy");
        editMenu.add(copyItem);
        copyItem.addActionListener(this);

        pasteItem = new JMenuItem("Paste");
        editMenu.add( pasteItem );
        pasteItem.addActionListener(this);

        wholeMenuBar.add(editMenu );

        quitButton = new JButton("Quit");
        window.add(quitButton);
        quitButton.addActionListener(this);

        textField = new JTextField(10);
        window.add(textField);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
            textField.setText("Open chosen");
        }
        if (e.getSource() == saveItem) {
            textField.setText("Save chosen");
        }
        if (e.getSource() == copyItem) {
            textField.setText("Copy chosen");
        }
        if (e.getSource() == pasteItem) {
            textField.setText("Paste chosen");
        }
        if(e.getSource() == quitButton) {
            System.exit(0);
        }
    }
}

