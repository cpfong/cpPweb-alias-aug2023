import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HappyOrSad extends JFrame implements ActionListener {

    private JButton happyButton, sadButton;
     private JPanel panel;

    private ImageIcon happyImage, sadImage;



    public static void main(String[] args) {
        HappyOrSad demo = new HappyOrSad();
        demo.setSize(100,100);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

                panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

happyButton = new JButton("happy");
        window.add(happyButton);
        happyButton.addActionListener(this);

        sadButton= new JButton("sad");
        window.add(sadButton);
        sadButton.addActionListener(this);

        happyImage = new ImageIcon("c:/happy.jpg");
        sadImage = new ImageIcon("c:/sad.jpg");

    }

    public void actionPerformed(ActionEvent event) {
                Graphics paper = panel.getGraphics();
Object source = event.getSource();
        if (source == happyButton) {
        happy.paintIcon(this, paper, 10, 10);

        }
        else {
          sad.paintIcon(this, paper, 10, 10);

        }
    }
}
