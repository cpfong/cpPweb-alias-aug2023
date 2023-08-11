
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimerDemo extends JFrame implements ActionListener {

    Timer timer;

    public static void main(String[] args) {
        TimerDemo frame = new TimerDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        timer = new Timer(10000, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "tick");
    }
}
