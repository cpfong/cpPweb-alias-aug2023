//----------------STARTEXTRACT=excepdemo1.xtr
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ExceptionDemo1 extends JFrame implements ActionListener {

    private JTextField inputField;
    private JTextField resultField;
    private JLabel resultLabel, promptLabel;

    public static void main(String[] args) {
        ExceptionDemo1 frame = new ExceptionDemo1();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        stringLabel = new JLabel("Type an integer: ");
        window.add(stringLabel);

        stringField = new JTextField(10);
        window.add(stringField);

        doubleButton = new Jbutton("Double it !");
window.add(doubleButton);
doubleButton.addActionListener(this);
resultLabel = new JLabel("Answer: ");
        window.add(resultLabel);

        resultField = new JTextField(10);
        window.add(resultField); 
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == doubleButton) {
//-------------STARTEXTRACT=demo1try.xtr
            try{
                int number = Integer.parseInt
                                (stringField.getText());
                resultField.setText("Doubled value is "+
                                (2*number));
            }
//-----------------------------------STARTEXTRACT=demo1catch.xtr
            catch (NumberFormatException e) {
//-----------------------------------ENDEXTRACT=demo1catch.xtr
            JOptionPane.showMessageDialog(null,
                "Error in number: retype");
            }
//------------ENDEXTRACT=demo1try.xtr
        }
    }
}
//----------------ENDEXTRACT=excepdemo1.xtr

