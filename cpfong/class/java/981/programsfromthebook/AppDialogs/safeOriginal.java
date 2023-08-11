import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogsDemo extends JFrame implements ActionListener {

    private JButton messageButton, inputButton, 
    confirmYesNoButton, confirmYesNoCancelButton;

    public static void main(String[] args) {
        DialogsDemo frame = new DialogsDemo();
        frame.setSize(400, 100);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        messageButton = new JButton("Basic Message Dialog");
        window.add(messageButton);
        messageButton.addActionListener(this);

        inputButton = new JButton("Input Dialog");
        window.add(inputButton);
        inputButton.addActionListener(this);

        confirmYesNoButton = new JButton("Confirm Dialog (yes/no)");
        window.add(confirmYesNoButton);
        confirmYesNoButton.addActionListener(this);

        confirmYesNoCancelButton = new JButton("Confirm Dialog (yes/no/cancel)");
        window.add(confirmYesNoCancelButton);
        confirmYesNoCancelButton.addActionListener(this);
    }

    //---------------STARTEXTRACT=dialogsdemo.xtr
    public void actionPerformed(ActionEvent event) {
        int replyCode;
        String input = "";

        if(event.getSource() == messageButton) {
            //---------------STARTEXTRACT=messagedialog.xtr
            JOptionPane.showMessageDialog(null, "Hello!");
            //---------------ENDEXTRACT=messagedialog.xtr        }
}
            if(event.getSource() == confirmYesNoButton) {
                //----------STARTEXTRACT=yesno.xtr
                replyCode = JOptionPane.showConfirmDialog(null,
                "Delete?","Delete it?", JOptionPane.YES_NO_OPTION);
                //----------ENDEXTRACT=yesno.xtr
                if(replyCode == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"Yes chosen");
                }
            }

            if(event.getSource() == inputButton) {
                //-----------STARTEXTRACT=inputdialog.xtr
                input = JOptionPane.showInputDialog(null, "Name?");
                //---------ENDEXTRACT=inputdialog.xtr
            }

            if(event.getSource() == confirmYesNoCancelButton) {
                //------------STARTEXTRACT=yesnocancel.xtr
                replyCode = JOptionPane.showConfirmDialog(null, 
                "Send the message?");
                //----------------ENDEXTRACT=yesnocancel.xtr
                if(replyCode == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null,"Cancel chosen");
                }
            }
        }
        //-------------------ENDEXTRACT=dialogsdemo.xtr
    }

