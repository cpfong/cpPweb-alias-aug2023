import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExceptionDemo1 extends JFrame implements ActionListener {

    private JTextField inputField;
    private JTextField resultField;
    private JLabel resultLabel, inputLabel;
    private JButton doubleButton;

    public static void main(String[] args) {
        ExceptionDemo1 frame = new ExceptionDemo1();
        frame.setSize(300, 150);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        inputLabel = new JLabel("Integer: ");
        window.add(inputLabel);

        inputField = new JTextField(10);
        window.add(inputField);

        doubleButton = new JButton("Double it !");
        window.add(doubleButton);
        doubleButton.addActionListener(this);

        resultLabel = new JLabel("Doubled value is: ");
        window.add(resultLabel);

        resultField = new JTextField(10);
        window.add(resultField); 
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == doubleButton) {
            resultField.setText("");
            try{
                int number = Integer.parseInt
                    (inputField.getText());
                resultField.setText(Integer.toString(2*number));
            }
            catch (NumberFormatException errorObject) {
                JOptionPane.showMessageDialog(null,
                    "Error in number: retype");
            }
        }
    }
}


