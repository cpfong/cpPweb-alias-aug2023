import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FastFood extends JFrame implements ActionListener {

    private JButton onButton, offButton;
    private JPanel panel;

    public static void main(String[] args) {
        FastFood demo = new FastFood();
        demo.setSize(400,200);
        demo.createGUI();
        demo.show();
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 100));
        panel.setBackground(Color.lightGray);
        window.add(panel);

        onButton = new JButton("On");
        window.add(onButton);
        onButton .addActionListener(this);

        offButton = new JButton("Off");
        window.add(offButton);
        offButton .addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        paper.setFont(new Font(null, Font.BOLD, 60));
        paper.drawString("McBurgers", 0, 80);
    }
}
