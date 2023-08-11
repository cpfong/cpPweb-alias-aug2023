import java.awt.*;
import java.awt.event.*;

public class SumTextFieldsAWT extends Frame //frame
    implements WindowListener, ActionListener { 

    private TextField number1Field, number2Field, sumField;
    private Label equalsLabel;
    private Button plusButton;

    public static void main(String[] args) {
        SumTextFieldsAWT frame = new SumTextFieldsAWT();
        frame.setSize(350, 100);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() { 
        setLayout(new FlowLayout());

        number1Field = new TextField(7);
        add(number1Field);

        plusButton = new Button("+");
        add(plusButton);
        plusButton.addActionListener(this);

        number2Field = new TextField(7);
        add(number2Field);

        equalsLabel = new Label("  =  ");
        add(equalsLabel);

        sumField = new TextField(7);
        add(sumField);

        addWindowListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int number1 = Integer.parseInt(number1Field.getText());
        int number2 = Integer.parseInt(number2Field.getText());
        sumField.setText(Integer.toString(number1 + number2));
    }

 // standard code for window closing, etc...
 
     public void windowClosing(WindowEvent e) {
         System.exit(0);
     }
    
     //empty WindowListener Methods
     public void windowIconified(WindowEvent e) {
     }
     public void windowOpened(WindowEvent e) {
     }
     public void windowClosed(WindowEvent e) {
     }
     public void windowDeiconified(WindowEvent e) {
     }
     public void windowActivated(WindowEvent e) {
     }
     public void windowDeactivated(WindowEvent e) {
     } 
//end of standard window code
}
