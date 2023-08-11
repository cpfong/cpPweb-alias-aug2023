import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Voting extends JFrame implements ActionListener {

    private JLabel greetingLabel;
    private JTextField ageField;
    private JButton button;
    private JTextField decisionField;
    private JTextField commentaryField;
    private JTextField signOffField;

    public static void main(String[] args) {
        Voting demo = new Voting();
        demo.setSize(125,200);
        demo.createGUI();
        demo.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        greetingLabel = new JLabel("enter your age");
        window.add(greetingLabel);

        ageField = new JTextField(5);
        window.add(ageField);

        button = new JButton("check");
        window.add(button);
        button.addActionListener(this);

        decisionField = new JTextField(10);
        window.add(decisionField);

        commentaryField = new JTextField(10);
        window.add(commentaryField);

        signOffField = new JTextField(10);
        window.add(signOffField);
    }

    public void actionPerformed(ActionEvent event) {
        int age;

        age = Integer.parseInt(ageField.getText());
        if (age > 17) 
        {
            decisionField.setText("you may vote");
            commentaryField.setText("congratulations");
        }
        else
        {
            decisionField.setText("you may not vote");
            commentaryField.setText("sorry");
        }
        signOffField.setText("Best Wishes");
    }
}
