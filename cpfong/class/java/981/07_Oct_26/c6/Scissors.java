import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Scissors extends JFrame 
    implements ActionListener {

    private JButton button;
    private JPanel panel, panel2;
    private JTextField fileField;

    public static void main (String[] args) {
        Scissors frame = new Scissors();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
   }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 100));
        panel.setBackground(Color.white);
        window.add(panel);

        fileField = new JTextField(3);
        window.add(fileField);
        
        panel2= new JPanel();
        panel2.setPreferredSize(new Dimension(150, 100));
        panel2.setBackground(Color.white);
        window.add(panel2);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        ImageIcon myImage = new ImageIcon("scissors.jpg");
        myImage.paintIcon(this, paper, 10,10);

		fileField.setText("=");
        Graphics paper2 = panel2.getGraphics();
        ImageIcon myImage2 = new ImageIcon("scissors.jpg");
        myImage2.paintIcon(this, paper2, 10,10);
    }
}

