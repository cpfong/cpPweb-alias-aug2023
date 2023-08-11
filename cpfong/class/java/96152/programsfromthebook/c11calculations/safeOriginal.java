//latest template  20 oct
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Sine extends JFrame implements ActionListener {

    private JButton button;
    private JTextField textField;

    public static void main (String []  args) {
        Sine frame = new Sine();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

                textField = new JTextField(5);
window.add(textField);

        button = new JButton("calculate sine");
        window.add(button);
        button.addActionListener(this);
    }


    public void actionPerformed(ActionEvent event) {
        textField.setText(Double.toString(sin(Math.PI/6.0)));
    }

private double sin(double x) {
    double term, result;

    result = 0.0;
    term = x;
    for ( int n = 1; Math.abs(term) >= 0.0001; n = n + 2 ) { 
        result = result + term;
        term = - term * x * x / ((n + 1) * (n + 2));
    }
    return result;
}

}
