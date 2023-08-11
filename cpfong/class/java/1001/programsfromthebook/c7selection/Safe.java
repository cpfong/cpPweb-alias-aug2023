import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Safe extends JFrame implements ActionListener {

    private JLabel greetingLabel;
    private JTextField codeField;
    private JButton button;
    private JTextField outcomeTextField;

    public static void main(String[] args) {
        Safe demo = new Safe();
        demo.setSize(100,150);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        greetingLabel = new JLabel("enter code");
        window.add(greetingLabel);

        codeField = new JTextField();
        window.add(codeField);

        button = new JButton("unlock");
        window.add(button);
        button.addActionListener(this);

        outcomeTextField = new JTextField();
        window.add(outcomeTextField);
    }

    public void actionPerformed(ActionEvent event) {
        String codeString; 
        int code;

        codeString = codeField.getText();
        code = Integer.parseInt(codeString);
        if (code == 23) {
            outcomeTextField.setText("unlocked");
        }
    }
}
