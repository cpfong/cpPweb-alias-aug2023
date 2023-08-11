
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exception extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        Exception frame = new Exception();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int[] table = new int[10];

        for (int index = 0; index <= 10; index++) {   // warning, erroneous
            table[index] = 0;
        }

    }
}
