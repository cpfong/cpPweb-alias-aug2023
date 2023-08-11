import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; //StringTokenizer
import java.io.*;

public class FileSearch extends JFrame
    implements ActionListener {

    private BufferedReader inFile;
    private Button searchButton;
    private JTextField result1Field;
    private JTextField result2Field;
    private JTextField personField;
    private JTextField fileNameField;
    private String fileName;
    private JLabel result1Label, result2Label;
    private JLabel personNameLabel;
    private JLabel fileLabel;

    public static void main (String [ ] args) {
        FileSearch frame = new FileSearch();
        frame.setSize(400, 150);
        frame.createGUI();
        frame.show();
    }


    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        fileLabel = new JLabel("File name:");
        window.add(fileLabel);

        fileNameField = new JTextField(25);
        fileNameField.setText("");
        window.add(fileNameField);

        personNameLabel = new JLabel("Type Name:");
        window.add(personNameLabel);

        personField = new JTextField(15);
        personField.setText("");
        window.add(personField);

        searchButton = new Button("Search for name");
        window.add(searchButton);
        searchButton.addActionListener(this);

        result1Label = new JLabel("Result1:");
        window.add(result1Label);

        result1Field = new JTextField(5);
        result1Field.setEditable(false);
        window.add(result1Field);

        result2Label = new JLabel("Result2:");
        window.add(result2Label);

        result2Field= new JTextField(5);
        result2Field.setEditable(false);
        window.add(result2Field);
    }


    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == searchButton) {
            result1Field.setText("");
            result2Field.setText("");
            fileName = fileNameField.getText();
            try {
                inFile = new BufferedReader(
                    new FileReader(fileName));
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                "Can’t find file: " + fileNameField.getText());
                return;
            }

            // now read the file
            try {
                String line;
                boolean found = false;
                while (( ( line = inFile.readLine() ) != null)
                    && (! found)) {
                    // tokens split on commas, spaces
                    StringTokenizer tokens = new
                        StringTokenizer( line, " ,");
                    String nameInFile = tokens.nextToken();
                    if (personField.getText().equals(nameInFile)) {
                        found = true;
                        result1Field.setText(tokens.nextToken());
                        result2Field.setText(tokens.nextToken());
                    }
                }
                inFile.close();
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(null, 
                    "Error reading file "+ fileName + 
                    ": " + e.toString());
            }
        }
    }
  
} 



