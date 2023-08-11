//--------------STARTEXTRACT=logomethod.xtr
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderDemo extends JFrame 
implements ActionListener {

    private JButton button1, button2;
    private JPanel drawingPanel, buttonPanel;

    public static void main(String[] args) {
        BorderDemo frame = new BorderDemo();
        frame.setSize(350, 300);
        frame.createGUI();
        frame.show();
    }
//  paste to word
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new BorderLayout());
        buttonPanel = new JPanel();

        drawingPanel = new JPanel();
        drawingPanel.setBackground(Color.white);

        button1 = new JButton("button1");
        buttonPanel.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("button2");
        buttonPanel.add(button2);
        button2.addActionListener(this);

        window.add("South", buttonPanel);
        window.add("Center", drawingPanel);
    }
// end paste to word
    public void actionPerformed(ActionEvent event) {
        Graphics paper = drawingPanel.getGraphics();
        paper.drawLine(0, 0, 100, 100);
    }
}
