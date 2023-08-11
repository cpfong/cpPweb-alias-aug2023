import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class FileChooserDemo extends JFrame 
implements ActionListener {
    private JButton openButton, saveButton;
    private JFileChooser fileChooser; 
    private JTextField nameField;

    public static void main(String [] args) {
        FileChooserDemo frame = new FileChooserDemo();
        frame.setSize(300, 150);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        openButton = new JButton("open");
        window.add(openButton);
        openButton.addActionListener(this);

        saveButton = new JButton("save");
        window.add(saveButton);
        saveButton.addActionListener(this);

        nameField = new JTextField(25);
        window.add(nameField);
    }

    public void actionPerformed(ActionEvent event) { 
        File  selectedFile;
        int reply;
        if (event.getSource() == saveButton) {
            fileChooser = new JFileChooser();
            reply = fileChooser.showSaveDialog(this);
            if(reply == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                nameField.setText(selectedFile.getAbsolutePath());
            }
        }
        if (event.getSource() == openButton) {
            fileChooser = new JFileChooser();
            reply = fileChooser.showOpenDialog(this);
            if(reply == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                nameField.setText(selectedFile.getAbsolutePath());
            }
        }
    }
}

