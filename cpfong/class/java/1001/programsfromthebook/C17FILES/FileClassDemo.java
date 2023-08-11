import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 
import java.io.*;

class FileClassDemo extends JFrame
implements  ActionListener {
    private JButton startButton;

    public static void main (String [] args) {
        FileClassDemo frame = new FileClassDemo();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        startButton = new JButton("start");
        window.add(startButton);
        startButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == startButton) {
            File myFile = new File("c:\\temp\\java\\demo.txt");
            String parent = myFile.getParent();
            JOptionPane.showMessageDialog(null,
                                     "Parent is: " + parent);

            String absolute = myFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null,
                            "Absolute path is: " + absolute);
            boolean isThere = myFile.exists();
 

            String name = myFile.getName();
            JOptionPane.showMessageDialog(null, 
                                          "Name is: "+ name);


            boolean checkDirectory = myFile.isDirectory();
            long myLength = myFile.length();
            String [] allFiles = myFile.list();
        }

    }
}


