
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScrollingTextArea extends JFrame implements ActionListener {

    private JButton button;
    private JTextArea textArea;

    public static void main(String[] args) {
        ScrollingTextArea frame = new ScrollingTextArea();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("display");
        window.add(button);
        button.addActionListener(this);

        textArea = new JTextArea(10, 10);
        JScrollPane scrollPane = new JScrollPane(textArea);
        window.add(scrollPane);
    }

    public void actionPerformed(ActionEvent event) {
        String newLine = "\r\n";
        textArea.setText("");
        for (int count = 0; count < 100; count++) {
            textArea.append("line " + count + newLine);
        }
    }
}
