try {
    inFile = new BufferedReader(new
        FileReader("myfile.txt"));
}
catch (FileNotFoundException e) {
    errorField.setText("missing file-try again!");
}



-----------------------

private void openFile() throws IOException {
    inFile = new BufferedReader(new 
        FileReader("myfile.txt"));
}


--------

int a[] = new int[10];       // 0 to 9 inclusive
for(int n = 0; n <= 10; n++) {
    a[n] = 0;


----------------

String line;
try {
    while ((line = myFile.readLine() ) ! = null) {
        // process line
    }
}
catch (IOException e) {
    errorField.setText("Error in file input");
}
finally {
    myFile.close();
}



-----------




































--------excepdemo1
import java.awt.*;
import java.****applet.****applet;
import java.util.*;
import java.awt.event.*;
public class ExceptionDemo1 extends ****applet
    implements ActionListener {
    private TextField stringField;
    private TextField resultField;
    private Label resultLabel, stringLabel;
    public void init() {
        stringLabel = new Label("Type an integer: ");
        resultLabel = new Label("Answer: ");
        stringField = new TextField(20);
        resultField = new TextField(20);
        resultField.setEditable(false);
        add(stringLabel);
        add(stringField);
        stringField.addActionListener(this);
        add(resultLabel);
        add(resultField);
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == stringField) {
            try{
                int number = Integer.parseInt(stringField.getText());
                resultField.setText("Doubled value is "+(2*number));
            }
            catch (NumberFormatException e) {
                resultField.setText("Error in number: retype ");
            }
        }
    }
}



-----------------------------
















