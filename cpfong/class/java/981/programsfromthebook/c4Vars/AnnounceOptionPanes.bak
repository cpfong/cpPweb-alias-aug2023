import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnnounceOptionPanes extends JFrame
   implements ActionListener {

    private JButton button;

    public static void main(String[] args) {
        AnnounceOptionPanes frame = new AnnounceOptionPanes();
        frame.setSize(400, 300);
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
        String name;
        name = JOptionPane.showInputDialog("Who are you?");   
        JOptionPane.showMessageDialog(null,name + 
            " has just entered the building.");
    }
}



