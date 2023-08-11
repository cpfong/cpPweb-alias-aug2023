//-----------STARTEXTRACT=template.xtr
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StringTemplate extends JFrame
    implements ActionListener {

    private JTextField string1Field, string2Field, resultField;
    private JLabel string1Label, string2Label, resultLabel;
    private JButton goButton; 

    public static void main(String[] args) {
        StringTemplate frame = new StringTemplate();
        frame.setSize(250, 250);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        string1Label = new JLabel("Type string1: ");
        window.add(string1Label);

        string1Field = new JTextField(20);
        window.add(string1Field);

        string2Label = new JLabel("Type string2: ");
        window.add(string2Label);

        string2Field = new JTextField(20);
        window.add(string2Field);

        resultLabel = new JLabel("result is:    ");
        window.add(resultLabel);

        resultField = new JTextField(20);    
        window.add(resultField);

        goButton = new JButton("do it");
        window.add(goButton);
        goButton.addActionListener(this); 
    }

    public void actionPerformed(ActionEvent event) {
        String result ="";
        if (event.getSource() == goButton) {
            String string1 = string1Field.getText();
            String string2 = string2Field.getText();

            // string example - equals
            //.... insert your code here
            if(string1.equals(string2))
                result="They are equal.";
            else
                result="They are not equal.";
            // end of example

            resultField.setText(result);
        }   
    }
}
//---------------ENDEXTRACT=template.xtr
