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
        frame.show();
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

    public void actionPerformed(ActionEvent event) {
        int replyCode;
        String input = "";

        if(event.getSource() == messageButton) {
            JOptionPane.showMessageDialog(null, "Hello!");
        }
        if(event.getSource() == confirmYesNoButton) {
            replyCode = JOptionPane.showConfirmDialog(null,
                "Delete?","Delete it?", JOptionPane.YES_NO_OPTION);
            if(replyCode == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,"Yes chosen");
            }
        }

        if(event.getSource() == inputButton) {
            input = JOptionPane.showInputDialog(null, "Name?");
        }

        if(event.getSource() == confirmYesNoCancelButton) {
            replyCode = JOptionPane.showConfirmDialog(null, 
                "Send the message?");
            if(replyCode == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null,"Cancel chosen");
            }
        }
    }
}
