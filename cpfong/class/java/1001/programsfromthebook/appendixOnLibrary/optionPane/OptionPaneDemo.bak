
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OptionPaneDemo extends JFrame implements ActionListener {

    private JButton button;

    public static void main(String[] args) {
        OptionPaneDemo frame = new OptionPaneDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
JOptionPane.showMessageDialog(null, "your message here");
String name = JOptionPane.showInputDialog("enter your name");
    }
}
